package com.db2.project2.repository;

import com.db2.project2.entity.normalized.WorksOnNormal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface WorksOnNormalRepository extends MongoRepository<WorksOnNormal, String> {

    List<WorksOnNormal> findBypNo(Integer pNo);


}
