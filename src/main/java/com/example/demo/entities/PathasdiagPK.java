package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pathasdiag database table.
 * 
 */
public class PathasdiagPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer pid;

	@Column(insertable=false, updatable=false)
	private Integer diagid;

	public PathasdiagPK() {
	}

    public PathasdiagPK(Integer pid, Integer diagid) {
		this.pid=pid;
		this.diagid=diagid;
    }

    public Integer getPid() {
		return this.pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
		if (!(other instanceof PathasdiagPK)) {
			return false;
		}
		PathasdiagPK castOther = (PathasdiagPK)other;
		return 
			this.pid.equals(castOther.pid)
			&& this.diagid.equals(castOther.diagid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pid.hashCode();
		hash = hash * prime + this.diagid.hashCode();
		
		return hash;
	}
}
