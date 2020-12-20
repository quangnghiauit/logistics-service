package com.dacn.logicsticservice.controllers;

import com.dacn.logicsticservice.dto.user.UserRegister;
import com.dacn.logicsticservice.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserRegister userRegister) {
        return new ResponseEntity<>(userManagementService.registerUser(userRegister), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserRegister userRegister) {
        return new ResponseEntity<>(userManagementService.login(userRegister), HttpStatus.OK);
    }
}
