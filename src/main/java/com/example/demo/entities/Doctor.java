package com.example.demo.entities;

import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@IdClass(DoctorPK.class)
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private Integer id;

	@Id
	private Integer warid;

	private String speciality;

//	@OneToMany(mappedBy="doctor")
//	private List<Docgivesdiag> docgivesdiags;
//
//
//	@ManyToMany(mappedBy="doctors")
//	private List<Patient> patients;

//	bi-directional many-to-one association to Prescription
//
	@JsonIgnore
	@OneToMany(mappedBy="doctor")
	private List<Prescription> prescriptions;

	public Doctor() {
	}

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
//	public DoctorPK getId() {
//		return this.id;
//	}
//
//	public void setId(DoctorPK id) {
//		this.id = id;
//	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

//	public List<Docgivesdiag> getDocgivesdiags() {
//		return this.docgivesdiags;
//	}
//
//	public void setDocgivesdiags(List<Docgivesdiag> docgivesdiags) {
//		this.docgivesdiags = docgivesdiags;
//	}

//	public Docgivesdiag addDocgivesdiag(Docgivesdiag docgivesdiag) {
//		getDocgivesdiags().add(docgivesdiag);
//		docgivesdiag.setDoctor(this);
//
//		return docgivesdiag;
//	}
//
//	public Docgivesdiag removeDocgivesdiag(Docgivesdiag docgivesdiag) {
//		getDocgivesdiags().remove(docgivesdiag);
//		docgivesdiag.setDoctor(null);
//
//		return docgivesdiag;
//	}

//	public List<Patient> getPatients() {
//		return this.patients;
//	}
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//
//	public List<Prescription> getPrescriptions() {
//		return this.prescriptions;
//	}
//
//	public void setPrescriptions(List<Prescription> prescriptions) {
//		this.prescriptions = prescriptions;
//	}
//
//	public Prescription addPrescription(Prescription prescription) {
//		getPrescriptions().add(prescription);
//		prescription.setDoctor(this);
//
//		return prescription;
//	}
//
//	public Prescription removePrescription(Prescription prescription) {
//		getPrescriptions().remove(prescription);
//		prescription.setDoctor(null);
//
//		return prescription;
//	}

}
