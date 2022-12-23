package com.example.demo.dtos;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PrescriptionDto {
    private Integer id;

    private Integer diagid;
    private Integer docid;
    private Integer warid;
    private Integer pid;

    private String medicine;

    private Date pdate;

    public PrescriptionDto(){

    }

//    public PrescriptionDto(Integer diagid, Integer id, Integer warid, Integer id1, String medicine, Date pdate) {
//        this.diagid=diagid;
//        this.docid=id;
//        this.warid=warid;
//        this.pid=id1;
//        this.medicine=medicine;
//        this.pdate=pdate;
//    }

    public PrescriptionDto(Integer id, Integer diagid, Integer docid, Integer warid, Integer pid, String medicine, Date pdate) {
        this.id=id;
        this.diagid=diagid;
        this.docid=docid;
        this.warid=warid;
        this.pid=pid;
        this.medicine=medicine;
        this.pdate=pdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiagid() {
        return diagid;
    }

    public void setDiagid(Integer diagid) {
        this.diagid = diagid;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
