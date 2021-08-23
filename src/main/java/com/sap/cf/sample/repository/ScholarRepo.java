package com.sap.cf.sample.repository;

import com.sap.cf.sample.dao.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarRepo extends JpaRepository<Scholar, Long> {

}
