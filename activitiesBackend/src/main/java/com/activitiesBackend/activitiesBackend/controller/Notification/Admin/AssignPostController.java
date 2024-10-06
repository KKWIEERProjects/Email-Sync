package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
public class AssignPostController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/admin/assign")
    public ModelAndView getAssign(HttpSession session){

        return new ModelAndView("admin/assign").addObject("coos",userManageService.getWorkers(
                (String) session.getAttribute("id")
        )).addObject("notifications",assignService.getPost(
                (String) session.getAttribute("user")
        ));

    }
//    @PostMapping("/admin/assign")
//    public List<Assign> assignAPost(@RequestParam String event, @RequestParam String coo, @RequestParam String info){
//
//        assignService.setPost(event, coo, info);
//
//        return assignService.getPost(coo);
//
//    }


    @PostMapping("/admin/assign")
    public ModelAndView assignAPost(@RequestParam String event, @RequestParam String coo, @RequestParam String info){

        assignService.setPost(event, coo, info);

        return new ModelAndView("admin/assign");

    }

}
