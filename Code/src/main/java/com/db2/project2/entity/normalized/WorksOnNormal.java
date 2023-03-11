package com.db2.project2.entity.normalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "WORKS_ON_NORMALIZED")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorksOnNormal {

    @Id
    private String id;

    @CsvBindByPosition(position = 0)
    @Field("Essn")
    private String eSsn;

    @CsvBindByPosition(position = 1)
    @Field("Pno")
    private Integer pNo;

    @CsvBindByPosition(position = 2)
    @Field("Hours")
    private float hours;

    public WorksOnNormal() {
    }

    public String geteSsn() {
        return eSsn;
    }

    public void seteSsn(String eSsn) {
        this.eSsn = eSsn;
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "WorksOnNormal{" +
                "id='" + id + '\'' +
                ", eSsn='" + eSsn + '\'' +
                ", pNo='" + pNo + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
