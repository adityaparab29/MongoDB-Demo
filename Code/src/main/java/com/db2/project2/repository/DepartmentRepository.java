package com.db2.project2.repository;

import com.db2.project2.entity.nested.Department;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DepartmentRepository extends MongoRepository<Department, String> {

    Department findBydName(String dName);
}
