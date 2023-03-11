package com.db2.project2.entity.normalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "EMPLOYEE_NORMALIZED")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeNormal {

    @Id
    private String id;

    @CsvBindByPosition(position = 0)
    @Field("Fname")
    private String fName;

    @CsvBindByPosition(position = 1)
    @Field("Minit")
    private String minit;

    @CsvBindByPosition(position = 2)
    @Field("Lname")
    private String lName;

    @CsvBindByPosition(position = 3)
    @Field("Ssn")
    private String ssn;

    @CsvBindByPosition(position = 4)
    @Field("Bdate")
    private String bDate;

    @CsvBindByPosition(position = 5)
    @Field("Address")
    private String address;

    @CsvBindByPosition(position = 6)
    @Field("Sex")
    private String sex;

    @CsvBindByPosition(position = 7)
    @Field("Salary")
    private Integer salary;

    @CsvBindByPosition(position = 8)
    @Field("Super_ssn")
    private String super_ssn;

    @CsvBindByPosition(position = 9)
    @Field("Dno")
    private Integer dNo;

    public EmployeeNormal() {
    }

    public EmployeeNormal(String fName, String minit, String lName, String ssn, String bDate, String address, String sex, Integer salary, String super_ssn, Integer dNo) {
        this.fName = fName;
        this.minit = minit;
        this.lName = lName;
        this.ssn = ssn;
        this.bDate = bDate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.super_ssn = super_ssn;
        this.dNo = dNo;
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

    @Override
    public String toString() {
        return "EmployeeNormal{" +
                "id='" + id + '\'' +
                ", fName='" + fName + '\'' +
                ", minit='" + minit + '\'' +
                ", lName='" + lName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", bDate='" + bDate + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", salary='" + salary + '\'' +
                ", super_ssn='" + super_ssn + '\'' +
                ", dNo=" + dNo +
                '}';
    }
}
