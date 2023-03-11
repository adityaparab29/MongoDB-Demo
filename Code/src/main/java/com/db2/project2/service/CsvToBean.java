package com.db2.project2.service;

import com.db2.project2.config.NullDataFilter;
import com.db2.project2.entity.normalized.DepartmentNormal;
import com.db2.project2.entity.normalized.EmployeeNormal;
import com.db2.project2.entity.normalized.ProjectNormal;
import com.db2.project2.entity.normalized.WorksOnNormal;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CsvToBean {

    final static Logger logger = LoggerFactory.getLogger(CsvToBean.class);

    @Autowired
    private DataService dataService;

    public static <T> List<T> readFileToObject(String fileName, Class obj) {

        List<T> beans = null;
        CsvToBeanFilter filter = new NullDataFilter();
        try {
            beans = new CsvToBeanBuilder(new FileReader(fileName))
                    .withQuoteChar('\'')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFilter(filter)
                    .withType(obj)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //beans.forEach(System.out::println);

        return beans;
    }

    // Main method to start
    public void convertFiles() {
        String employee = "files/EMPLOYEE.txt";
        String department = "files/DEPARTMENT.txt";
        String project = "files/PROJECT.txt";
        String works_on = "files/WORKS_ON.txt";

        logger.info("Starting to read all data files");
        List<EmployeeNormal> employeeNormals = readFileToObject(employee, EmployeeNormal.class);
        List<DepartmentNormal> departmentNormals = readFileToObject(department, DepartmentNormal.class);
        List<ProjectNormal> projectNormals = readFileToObject(project, ProjectNormal.class);
        List<WorksOnNormal> worksOnNormals = readFileToObject(works_on, WorksOnNormal.class);
        logger.info("Data files reading complete. Trying to Save.");

        dataService.saveAllNormalizedData(employeeNormals, departmentNormals, projectNormals, worksOnNormals);

    }
}


