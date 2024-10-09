package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("fullname")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
public class AssignPostController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private UserManageService userManageService;

    @PostMapping("/admin/assign")
    public void assignAPost(@RequestParam String event, @RequestParam String coo, @RequestParam String info){

        assignService.setPost(event, coo, info);



    }

}
