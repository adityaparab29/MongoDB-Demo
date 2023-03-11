package com.db2.project2;

import com.db2.project2.service.CsvToBean;
import com.db2.project2.service.DataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Project2Application {

    public static void main(String[] args) throws JsonProcessingException {
        ConfigurableApplicationContext context = SpringApplication.run(Project2Application.class, args);

        context.getBean(CsvToBean.class).convertFiles();
        context.getBean(DataService.class).createNestedProjectDocuments();
        context.getBean(DataService.class).createNestedEmployeeDocuments();
        context.getBean(DataService.class).createNestedDepartmentDocuments();
        context.getBean(DataService.class).createDepartmentXML();
        context.getBean(DataService.class).testQueries();


    }
}
