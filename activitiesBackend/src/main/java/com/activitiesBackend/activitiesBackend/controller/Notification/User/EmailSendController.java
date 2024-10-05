package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.HistoryService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StatusService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StructureService;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmailSendController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private StructureService structureService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private HistoryService historyService;

    /**
     * aaby lodo id hai to sessions kiu?
     * list kiu?
     * baadme change kario
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/send")
    public ModelAndView sendEmail(@RequestParam String id, HttpSession session){

        Structure structure=structureService.getStructure(id);

        statusService.setStatusTable(structure);
        structureService.remove(structure);
        assignService.removeById(structure.getId());

       return new ModelAndView("redirect:/allstatus");

    }

    @GetMapping("/allstatus")
    public ModelAndView getAllStatus(HttpSession session){
        return new ModelAndView("status/status").addObject("status",statusService.get((String) session.getAttribute("user")));
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam String id,@RequestParam String status){
        System.out.println(status);
        StatusIQ statusIQ=statusService.updateStatus(id,status);
        if(status.equals("Accepted") || status.equals("Rejected")){
            historyService.record(statusIQ);
            System.out.println(id);
            statusService.remove(id);
        }

        return new ModelAndView("redirect:/history");


    }

}
