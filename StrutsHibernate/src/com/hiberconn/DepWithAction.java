/**
 * 
 */
package com.hiberconn;

import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojoclasses.Accountcomppk;
import com.pojoclasses.Accounttype;
import com.pojoclasses.DepositWithdraw;
import com.pojoclasses.RegisterPOJO;

/**
 * @author manu
 *
 */
public class DepWithAction extends ActionSupport implements ModelDriven<DepositWithdraw> {
	
	Session session = null;

	Transaction transaction=null;
	DepositWithdraw depositwithdraw = new DepositWithdraw();
	
	@Override
	public DepositWithdraw getModel() {
		// TODO Auto-generated method stub
		return depositwithdraw;
	}
	public String execute()
	{
		return SUCCESS;
	}
	
	public void validate()
	{
		
		System.out.println(depositwithdraw);
		  if(depositwithdraw.getAccountnumber()==null|| depositwithdraw.getAccountnumber().trim().equals("")) {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } if(depositwithdraw.getAmount()==0) {
		  addFieldError("amount","username cannot be empty");
		  
		  } 
		
	}
	
	public String Deposit()
	{	
	try {
		System.out.println(depositwithdraw);
	    session = HibernateUtil.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	/*
	 * Set<UserAccNum> user = new HashSet<UserAccNum>(); user.add(userAccNum);
	 */
	   //Accounttype accounttype = (Accounttype) session.get("Accounttype", depositwithdraw.getAccountnumber());
	   
	   Query query = session.createQuery("update  Accounttype set amount=amount+"+depositwithdraw.getAmount()+" where accountnumber="+ depositwithdraw.getAccountnumber()+"and accounttype="+"'"+depositwithdraw.getAccounttype()+"'"); 
	 
	   
	   	
		   int result = query.executeUpdate();
		   
		   transaction.commit();
		   transactions(depositwithdraw.getAccounttype(), depositwithdraw.getAccountnumber(),depositwithdraw.getAmount());
	    
	}
	
    catch (Exception e) 
		{
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
	
	public String Withdraw()
	{	
	try {
		System.out.println(depositwithdraw);
	    session = HibernateUtil.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	/*
	 * Set<UserAccNum> user = new HashSet<UserAccNum>(); user.add(userAccNum);
	 */
	   //Accounttype accounttype = (Accounttype) session.get("Accounttype", depositwithdraw.getAccountnumber());
	   long query1 = (long) session.createQuery("Select amount from Accounttype  where accountnumber="+"'"+depositwithdraw.getAccountnumber()+"'"+"and accounttype="+"'"+depositwithdraw.getAccounttype()+"'").uniqueResult(); 
	   System.out.println(query1);
	   if(query1-depositwithdraw.getAmount()>=0)
	   {
	   Query query = session.createQuery("update  Accounttype set amount=amount-"+depositwithdraw.getAmount()+" where accountnumber="+ "'"+depositwithdraw.getAccountnumber()+"'"+"and accounttype="+"'"+depositwithdraw.getAccounttype()+"'"); 
	 
	   
	   	
		   int result = query.executeUpdate();
		   
		   transaction.commit();
		   if(result>0)
		   transactions(depositwithdraw.getAccounttype(), depositwithdraw.getAccountnumber(),depositwithdraw.getAmount());
	   }
	    
	}
	
    catch (Exception e) 
		{
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
	
	
	public void transactions(String acctype, String AccNum,long amount)
	{
		 JSONObject checkinJsonObject = new JSONObject();
		 checkinJsonObject.put("accountnumber",AccNum);
		 checkinJsonObject.put("accounttype",acctype);
		 checkinJsonObject.put("amount", amount*(-1));
		 checkinJsonObject.put("date",java.time.LocalDate.now());
		 checkinJsonObject.put("time",java.time.LocalTime.now());
		 
		 try (FileWriter file = new FileWriter(AccNum+".json",true)) {

	            file.write(checkinJsonObject.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.print(checkinJsonObject);
	}



}
