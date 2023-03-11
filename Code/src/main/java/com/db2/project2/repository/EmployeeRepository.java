package com.db2.project2.repository;

import com.db2.project2.entity.nested.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Long countBysex(String sex);

    List<Employee> findBydNoAndSalaryIsGreaterThanEqual(int dNo, int salary);

}
