package com.dacn.logicsticservice.controllers;

import com.dacn.logicsticservice.service.AddressManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressManagementController.class);

    @Autowired
    private AddressManagementService addressManagementService;

    @RequestMapping(value = "/provinces", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProvinces() {
        return new ResponseEntity<>(addressManagementService.getAllCMProvince(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get-all-district", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDistrict() {
        return new ResponseEntity<>(addressManagementService.getAllDistrict(), HttpStatus.OK);
    }

    @RequestMapping(value = "/district", method = RequestMethod.GET)
    public ResponseEntity<?> getDistrictByProvinceId(@RequestParam("provinceid") String provinceid) {
        return new ResponseEntity<>(addressManagementService.getDistrictByProvinceId(provinceid), HttpStatus.OK);
    }

    @RequestMapping(value = "/get-all-ward", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWard() {
        return new ResponseEntity<>(addressManagementService.getAllWard(), HttpStatus.OK);
    }

    @RequestMapping(value = "/ward", method = RequestMethod.GET)
    public ResponseEntity<?> getWardByDistrictId(@RequestParam("districtid") String districtid) {
        return new ResponseEntity<>(addressManagementService.getWardByDistrictId(districtid), HttpStatus.OK);
    }
}
