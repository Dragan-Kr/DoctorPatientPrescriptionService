package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prescription database table.
 * 
 */
@Entity
@NamedQuery(name="Prescription.findAll", query="SELECT p FROM Prescription p")
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESCRIPTION_ID_GENERATOR", sequenceName=" PRESCRIPTION_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESCRIPTION_ID_GENERATOR")
	private Integer id;

	private Integer diagid;

	private String medicine;

	@Temporal(TemporalType.DATE)
	private Date pdate;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="docid", referencedColumnName="id"),
		@JoinColumn(name="wid", referencedColumnName="warid")
		})
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="pid")
	private Patient patient;

	public Prescription() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDiagid() {
		return this.diagid;
	}

	public void setDiagid(Integer diagid) {
		this.diagid = diagid;
	}

	public String getMedicine() {
		return this.medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
