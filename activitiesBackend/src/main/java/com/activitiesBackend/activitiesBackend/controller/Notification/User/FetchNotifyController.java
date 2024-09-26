package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StructureService;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchNotifyController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private StructureService structureService;

    @GetMapping("/notify")
    public List<Assign> getNotification(HttpSession session){
        String user=(String) session.getAttribute("user");

        //assignService.getPost(user);
        //user=null;
        return assignService.getPost(user);

    }


    @PostMapping("/structure")
    public Structure setStructure(@RequestParam String id,
                                  @RequestParam String name,
                                  @RequestParam String venue,
                                  HttpSession session){
        Assign assign=assignService.getPostById(id);
        String sid=structureService.save(assign,name,venue,(String) session.getAttribute("user"));
        System.out.println("sid"+sid);
        return structureService.getStructure(sid);

    }

}
