package com.db2.project2.entity.nested;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PROJECTS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @Id
    private String id;

    @Field("PNAME")
    private String pName;

    @Field("PNUMBER")
    private Integer pNumber;

    @Field("DNAME")
    private String dName;

    @Field("DNUM")
    private Integer dNum;

    @Field("Hours")
    private Float hours;

    List<Employee> employees = new ArrayList<>();

    public Project() {
    }

    public Project(String pName, Integer pNumber, String dName, Integer dNum, Float hours) {
        this.pName = pName;
        this.pNumber = pNumber;
        this.dName = dName;
        this.dNum = dNum;
        this.hours = hours;
        this.employees = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Integer getdNum() {
        return dNum;
    }

    public void setdNum(Integer dNum) {
        this.dNum = dNum;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id='" + id + '\'' +
                ", pName='" + pName + '\'' +
                ", pNumber=" + pNumber +
                ", dName='" + dName + '\'' +
                ", dNum=" + dNum +
                ", employees=" + employees +
                '}';
    }
}
