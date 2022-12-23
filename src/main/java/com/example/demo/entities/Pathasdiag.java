package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pathasdiag database table.
 * 
 */
@Entity
@IdClass(PathasdiagPK.class)
public class Pathasdiag implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	private Integer pid;

	@Id
	private Integer diagid;


	//bi-directional many-to-one association to Patient

	@ManyToOne
	@JoinColumn(name="pid")
	private Patient patient;

	public Pathasdiag() {
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


	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
