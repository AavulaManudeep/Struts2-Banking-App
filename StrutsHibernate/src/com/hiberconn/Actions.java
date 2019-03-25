/**
 * 
 */
package com.hiberconn;

import java.awt.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojoclasses.RegisterPOJO;





/**
 * @author manu
 *
 */
public class Actions extends ActionSupport implements ModelDriven{

	Session session=null;
	org.hibernate.Transaction transaction =null;
	 RegisterPOJO registrations= new RegisterPOJO();
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return registrations;
	}
	
	public String execute()
	{
		return SUCCESS;
	}
	public String Registration()
	{
		 try {
             session = HibernateUtil.getSessionFactory().openSession();
             transaction = session.beginTransaction();
             System.out.println(registrations);
    		 session.save(registrations);
    		 transaction.commit();
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
		
		return SUCCESS;
	}
	public void validate() {
		System.out.println("REgister value:"+toString());
		
		  if(registrations.getUsername()==null|| registrations.getUsername().trim().equals("")) {
		  addFieldError("username","username cannot be empty");
		  
		  } if(registrations.getPass()==null||registrations.getPass().trim().equals("")) {
		  addFieldError("pass","username cannot be empty");
		  
		  } 
		  
		  if (registrations.getUsertype()==null) { addFieldError("usertype","username cannot be empty");
		  
		  }
		  System.out.println(registrations.getSavings()+registrations.getChecking());
		   if (registrations.getSavings()==null && registrations.getChecking()==null) {
		  addFieldError("usertype","username cannot be empty"); }
		
	}
	
	

}
