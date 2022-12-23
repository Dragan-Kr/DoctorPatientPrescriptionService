package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nurse database table.
 * 
 */
public class NursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer id;

	@Column(insertable=false, updatable=false)
	private Integer warid;

	public NursePK() {
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWarid() {
		return this.warid;
	}
	public void setWarid(Integer warid) {
		this.warid = warid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NursePK)) {
			return false;
		}
		NursePK castOther = (NursePK)other;
		return 
			this.id.equals(castOther.id)
			&& this.warid.equals(castOther.warid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.warid.hashCode();
		
		return hash;
	}
}
