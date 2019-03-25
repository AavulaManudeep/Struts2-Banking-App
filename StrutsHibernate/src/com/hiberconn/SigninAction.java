/**
 * 
 */
package com.hiberconn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;
import com.pojoclasses.RegisterPOJO;

/**
 * @author manu
 *
 */
public class SigninAction extends ActionSupport{
	Session session=null;
	org.hibernate.Transaction transaction =null;
	private String susername;
	private String spass;
	private String susertype;
	
	/**
	 * @return the susername
	 */
	public String getSusername() {
		return susername;
	}

	/**
	 * @param susername the susername to set
	 */
	public void setSusername(String susername) {
		this.susername = susername;
	}

	/**
	 * @return the spass
	 */
	public String getSpass() {
		return spass;
	}

	/**
	 * @param spass the spass to set
	 */
	public void setSpass(String spass) {
		this.spass = spass;
	}

	/**
	 * @return the susertype
	 */
	public String getSusertype() {
		return susertype;
	}

	/**
	 * @param susertype the susertype to set
	 */
	public void setSusertype(String susertype) {
		this.susertype = susertype;
	}

	/**
	 * @return the usertype
	 */
	

	public String execute()
	{
		
		return SUCCESS;
	}
	
	public void validate() {
		//System.out.println("REgister value:"+toString());
		
		  if(susername==null|| susername.equals("")) {
		  addFieldError("susername","username cannot be empty");
		  
		  } if(spass==null||spass.trim().equals("")) {
		  addFieldError("spass","username cannot be empty");
		  
		  } 
		  
		  if (susertype==null) { addFieldError("susertype","username cannot be empty");
		  
		  }
	}
	

	public String Login()
	{
		boolean valid=false;
		
		try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();
			/*
			 * Query<RegisterPOJO> query =
			 * session.createQuery("FROM RegisterPOJO R WHERE R.username =:uname");
			 * 
			 * Object result =(RegisterPOJO) query.getSingleResult();
			 */
           // System.out.println(result);
            RegisterPOJO registerPOJO = (RegisterPOJO) session.get("com.pojoclasses.RegisterPOJO", susername);
            		System.out.println(registerPOJO.getPass());
            if(registerPOJO.getPass().equals(spass)&&registerPOJO.getUsername().equals(susername)&&registerPOJO.getUsertype().equals(susertype))
            {
            	valid=true;
            }
        }
		 catch (Exception e) {
            if (transaction != null) {
               System.out.println("Transaction is being rolled back.");
               transaction.rollback();
            }
            e.printStackTrace();
         } finally {
            if (session != null) {
               session.close();
            }
         }
        // HibernateUtil.shutdown();
         if(valid)
         {
        	 return susertype; 
         }
		else {
			 return INPUT; 
		}
		 //return SUCCESS;
		
	}

}
