package com.scholars.cf.sample.services;

import com.scholars.cf.sample.support.annotations.FlowLogger;
import com.scholars.cf.sample.dao.Scholar;
import com.scholars.cf.sample.repository.ScholarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScholarService {

    @Autowired
    ScholarRepo repo;

    @FlowLogger
    public List<Scholar> getScholars() {
        return repo.findAll();
    }

    @FlowLogger
    public Scholar create(String name, String batch) {
        Scholar newScholar = new Scholar(name, batch);
        return repo.save(newScholar);
    }

    @FlowLogger
    public Scholar delete(Long scholarId) {
        Optional<Scholar> byGoners = repo.findById(scholarId);
        if (byGoners.isPresent()) {
            repo.deleteById(scholarId);
            return byGoners.get();
        } else {
            return null;
        }
    }

    @FlowLogger
    public Scholar getOneScholar(Long scholarId) {
        Optional<Scholar> byGoners = repo.findById(scholarId);
        return byGoners.orElse(null);
    }
}
