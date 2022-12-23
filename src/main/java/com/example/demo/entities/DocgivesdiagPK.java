package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the docgivesdiag database table.
 * 
 */
public class DocgivesdiagPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer docid;

	@Column(insertable=false, updatable=false)
	private Integer warid;

	@Column(insertable=false, updatable=false)
	private Integer diagid;

	public DocgivesdiagPK() {
	}

	public DocgivesdiagPK(Integer docid, Integer warid, Integer diagid) {
    this.docid = docid;
    this.warid = warid;
    this.diagid = diagid;
	}

	public Integer getDocid() {
		return this.docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	public Integer getWarid() {
		return this.warid;
	}
	public void setWarid(Integer warid) {
		this.warid = warid;
	}
	public Integer getDiagid() {
		return this.diagid;
	}
	public void setDiagid(Integer diagid) {
		this.diagid = diagid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DocgivesdiagPK)) {
			return false;
		}
		DocgivesdiagPK castOther = (DocgivesdiagPK)other;
		return 
			this.docid.equals(castOther.docid)
			&& this.warid.equals(castOther.warid)
			&& this.diagid.equals(castOther.diagid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.docid.hashCode();
		hash = hash * prime + this.warid.hashCode();
		hash = hash * prime + this.diagid.hashCode();
		
		return hash;
	}
}
