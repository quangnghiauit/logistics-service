package com.dacn.logicsticservice.controllers;

import com.dacn.logicsticservice.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-management")
public class UserManagementController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "/get-all-user", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userManagementService.getAllUser(), HttpStatus.OK);
    }

}
