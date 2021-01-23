package com.dacn.logicsticservice.controllers;

import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.service.TransManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/update-status-order", method = RequestMethod.GET)
    public ResponseEntity<?> createOrder(@NonNull @RequestParam Integer orderId,
                                         @NonNull @RequestParam Integer rulrateId,
                                         @NonNull @RequestParam Integer status) {
        return new ResponseEntity<>(transManagementService.updateStatusOrder(orderId, rulrateId, status), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders-by-customerId", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderByCustomerId(@Nullable @RequestParam("customerId") Integer customerId) {
        return new ResponseEntity<>(transManagementService.getOrderByCustomerId(customerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders-by-orderId", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderByOrderId(@Nullable @RequestParam("orderId") Integer orderId) {
        return new ResponseEntity<>(transManagementService.getOrderByOrderId(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders-by-companyId", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderByCompanyId(@Nullable @RequestParam("companyId") Integer companyId) {
        return new ResponseEntity<>(transManagementService.getOrderByCompanyId(companyId), HttpStatus.OK);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResponseEntity<?> statusMap() {
        return new ResponseEntity<>(transManagementService.getMapStatus(), HttpStatus.OK);
    }

}
