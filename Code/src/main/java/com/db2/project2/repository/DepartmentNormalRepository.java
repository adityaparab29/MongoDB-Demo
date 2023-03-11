package com.db2.project2.repository;

import com.db2.project2.entity.normalized.DepartmentNormal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DepartmentNormalRepository extends MongoRepository<DepartmentNormal, String> {


}
