package com.activitiesBackend.activitiesBackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/manager")
    public ResponseEntity<String> getAllCoordinators(HttpSession session){
        String id=(String) session.getAttribute("id");
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
