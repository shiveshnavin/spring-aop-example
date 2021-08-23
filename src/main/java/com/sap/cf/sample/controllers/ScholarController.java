package com.sap.cf.sample.controllers;

import com.sap.cf.sample.annotations.FlowLogger;
import com.sap.cf.sample.dao.Scholar;
import com.sap.cf.sample.services.ScholarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScholarController {

    @Autowired
    ScholarService service;

    @FlowLogger
    @GetMapping("/")
    public List<Scholar> getAll(){
        return service.getScholars();
    }

    @FlowLogger
    @PostMapping("/")
    public Scholar create(@RequestBody Scholar request){
        return service.create(request.getName(),request.getBatch());
    }

}
