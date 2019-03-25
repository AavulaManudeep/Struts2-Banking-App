/**
 * 
 */
package com.pojoclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.type.TrueFalseType;

import antlr.collections.List;

/**
 * @author manu
 *
 */
@Entity
@Table(name = "Registration")
public class RegisterPOJO implements Serializable {
	@Id
	private String username;
	@Column
	private String pass;
	@Column
	private String cpass;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String zipcode;
	@Column
	private String savings;
	@Column
	private String checking;
	
	@OneToMany(cascade=javax.persistence.CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name="foregin")
	private Set<UserAccNum> pojousername;
	
	/*
	 * @OneToMany(cascade= javax.persistence.CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "usernmae") private ArrayList<String> accounttype= new
	 * ArrayList<String>();
	 */

	/**
	 * @return the pojousername
	 */
	
	public Set<UserAccNum> getPojousername() {
		return pojousername;
	}

	/**
	 * @param pojousername the pojousername to set
	 */
	public void setPojousername(Set<UserAccNum> pojousername) {
		this.pojousername = pojousername;
	}

	// @Table("accounttype")
//	private ArrayList<String> accounttype = new ArrayList<String>();
	@Column
	private String usertype;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the cpass
	 */
	public String getCpass() {
		return cpass;
	}

	/**
	 * @param cpass the cpass to set
	 */
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the accounttype
	 */

	/*
	 * public ArrayList<String> getAccounttype() { return accounttype; }
	 *//**
		 * @param accounttype the accounttype to set
		 *//*
			 * @OneToMany(cascade= javax.persistence.CascadeType.ALL , orphanRemoval=true)
			 * 
			 * @JoinColumn(name="RegisterPOJO.username") public void
			 * setAccounttype(ArrayList<String> accounttype) { this.accounttype =
			 * accounttype; }
			 */

	/**
	 * @return the usertype
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the saving
	 */
	

	/**
	 * @return the savings
	 */
	public String getSavings() {
		return savings;
	}

	/**
	 * @param savings the savings to set
	 */
	public void setSavings(String savings) {
		this.savings = savings;
	}

	/**
	 * @return the checking
	 */
	public String getChecking() {
		return checking;
	}

	/**
	 * @param checking the checking to set
	 */
	public void setChecking(String checking) {
		this.checking = checking;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterPOJO [username=" + username + ", pass=" + pass + ", cpass=" + cpass + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", zipcode=" + zipcode + ", savings=" + savings
				+ ", checking=" + checking + ", pojousername=" + pojousername + ", usertype=" + usertype + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
}
