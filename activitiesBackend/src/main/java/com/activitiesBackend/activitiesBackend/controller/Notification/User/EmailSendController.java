package com.activitiesBackend.activitiesBackend.controller.Notification.User;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.HistoryService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StatusService;
import com.activitiesBackend.activitiesBackend.Services.NotificationService.StructureService;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import com.activitiesBackend.activitiesBackend.util.Mail.MailUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;

import java.util.HashMap;

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

    @Autowired
    private MailUtil mailUtil;

    /**
     * aaby lodo id hai to sessions kiu?
     * list kiu?
     * baadme change kario
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/send")
    public ModelAndView sendEmail(@RequestParam String id, HttpSession session, HttpServletResponse response){

        Structure structure=structureService.getStructure(id);

        Context context=new Context();
        context.setVariable("event",structure.getEvent());
        context.setVariable("name",structure.getName());
        context.setVariable("date",structure.getEstimate());
        context.setVariable("venue",structure.getVenue());
        context.setVariable("info",structure.getInfo());


        String temp=mailUtil.createTemplate(context,"template/expert");

        HashMap<String,String> hash=new HashMap();
        hash.put("subject","test");
        hash.put("ourEmail","earthusmomma@gmail.com");
        hash.put("ourToken","miew zzvx bisk uyab");
        hash.put("email","sumedhbusiness.info@gmail.com");

        mailUtil.sendMail(response,temp,hash);


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

    @GetMapping("/temp")
    public ModelAndView getOn(){
        return new ModelAndView("template/expert");
    }

}
