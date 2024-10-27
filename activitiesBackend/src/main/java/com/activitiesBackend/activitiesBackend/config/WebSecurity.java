package com.activitiesBackend.activitiesBackend.config;

import com.activitiesBackend.activitiesBackend.util.UserServiceImpl;
import com.activitiesBackend.activitiesBackend.model.UserDetailModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;


/**
 * galti se bhi touch maat karna
 * kuch kiya to chaku lekar piche padunga me
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
@PropertySource(
        ignoreResourceNotFound = false,
        value = "classpath:dbcofig.properties")
public class WebSecurity {

//    @Bean
//    JavaMailSender javaMailSender(){
//        return new JavaMailSenderImpl();
//    }



    @Bean
    UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(authenticationProvider());
       // http.csrf().disable();

        http.  csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/login/**","/js/**").permitAll()
                        .requestMatchers("https://cdnjs.cloudflare.com/**", "https://fonts.googleapis.com/**", "https://fonts.gstatic.com/**","https://stackpath.bootstrapcdn.com/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .permitAll()
                )
                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)  // Invalidate the session
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.
                build();
    }
}

class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * session management
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        UserDetailModel userDetails = (UserDetailModel)  authentication.getPrincipal();
        request.getSession().setAttribute("user", authentication.getName());
        request.getSession().setAttribute("fullname", userDetails.getUsername());
        request.getSession().setAttribute("id",userDetails.getId());
        // Redirect to default URL or any other logic
        response.sendRedirect("/notify");
    }




}
