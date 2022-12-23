package com.example.demo.entities;

import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATIENT_ID_GENERATOR", sequenceName="PATIENT_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date accepted;

	private String allergies;

	private String insurance;

	private String prescriptions;

	private String sickeness;

	@Column(name="spec_reqs")
	private String specReqs;

	private Integer wid;

	//bi-directional many-to-many association to Doctor
//	@ManyToMany
//	@JoinTable(
//		name="doctreatspat"
//		, joinColumns={
//			@JoinColumn(name="patid")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="docid", referencedColumnName="id"),
//			@JoinColumn(name="warid", referencedColumnName="warid")
//			}
//		)
//	private List<Doctor> doctors;

	//bi-directional many-to-many association to Nurse
	@ManyToMany
	@JoinTable(
		name="nursetreatspat"
		, joinColumns={
			@JoinColumn(name="patid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="nurid", referencedColumnName="id"),
			@JoinColumn(name="warid", referencedColumnName="warid")
			}
		)
	private List<Nurse> nurses;

	@JsonIgnore
	@OneToMany(mappedBy="patient")
	private List<Pathasdiag> pathasdiags;

	//bi-directional many-to-one association to Prescription
	@JsonIgnore
	@OneToMany(mappedBy="patient")
	private List<Prescription> prescriptionsSet;

	public Patient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Date accepted) {
		this.accepted = accepted;
	}

	public String getAllergies() {
		return this.allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getSickeness() {
		return this.sickeness;
	}

	public void setSickeness(String sickeness) {
		this.sickeness = sickeness;
	}

	public String getSpecReqs() {
		return this.specReqs;
	}

	public void setSpecReqs(String specReqs) {
		this.specReqs = specReqs;
	}

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

//	public List<Doctor> getDoctors() {
//		return this.doctors;
//	}
//
//	public void setDoctors(List<Doctor> doctors) {
//		this.doctors = doctors;
//	}

	public List<Nurse> getNurses() {
		return this.nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	public List<Pathasdiag> getPathasdiags() {
		return this.pathasdiags;
	}

	public void setPathasdiags(List<Pathasdiag> pathasdiags) {
		this.pathasdiags = pathasdiags;
	}

	public Pathasdiag addPathasdiag(Pathasdiag pathasdiag) {
		getPathasdiags().add(pathasdiag);
		pathasdiag.setPatient(this);

		return pathasdiag;
	}

	public Pathasdiag removePathasdiag(Pathasdiag pathasdiag) {
		getPathasdiags().remove(pathasdiag);
		pathasdiag.setPatient(null);

		return pathasdiag;
	}

	public List<Prescription> getPrescriptionsSet() {
		return this.prescriptionsSet;
	}

	public void setPrescriptionsSet(List<Prescription> prescriptionsSet) {
		this.prescriptionsSet = prescriptionsSet;
	}

	public Prescription addPrescriptionsSet(Prescription prescriptionsSet) {
		getPrescriptionsSet().add(prescriptionsSet);
		prescriptionsSet.setPatient(this);

		return prescriptionsSet;
	}

	public Prescription removePrescriptionsSet(Prescription prescriptionsSet) {
		getPrescriptionsSet().remove(prescriptionsSet);
		prescriptionsSet.setPatient(null);

		return prescriptionsSet;
	}

}
