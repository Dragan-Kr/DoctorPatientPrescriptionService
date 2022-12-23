package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.transaction.Transactional;


/**
 * The persistent class for the docgivesdiag database table.
 * 
 */
@Entity
@IdClass(DocgivesdiagPK.class)
public class Docgivesdiag implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private Integer docid;

	@Id
	private Integer warid;

	@Id
	private Integer diagid;

	//bi-directional many-to-one association to Doctor

//	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name="docid", referencedColumnName="id"),
//		@JoinColumn(name="warid", referencedColumnName="warid")
//		})
//	private Doctor doctor;

	public Docgivesdiag() {
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


	//	public DocgivesdiagPK getId() {
//		return this.id2;
//	}
//
//	public void setId(DocgivesdiagPK id) {
//		this.id2 = id;
//	}

//	public Doctor getDoctor() {
//		return this.doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}

}
