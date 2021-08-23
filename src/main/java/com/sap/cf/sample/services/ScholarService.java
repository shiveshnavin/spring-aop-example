package com.sap.cf.sample.services;

import com.sap.cf.sample.annotations.FlowLogger;
import com.sap.cf.sample.dao.Scholar;
import com.sap.cf.sample.repository.ScholarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarService {

    @Autowired
    ScholarRepo repo;

    @FlowLogger
    public List<Scholar> getScholars(){
       return repo.findAll();
    }

    @FlowLogger
    public Scholar create(String name, String batch) {
        Scholar newScholar = new Scholar(name,batch);
        return repo.save(newScholar);
    }
}
