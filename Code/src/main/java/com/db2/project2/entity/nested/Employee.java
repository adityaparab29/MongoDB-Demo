package com.db2.project2.entity.nested;

import com.db2.project2.entity.normalized.EmployeeNormal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "EMPLOYEES")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @Id
    private String id;

    @Field("EMP_FNAME")
    private String fName;

    @Field("EMP_M_INI")
    private String minit;

    @Field("EMP_LNAME")
    private String lName;

    @Field("EMP_SSN")
    private String ssn;

    @Field("EMP_BDATE")
    private String bDate;

    @Field("EMP_ADDRESS")
    private String address;

    @Field("EMP_SEX")
    private String sex;

    @Field("EMP_SALARY")
    private Integer salary;

    @Field("EMP_SUPER_SSN")
    private String super_ssn;

    @Field("EMP_DNO")
    private Integer dNo;

    @Field("Hours")
    private Float hours;

    List<Project> projects = new ArrayList<>();

    public Employee() {
    }

    public Employee(String fName, String minit, String lName, String ssn, String bDate, String address, String sex, Integer salary, Integer dNo, float hours) {
        this.fName = fName;
        this.minit = minit;
        this.lName = lName;
        this.ssn = ssn;
        this.bDate = bDate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.dNo = dNo;
        this.hours = hours;
        this.projects = null;
    }

    public Employee(String fName, String lName, String ssn, Integer salary, Integer dNo) {
        this.fName = fName;
        this.lName = lName;
        this.ssn = ssn;
        this.salary = salary;
        this.dNo = dNo;
        this.projects = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getSuper_ssn() {
        return super_ssn;
    }

    public void setSuper_ssn(String super_ssn) {
        this.super_ssn = super_ssn;
    }

    public Integer getdNo() {
        return dNo;
    }

    public void setdNo(Integer dNo) {
        this.dNo = dNo;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "fName='" + fName + '\'' +
                ", minit='" + minit + '\'' +
                ", lName='" + lName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", bDate='" + bDate + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", super_ssn='" + super_ssn + '\'' +
                ", dNo=" + dNo +
                ", hours=" + hours +
                ", projects=" + projects +
                '}';
    }

    public void metaEmployee(EmployeeNormal employeeNormal) {
        this.fName = employeeNormal.getfName();
        this.minit = employeeNormal.getMinit();
        this.lName = employeeNormal.getlName();
        this.ssn = employeeNormal.getSsn();
        this.bDate = employeeNormal.getbDate();
        this.address = employeeNormal.getAddress();
        this.sex = employeeNormal.getSex();
        this.salary = employeeNormal.getSalary();
        this.dNo = employeeNormal.getdNo();
        this.super_ssn = employeeNormal.getSuper_ssn();
    }
}
