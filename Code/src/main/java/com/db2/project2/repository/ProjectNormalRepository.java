package com.db2.project2.repository;

import com.db2.project2.entity.normalized.ProjectNormal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProjectNormalRepository extends MongoRepository<ProjectNormal, String> {


}
