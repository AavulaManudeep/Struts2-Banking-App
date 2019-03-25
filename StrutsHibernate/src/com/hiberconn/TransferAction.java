/**
 * 
 */
package com.hiberconn;

import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojoclasses.Accounttype;
import com.pojoclasses.Transfer;

/**
 * @author manu
 *
 */
public class TransferAction extends ActionSupport implements ModelDriven<Transfer>{
	
	Session session = null;

	Transaction transaction=null;
	Transfer trans = new Transfer();
	@Override
	public Transfer getModel() {
		// TODO Auto-generated method stub
		return trans;
	}
	public String execute()
	{
		return SUCCESS;
	}
	
	public void validate()
	{
		
		System.out.println(trans);
		  if(trans.getSendaccountno()==null|| trans.getSendaccountno().trim().equals(""))
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getSendaccounttype()==null)
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getSendusername()==null|| trans.getSendusername().trim().equals(""))
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getRecaccountno()==null|| trans.getRecaccountno().trim().equals(""))
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getRecaccounttype()==null)
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getRecusername()==null|| trans.getRecusername().trim().equals(""))
		  {
		  addFieldError("accountnumber","username cannot be empty");
		  
		  } 
		  if(trans.getAmount()==0) {
		  addFieldError("amount","username cannot be empty");
		  
		  } 
		
	}
	
	public String Transfering()
	{	
	try {
		System.out.println(trans);
	    session = HibernateUtil.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	/*
	 * Set<UserAccNum> user = new HashSet<UserAccNum>(); user.add(userAccNum);
	 */
	   //Accounttype accounttype = (Accounttype) session.get("Accounttype", depositwithdraw.getAccountnumber());
	   
	    long query1 = (long) session.createQuery("select amount from Accounttype where accountnumber='"+trans.getSendaccountno()+"'"+"and accounttype='"+trans.getSendaccounttype()+"'").uniqueResult(); 
			/*
			 * Criteria cr = session.createCriteria(Accounttype.class);
			 * cr.setProjection(Projections.property("amount")); Criterion accnum =
			 * Restrictions.eq("account.setaccountnumber",trans.getSendaccountno());
			 * Criterion acctype = Restrictions.eq("accountype",trans.getSendaccounttype());
			 * LogicalExpression andExp = Restrictions.and(accnum, acctype); cr.add( andExp
			 * ); long results = (long) cr.uniqueResult();
			 */
	    System.out.println(query1);
	    if(query1-trans.getAmount()>=0)
		   {
		   Query query = session.createQuery("update  Accounttype set amount=amount-"+trans.getAmount()+" where accountnumber="+ "'"+trans.getSendaccountno()+"'"+"and accounttype="+"'"+trans.getSendaccounttype()+"'"); 
			   int result = query.executeUpdate();
			   Query query2 = session.createQuery("update  Accounttype set amount=amount+"+trans.getAmount()+" where accountnumber="+ "'"+trans.getRecaccountno()+"'"+"and accounttype="+"'"+trans.getRecaccounttype()+"'");   
			   int result1 = query2.executeUpdate();
			   transaction.commit();
			   if(result>0)
			   {
			   transactions(trans.getSendaccounttype(), trans.getSendaccountno(),trans.getAmount());
			   transactions(trans.getRecaccounttype(), trans.getRecaccountno(),trans.getAmount()*-1);
			   }
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
		 checkinJsonObject.put("amount", amount);
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
