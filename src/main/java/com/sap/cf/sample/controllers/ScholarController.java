package com.sap.cf.sample.controllers;

import com.sap.cf.sample.support.annotations.Cached;
import com.sap.cf.sample.support.annotations.FlowLogger;
import com.sap.cf.sample.dao.Scholar;
import com.sap.cf.sample.services.ScholarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScholarController {

    @Autowired
    ScholarService service;

    @Cached
    @FlowLogger
    @GetMapping("/")
    public List<Scholar> getAllScholars(){
        return service.getScholars();
    }

    @Cached
    @FlowLogger
    @GetMapping("/{scholarId}")
    public Scholar getScholar(@PathVariable("scholarId") Long scholarId){
        return service.getOneScholar(scholarId);
    }

    @FlowLogger
    @PostMapping("/")
    public Scholar createScholar(@RequestBody Scholar request){
        return service.create(request.getName(),request.getBatch());
    }

    @FlowLogger
    @DeleteMapping("/{scholarId}")
    public Scholar deleteScholar(@PathVariable("scholarId") Long scholarId){
        return service.delete(scholarId);
    }

}
