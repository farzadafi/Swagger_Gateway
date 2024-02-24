package com.farzadafi.controller;

import com.farzadafi.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/get-names")
    public ResponseEntity<List<String>> getAllYmlFileNames() {
        List<String> allYmlFileNames = propertyService.getAllYmlFileNames();
        return new ResponseEntity<>(allYmlFileNames, HttpStatus.OK);
    }

    @GetMapping("/get-json-values/{propertyFileName}")
    public ResponseEntity<String> getJsonValuesYmlFile(@PathVariable String propertyFileName) {
        String keysValueJson = propertyService.convertYmlToJson(propertyFileName);
        return new ResponseEntity<>(keysValueJson, HttpStatus.OK);
    }
}