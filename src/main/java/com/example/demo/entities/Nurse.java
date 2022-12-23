package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nurse database table.
 * 
 */
@Entity
@IdClass(NursePK.class)
public class Nurse implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private NursePK id;


	@Id
	private Integer id;

	@Id
	private Integer warid;

	private Boolean ishead;

	//bi-directional many-to-many association to Patient
	@ManyToMany(mappedBy="nurses")
	private List<Patient> patients;

	public Nurse() {
	}

//	public NursePK getId() {
//		return this.id;
//	}
//
//	public void setId(NursePK id) {
//		this.id = id;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWarid() {
		return warid;
	}

	public void setWarid(Integer warid) {
		this.warid = warid;
	}

	public Boolean getIshead() {
		return this.ishead;
	}

	public void setIshead(Boolean ishead) {
		this.ishead = ishead;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
