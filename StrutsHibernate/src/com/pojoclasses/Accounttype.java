/**
 * 
 */
package com.pojoclasses;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author manu
 *
 */
@Entity
@Table(name="Accounttype")
public class Accounttype extends Accountcomppk{
	
	@EmbeddedId
	private Accountcomppk account;
	
	/**
	 * 
	 */
	public Accounttype() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Accounttype [account=" + account + ", Amount=" + amount + "]";
	}

	/**
	 * @param account
	 * @param amount
	 */
	public Accounttype(Accountcomppk account, long amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	/**
	 * @param account
	 * @param amount
	 */


	/**
	 * @return the account
	 */
	public Accountcomppk getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Accountcomppk account) {
		this.account = account;
	}

	/**
	 * @return the amount
	 */
	

	private long amount;

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}
	

}
