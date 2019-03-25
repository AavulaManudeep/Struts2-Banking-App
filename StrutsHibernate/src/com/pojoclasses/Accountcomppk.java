/**
 * 
 */
package com.pojoclasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author manu
 *
 */
@Embeddable
public class Accountcomppk implements Serializable{
	
	/**
	 * 
	 */
	public Accountcomppk() {
		super();
	}
	/**
	 * @param accountnumber
	 * @param accounttype
	 */
	public Accountcomppk(String accountnumber, String accounttype) {
		super();
		this.accountnumber = accountnumber;
		this.accounttype = accounttype;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountnumber == null) ? 0 : accountnumber.hashCode());
		result = prime * result + ((accounttype == null) ? 0 : accounttype.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accountcomppk other = (Accountcomppk) obj;
		if (accountnumber == null) {
			if (other.accountnumber != null)
				return false;
		} else if (!accountnumber.equals(other.accountnumber))
			return false;
		if (accounttype == null) {
			if (other.accounttype != null)
				return false;
		} else if (!accounttype.equals(other.accounttype))
			return false;
		return true;
	}
	@Column
	private String accountnumber;
	@Column
	private String accounttype;
	/**
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}
	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	/**
	 * @return the accounttype
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * @param accounttype the accounttype to set
	 */
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

}
