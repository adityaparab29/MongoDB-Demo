package com.db2.project2.entity.nested;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "DEPARTMENTS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department {

    @Id
    private String id;

    @Field("DNAME")
    private String dName;

    @Field("MANAGER_FNAME")
    private String managerFName;

    @Field("MANAGER_LNAME")
    private String managerLName;

    @Field("MGR_START_DATE")
    private String mgr_start_date;

    List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String dName, String managerFName, String managerLName, String mgr_start_date) {
        this.dName = dName;
        this.managerFName = managerFName;
        this.managerLName = managerLName;
        this.mgr_start_date = mgr_start_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getManagerFName() {
        return managerFName;
    }

    public void setManagerFName(String managerFName) {
        this.managerFName = managerFName;
    }

    public String getManagerLName() {
        return managerLName;
    }

    public void setManagerLName(String managerLName) {
        this.managerLName = managerLName;
    }

    public String getMgr_start_date() {
        return mgr_start_date;
    }

    public void setMgr_start_date(String mgr_start_date) {
        this.mgr_start_date = mgr_start_date;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
