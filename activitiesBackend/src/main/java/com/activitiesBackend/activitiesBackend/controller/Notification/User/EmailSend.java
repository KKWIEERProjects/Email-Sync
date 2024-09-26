package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.HistoryRepo;
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

import java.util.List;

@RestController
public class EmailSend {

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
    public List<StatusIQ> sendEmail(@RequestParam String id, HttpSession session){

        Structure structure=structureService.getStructure(id);

        statusService.setStatusTable(structure);
        structureService.remove(structure);
        assignService.removeById(structure.getId());

       return statusService.get((String) session.getAttribute("user"));

    }

    @GetMapping("/update")
    public void update(@RequestParam String id,@RequestParam String status){

        StatusIQ statusIQ=statusService.updateStatus(id,status);
        if(status.equals("accepted") || status.equals("rejected")){
            historyService.record(statusIQ);
            statusService.remove(id);
        }


    }

}
