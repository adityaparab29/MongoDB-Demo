package com.db2.project2.repository;

import com.db2.project2.entity.nested.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project> findBypNumberBetween(int pNo1, int pNo2);

    List<Project> findBydNameIn(List<String> dNameList);

    Long countBydName(String dName);


}
