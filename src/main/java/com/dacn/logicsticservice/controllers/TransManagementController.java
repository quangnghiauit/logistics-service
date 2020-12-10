package com.dacn.logicsticservice.controllers;

import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.service.TransManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransManagementController.class);

    @Autowired
    private TransManagementService transManagementService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public ResponseEntity<?> getCompanyList() {
        return new ResponseEntity<>(transManagementService.getAllCompany(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<>(transManagementService.getAllCustomer(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get-suggestions", method = RequestMethod.POST)
    public ResponseEntity<?> getSuggestions(@RequestBody SuggestRequest suggestRequest) {
        return new ResponseEntity<>(transManagementService.getAllSuggestions(suggestRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/create-order", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(transManagementService.createOrder(orderRequest), HttpStatus.OK);
    }
}
