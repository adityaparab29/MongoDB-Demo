package com.db2.project2.repository;

import com.db2.project2.entity.normalized.EmployeeNormal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EmployeeNormalRepository extends MongoRepository<EmployeeNormal, String> {
    List<EmployeeNormal> findBydNo(Integer deptNumber);

    EmployeeNormal findByssn(String ssn);
}
