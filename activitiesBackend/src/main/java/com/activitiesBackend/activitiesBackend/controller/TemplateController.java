package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Services.TemplateServiceImpl;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/admin/template")
public class TemplateController {

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/add")
    public ModelAndView templateAdd(HttpSession session){

        return new ModelAndView("templateAdd").addObject("templates",
                    userManageService.getAllTemplates((String) session.getAttribute("id"))
                );
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(HttpSession session,
                                      @RequestParam String name,
                                      @RequestParam String data)
        {
        try {
            templateService.addTemplate(userManageService.getUser((String) session.getAttribute("id")), name, data);
            return ResponseEntity.status(HttpStatus.OK).body("done!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
        }


    }

}
