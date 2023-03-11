package com.db2.project2.entity.normalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "DEPARTMENT_NORMALIZED")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentNormal {

    @Id
    private String id;

    @CsvBindByPosition(position = 0)
    @Field("Dname")
    private String dName;

    @CsvBindByPosition(position = 1)
    @Field("Dnumber")
    private Integer dNumber;

    @CsvBindByPosition(position = 2)
    @Field("Mgr_ssn")
    private String mgr_ssn;

    @CsvBindByPosition(position = 3)
    @Field("Mgr_start_date")
    private String mgr_start_date;

    public DepartmentNormal() {
    }

    public DepartmentNormal(String dName, Integer dNumber, String mgr_ssn, String mgr_start_date) {
        this.dName = dName;
        this.dNumber = dNumber;
        this.mgr_ssn = mgr_ssn;
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

    public Integer getdNumber() {
        return dNumber;
    }

    public void setdNumber(Integer dNumber) {
        this.dNumber = dNumber;
    }

    public String getMgr_ssn() {
        return mgr_ssn;
    }

    public void setMgr_ssn(String mgr_ssn) {
        this.mgr_ssn = mgr_ssn;
    }

    public String getMgr_start_date() {
        return mgr_start_date;
    }

    public void setMgr_start_date(String mgr_start_date) {
        this.mgr_start_date = mgr_start_date;
    }

    @Override
    public String toString() {
        return "DepartmentNormal{" +
                "id='" + id + '\'' +
                ", dName='" + dName + '\'' +
                ", dNumber='" + dNumber + '\'' +
                ", mgr_ssn='" + mgr_ssn + '\'' +
                ", mgr_start_date='" + mgr_start_date + '\'' +
                '}';
    }
}
