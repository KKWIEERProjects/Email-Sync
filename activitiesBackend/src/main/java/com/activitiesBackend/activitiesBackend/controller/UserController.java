package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import com.activitiesBackend.activitiesBackend.dto.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/manager")
    public ResponseEntity<List<User>> getAllCoordinators(HttpSession session){
        String id=(String) session.getAttribute("id");

        return ResponseEntity.status(HttpStatus.OK).body(userManageService.getWorkers(id));
    }
}
