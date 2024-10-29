package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.HistoryService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StatusService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StructureService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import com.activitiesBackend.activitiesBackend.util.Mail.MailUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;

import java.util.HashMap;

@RestController
public class EmailSendController {

    Logger logger= LoggerFactory.getLogger(EmailSendController.class);

    @Autowired
    private AssignService assignService;

    @Autowired
    private StructureService structureService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private UserManageService userManageService;

    /**
     *
     * list kiu?
     * baadme change kario
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/send")
    public ModelAndView sendEmail(@RequestParam String id, HttpSession session, HttpServletResponse response) {

        Structure structure=structureService.getStructure(id);

        Context context=new Context();
        context.setVariable("event",structure.getEvent());
        context.setVariable("name",structure.getName());
        context.setVariable("dateStart",structure.getEstimateStart());
        context.setVariable("dateEnd",structure.getEstimateEnd());
        context.setVariable("venue",structure.getVenue());
        context.setVariable("info",structure.getInfo());
        context.setVariable("id",structure.getId());


        String temp=mailUtil.createTemplate(context,"template/expert");
        try {
            User user = userManageService.getUser((String) session.getAttribute("id"));
            HashMap<String,String> hash=new HashMap();
            hash.put("subject","Invitation to speak at "+structure.getEvent());
            hash.put("ourEmail", user.getEmail());
            hash.put("ourToken",user.getToken());
            hash.put("email",structure.getMail());

            mailUtil.sendMail(response, temp, hash);
        }catch (Exception ex){
            return new ModelAndView("redirect:/allstatus");
        }

        statusService.setStatusTable(structure);
        structureService.remove(structure);
        assignService.removeById(structure.getId());

       return new ModelAndView("redirect:/allstatus");

    }

    @GetMapping("/allstatus")
    public ModelAndView getAllStatus(HttpSession session){
        return new ModelAndView("status/status").addObject("status",statusService.get((String) session.getAttribute("fullname")));
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam String id,@RequestParam String status){
        System.out.println(status);
        StatusIQ statusIQ=statusService.updateStatus(id,status);
        if(status.equals("Accepted") || status.equals("Rejected")){
            historyService.record(statusIQ,"NaN","NaN");
            System.out.println(id);
            statusService.remove(id);
        }

        return new ModelAndView("redirect:/history");


    }

    @GetMapping("/mail/update/{id}")
    public ModelAndView updateStatus(@PathVariable String id,@RequestParam String status
                                ,@RequestParam String dateStart,@RequestParam String dateEnd){

        return new ModelAndView("updates/update").addObject("id",id)
                .addObject("status",status)
                .addObject("dateStart",dateStart)
                .addObject("dateEnd",dateEnd);

    }

    @GetMapping("/mail/rejected/{id}")
    public ModelAndView updateRejected(@PathVariable String id,@RequestParam String status){
        structureService.getStructure(id);
        return new ModelAndView("updates/updateRejected");
    }

    @PostMapping("/mail/update/set")
    public ResponseEntity getEntity(@RequestParam String id,@RequestParam String status
            ,@RequestParam String date,@RequestParam String phone){
        StatusIQ statusIQ=statusService.updateStatus(id,status);
        logger.info(id);
        historyService.record(statusIQ,date,phone);

        statusService.remove(id);

        return ResponseEntity.ok("<html><body> <h1>You are all set</h1><strong>"+id+"</strong>"+
                    "</body></html>");

    }

    @PostMapping("/mail/update/reject")
    public ResponseEntity getRejection(@RequestParam String id,@RequestParam String status
            ){
        StatusIQ statusIQ=statusService.updateStatus(id,status);
        logger.info(id);
        historyService.record(statusIQ,"NaN","NaN");

        statusService.remove(id);

        return ResponseEntity.ok("<html><body> <h1>Maybe next time!</h1>"+
                "</body></html>");

    }

    @GetMapping("/temp")
    public ModelAndView getOn(){
        return new ModelAndView("template/expert");
    }

}
