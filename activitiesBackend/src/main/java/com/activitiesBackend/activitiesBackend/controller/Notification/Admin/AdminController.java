package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;


import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
public class AdminController {


    @Autowired
    private UserManageService userManageService;

    @GetMapping("/admin")
    public ModelAndView getAdmin(HttpSession session){
        System.out.println("Inside admin");
        String id=(String) session.getAttribute("id");
        return new ModelAndView("admin/admin").addObject("coos",userManageService.getWorkers(id));
    }

}
