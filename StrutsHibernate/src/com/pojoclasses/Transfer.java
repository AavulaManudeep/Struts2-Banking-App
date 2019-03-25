/**
 * 
 */
package com.pojoclasses;

/**
 * @author manu
 *
 */
public class Transfer {
	
	private String sendaccountno;
	
	private String sendusername;
	
	private String sendaccounttype;
	
	private long amount;
	
	private String recaccountno;
	
	private String recusername;
	
	private String recaccounttype;

	/**
	 * @param sendaccountno
	 * @param sendusername
	 * @param sendaccounttype
	 * @param amount
	 * @param recaccountno
	 * @param recusername
	 * @param recaccounttype
	 */
	public Transfer(String sendaccountno, String sendusername, String sendaccounttype, long amount, String recaccountno,
			String recusername, String recaccounttype) {
		super();
		this.sendaccountno = sendaccountno;
		this.sendusername = sendusername;
		this.sendaccounttype = sendaccounttype;
		this.amount = amount;
		this.recaccountno = recaccountno;
		this.recusername = recusername;
		this.recaccounttype = recaccounttype;
	}

	/**
	 * 
	 */
	public Transfer() {
		super();
	}

	/**
	 * @return the sendaccountno
	 */
	public String getSendaccountno() {
		return sendaccountno;
	}

	/**
	 * @param sendaccountno the sendaccountno to set
	 */
	public void setSendaccountno(String sendaccountno) {
		this.sendaccountno = sendaccountno;
	}

	/**
	 * @return the sendusername
	 */
	public String getSendusername() {
		return sendusername;
	}

	/**
	 * @param sendusername the sendusername to set
	 */
	public void setSendusername(String sendusername) {
		this.sendusername = sendusername;
	}

	/**
	 * @return the sendaccounttype
	 */
	public String getSendaccounttype() {
		return sendaccounttype;
	}

	/**
	 * @param sendaccounttype the sendaccounttype to set
	 */
	public void setSendaccounttype(String sendaccounttype) {
		this.sendaccounttype = sendaccounttype;
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

	/**
	 * @return the recaccountno
	 */
	public String getRecaccountno() {
		return recaccountno;
	}

	/**
	 * @param recaccountno the recaccountno to set
	 */
	public void setRecaccountno(String recaccountno) {
		this.recaccountno = recaccountno;
	}

	/**
	 * @return the recusername
	 */
	public String getRecusername() {
		return recusername;
	}

	/**
	 * @param recusername the recusername to set
	 */
	public void setRecusername(String recusername) {
		this.recusername = recusername;
	}

	/**
	 * @return the recaccounttype
	 */
	public String getRecaccounttype() {
		return recaccounttype;
	}

	/**
	 * @param recaccounttype the recaccounttype to set
	 */
	public void setRecaccounttype(String recaccounttype) {
		this.recaccounttype = recaccounttype;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transfer [sendaccountno=" + sendaccountno + ", sendusername=" + sendusername + ", sendaccounttype="
				+ sendaccounttype + ", amount=" + amount + ", recaccountno=" + recaccountno + ", recusername="
				+ recusername + ", recaccounttype=" + recaccounttype + "]";
	}
	

}
