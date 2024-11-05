package com.activitiesBackend.activitiesBackend.controller.Profile;

import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.EmailAddressException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProfileController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/profile")
    public ModelAndView modelAndView(HttpSession session) throws Exception{
        String id=(String) session.getAttribute("id");
        User user=userManageService.getUser(id);
        return new ModelAndView("profile").addObject("user",user);
    }

    @PostMapping("/profile/email")
    public ModelAndView moemail(HttpSession session, @RequestParam String email) throws EmailAddressException,Exception{
        String id=(String) session.getAttribute("id");
        userManageService.changeEmail(id, email);
        return new ModelAndView("redirect:/profile");
    }

    @PostMapping("/profile/token")
    public ModelAndView token(HttpSession session, @RequestParam String token) throws Exception{
        String id=(String) session.getAttribute("id");
        userManageService.changeToken(id,token);
        return new ModelAndView("redirect:/profile");
    }

}
