/**
 * 
 */
package com.hiberconn;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojoclasses.Accountcomppk;
import com.pojoclasses.Accounttype;
import com.pojoclasses.RegisterPOJO;
import com.pojoclasses.UserAccNum;

/**
 * @author manu
 *
 */
public class AdminActions extends ActionSupport implements ModelDriven<UserAccNum>{
	
	UserAccNum userAccNum = new UserAccNum();
	Session session =null;
	org.hibernate.Transaction transaction = null;
	
	
	public String execute()
	{
		return SUCCESS;
	}
	
	public void validate()
	{
		System.out.println(userAccNum);
		  if(userAccNum.getAccountusername()==null|| userAccNum.getAccountusername().trim().equals("")) {
		  addFieldError("username","username cannot be empty");
		  
		  } if(userAccNum.getAccountnumber()==null||userAccNum.getAccountnumber().trim().equals("")) {
		  addFieldError("pass","username cannot be empty");
		  
		  } 
	}
	
	public String CreateAccount()
	{
		try {
				System.out.println(userAccNum);
			    session = HibernateUtil.getSessionFactory().openSession();
			    transaction = session.beginTransaction();
			/*
			 * Set<UserAccNum> user = new HashSet<UserAccNum>(); user.add(userAccNum);
			 */
			    RegisterPOJO registerPOJO = (RegisterPOJO) session.get("com.pojoclasses.RegisterPOJO", userAccNum.getAccountusername());
				
			    if(registerPOJO!=null)
			    {	
			    	Accountcomppk checkaccountcomppk=null;
			    	Accounttype checkaccounttype =null;
			    	Accountcomppk saveaccountcomppk=null;
			    	Accounttype saveaccounttype =null;
			    	if(registerPOJO.getChecking()!=null)

			    	{
			    		 checkaccountcomppk = new Accountcomppk(userAccNum.getAccountnumber(),"Checking");
			    		 checkaccounttype = new Accounttype(checkaccountcomppk,0);
			    		 transactions("Checking",userAccNum.getAccountnumber());
			    		
			    	}
			    	if(registerPOJO.getSavings()!=null)
			    	{
			    		 saveaccountcomppk = new Accountcomppk(userAccNum.getAccountnumber(),"Savings");
			    		 saveaccounttype = new Accounttype(saveaccountcomppk,0);
			    		 transactions("Savings",userAccNum.getAccountnumber());
			    		
			    	}
			    	
			    	
				    session.save(userAccNum);
				    session.save(checkaccounttype);
				    session.save(saveaccounttype);
				    transaction.commit();
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

	@Override
	public UserAccNum getModel() {
		// TODO Auto-generated method stub
		return userAccNum;
	}
	
	public String DeleteAccount()
	{	
	try {
		System.out.println(userAccNum);
	    session = HibernateUtil.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	/*
	 * Set<UserAccNum> user = new HashSet<UserAccNum>(); user.add(userAccNum);
	 */
	   //Accounttype accounttype = (Accounttype) session.get("Accounttype", depositwithdraw.getAccountnumber());
	  // long query1 = (long) session.createQuery("Select amount from Accounttype  where accountnumber="+"'"+depositwithdraw.getAccountnumber()+"'"+"and accounttype="+"'"+depositwithdraw.getAccounttype()+"'").uniqueResult(); 
			/*
			 * //System.out.println(query1); RegisterPOJO registerPOJO = (RegisterPOJO)
			 * session.get("com.pojoclasses.RegisterPOJO", userAccNum.getAccountusername());
			 * 
			 * 
			 * Criteria cr = session.createCriteria(UserAccNum.class);
			 * 
			 * Criterion accnum
			 * =Restrictions.eq("account.setaccountnumber",userAccNum.getAccountnumber());
			 * Criterion acctype =
			 * Restrictions.eq("accountype",userAccNum.getAccountusername());
			 * LogicalExpression andExp = Restrictions.and(accnum, acctype); cr.add(
			 * andExp); //long results = (long) cr.uniqueResult();
			 * 
			 * 
			 * Criteria cr1 = session.createCriteria(Accounttype.class);
			 * //cr1.setProjection(Projections.property("amount")); Criterion accnum1 =
			 * Restrictions.eq("account.setaccountnumber",userAccNum.getAccountnumber());
			 * Criterion acctype1 =
			 * Restrictions.eq("accountype",userAccNum.getAccountusername());
			 * LogicalExpression andExp1 = Restrictions.and(accnum, acctype); cr.add(
			 * andExp);
			 */
			  //long results = (long) cr.uniqueResult();
			 
	    
			
			  Query query =
			  session.createQuery("DELETE FROM Accounttype where accountnumber='"
			  +userAccNum.getAccountnumber()+"'");
			  query.executeUpdate();
			  Query query1 =
			  session.createQuery("DELETE FROM UserAccNum where accountnumber='"+userAccNum
			  .getAccountnumber()+"'"+"and accountusername='"+userAccNum.getAccountusername
			  ()+"'");
			  query1.executeUpdate();
			  Query query2 =
			  session.createQuery("DELETE FROM  RegisterPOJO where username='"+userAccNum.
			  getAccountusername()+"'");
			  query2.executeUpdate();
		   
		   transaction.commit();
		   
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
	
	public void transactions(String acctype, String AccNum)
	{
		 JSONObject checkinJsonObject = new JSONObject();
		 checkinJsonObject.put("accountnumber",userAccNum.getAccountnumber());
		 checkinJsonObject.put("accounttype",acctype);
		 checkinJsonObject.put("amount", 0);
		 checkinJsonObject.put("date",java.time.LocalDate.now());
		 checkinJsonObject.put("time",java.time.LocalTime.now());
		 
		 try (FileWriter file = new FileWriter(userAccNum.getAccountnumber()+".json")) {

	            file.write(checkinJsonObject.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.print(checkinJsonObject);
	}

}
