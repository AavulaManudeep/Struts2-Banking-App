/**
 * 
 */
package com.pojoclasses;

import java.io.Serializable;

/**
 * @author manu
 *
 */
public class DepositWithdraw implements Serializable{

	
	private String accountnumber;
	private String accounttype;
	private long amount;
	/**
	 * @param accountnumber
	 * @param accounttype
	 * @param amount
	 */
	public DepositWithdraw(String accountnumber, String accounttype, long amount) {
		super();
		this.accountnumber = accountnumber;
		this.accounttype = accounttype;
		this.amount = amount;
	}
	/**
	 * 
	 */
	public DepositWithdraw() {
		super();
	}
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
