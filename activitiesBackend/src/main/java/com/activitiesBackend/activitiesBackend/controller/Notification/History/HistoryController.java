package com.activitiesBackend.activitiesBackend.controller.Notification.History;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.HistoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public ModelAndView getHistory(HttpSession session){
        return new ModelAndView("history").addObject("hits",historyService.getHistory((String) session.getAttribute("fullname")));
    }


}
