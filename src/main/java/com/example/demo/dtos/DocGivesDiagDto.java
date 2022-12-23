package com.example.demo.dtos;

import com.example.demo.entities.Docgivesdiag;

import javax.persistence.Id;

public class DocGivesDiagDto {

    private Integer docid;


    private Integer warid;


    private Integer diagid;

    public DocGivesDiagDto(){

    }

    public DocGivesDiagDto(Integer docid, Integer warid,Integer diagid) {
        this.docid = docid;
        this.warid = warid;
        this.diagid = diagid;

    }

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public Integer getWarid() {
        return warid;
    }

    public void setWarid(Integer warid) {
        this.warid = warid;
    }

    public Integer getDiagid() {
        return diagid;
    }

    public void setDiagid(Integer diagid) {
        this.diagid = diagid;
    }
}
