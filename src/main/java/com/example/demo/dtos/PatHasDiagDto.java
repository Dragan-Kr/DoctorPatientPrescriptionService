package com.example.demo.dtos;

import javax.persistence.Id;

public class PatHasDiagDto {

    private Integer pid;

    private Integer diagid;


    public PatHasDiagDto(){

    }

    public PatHasDiagDto(Integer pid, Integer diagid) {
        this.pid = pid;
        this.diagid=diagid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDiagid() {
        return diagid;
    }

    public void setDiagid(Integer diagid) {
        this.diagid = diagid;
    }
}
