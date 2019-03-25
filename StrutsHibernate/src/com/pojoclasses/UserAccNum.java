/**
 * 
 */
package com.pojoclasses;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author manu
 *
 */
@Entity
@Table(name="UserAccount")
public class UserAccNum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3990692336923088887L;
	
	@Id
	private String accountnumber;
	/**
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}

	/**
	 * 
	 */
	public UserAccNum() {
		super();
	}

	/**
	 * @param accountnumber
	 * @param accountusername
	 * @param fk_registerationPojo
	 */
	public UserAccNum(String accountnumber, String accountusername, RegisterPOJO fk_registerationPojo) {
		super();
		this.accountnumber = accountnumber;
		this.accountusername = accountusername;
		this.fk_registerationPojo = fk_registerationPojo;
	}

	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	/**
	 * @return the accountusername
	 */
	public String getAccountusername() {
		return accountusername;
	}

	/**
	 * @param accountusername the accountusername to set
	 */
	public void setAccountusername(String accountusername) {
		this.accountusername = accountusername;
	}

	/**
	 * @return the fk_registerationPojo
	 */
	public RegisterPOJO getFk_registerationPojo() {
		return fk_registerationPojo;
	}

	/**
	 * @param fk_registerationPojo the fk_registerationPojo to set
	 */
	public void setFk_registerationPojo(RegisterPOJO fk_registerationPojo) {
		this.fk_registerationPojo = fk_registerationPojo;
	}

	@Column
	private  String accountusername;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_registerationPojo", referencedColumnName="username")
	private RegisterPOJO fk_registerationPojo;
	/**
	 * 
	 */
	
	
	

}
