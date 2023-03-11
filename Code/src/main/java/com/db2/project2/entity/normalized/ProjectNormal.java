package com.db2.project2.entity.normalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "PROJECT_NORMALIZED")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectNormal {

    @Id
    private String id;

    @CsvBindByPosition(position = 0)
    @Field("Pname")
    private String pName;

    @CsvBindByPosition(position = 1)
    @Field("Pnumber")
    private Integer pNumber;

    @CsvBindByPosition(position = 2)
    @Field("Plocation")
    private String pLocation;

    @CsvBindByPosition(position = 3)
    @Field("Dnum")
    private Integer dNum;

    public ProjectNormal() {
    }

    public ProjectNormal(String pName, Integer pNumber, String pLocation, Integer dNum) {
        this.pName = pName;
        this.pNumber = pNumber;
        this.pLocation = pLocation;
        this.dNum = dNum;
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

    public String getpLocation() {
        return pLocation;
    }

    public void setpLocation(String pLocation) {
        this.pLocation = pLocation;
    }

    public Integer getdNum() {
        return dNum;
    }

    public void setdNum(Integer dNum) {
        this.dNum = dNum;
    }

    @Override
    public String toString() {
        return "ProjectNormal{" +
                "id='" + id + '\'' +
                ", pName='" + pName + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", pLocation='" + pLocation + '\'' +
                ", dNum='" + dNum + '\'' +
                '}';
    }
}
