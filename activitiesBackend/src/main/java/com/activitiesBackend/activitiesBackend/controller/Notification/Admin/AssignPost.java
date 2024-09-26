package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignPost {

    @Autowired
    private AssignService assignService;

    @PostMapping("/admin/assign")
    public List<Assign> assignAPost(@RequestParam String event, @RequestParam String coo, @RequestParam String info){

        assignService.setPost(event, coo, info);

        return assignService.getPost(coo);

    }

}
