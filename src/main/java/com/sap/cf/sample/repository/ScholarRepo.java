package com.sap.cf.sample.repository;

import com.sap.cf.sample.dao.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScholarRepo extends JpaRepository<Scholar, UUID> {

}
