package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StructureService;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SessionAttributes("user")
@RestController
public class FetchNotifyController {


    Logger logger= LoggerFactory.getLogger(FetchNotifyController.class);

    @Autowired
    private AssignService assignService;

    @Autowired
    private StructureService structureService;

    @GetMapping("/notify")
    public ModelAndView getNotification(HttpSession session,@RequestParam(required = false) String msg,@RequestParam(required = false) String errorMessage){
        String user=(String) session.getAttribute("fullname");


        return new ModelAndView("notify/notify").addObject("posts",assignService.getPost(user));
    }

    @GetMapping("/structure")
    public ModelAndView getStructure(@RequestParam String id){
        return new ModelAndView("structure/structure").addObject("notify",assignService.getPostById(id));
    }
    @PostMapping("/structure")
    public ModelAndView setStructure(@RequestParam String id,
                                  @RequestParam String name,
                                  @RequestParam String venue,
                                  @RequestParam String mail,
                                  HttpSession session){
        Assign assign=assignService.getPostById(id);
        String sid=structureService.save(assign,name,venue,(String) session.getAttribute("user"),mail);
        System.out.println("sid"+sid);
        return new ModelAndView("redirect:/allsend");

    }

    @GetMapping("/allsend")
    public ModelAndView getAllStructure(HttpSession session){
        String coo=(String) session.getAttribute("user");
        return new ModelAndView("structure/allStructure").addObject("structures",structureService.getAllStructure(coo));
    }



}
