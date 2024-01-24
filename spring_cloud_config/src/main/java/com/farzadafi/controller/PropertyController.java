package com.farzadafi.controller;

import com.farzadafi.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
}