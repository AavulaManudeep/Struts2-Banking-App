<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <style type="text/css">
    body
    {
    background-image:url("moneyback.jpg");	
    bacground-repeat:no-repeat;
    background-size:cover;
    }
    .card
    {
    	height:900px;
    	background-color:gray;
    	margin-top:80px;
    	font-size:30px;
    	opticity:0.5;
    	color:white;
    }
    .card-body
    {
    	text-align:center;
    	color:white;
   
    }
    .single
    {
    padding-top:50px;
    	
    }
    .card img
    {
    	height:50%;
    	width:100%;
    }
    .lbs
    {
    	float:left;
    	margin-top:50px;
    }
    .mytext
    {
    	height:50px;
    	width:140%;
    	font-size:20px;
    	margin-top:30px;
    	color:black;
    	
    }
    .btn
    {
    	float:right;
    	margin-top:50px;
    	width:200px;
    	height:40px;
    	font-size:20px;
    	color:black;
    	
    }
    .dbtn
    {
    	float:right;
    	margin-top:50px;
    	width:200px;
    	height:40px;
    	font-size:20px;
    	color:black;
    
    }
    .dbtn:hover
    {
    	background-color:red;
    	color:white;
    }
    
    .card_2
    {
    	font-size:20px;
    	width:120%;
    	margin-top:30px;
    	color:black;
    }
    .rad
    {
    	font-size:20px;
    }
    .btn:hover
    {
    	background-color:green;
    	color:white;
    	font-weight:20px;
    }
    #lbbt
    {
    	margin-top:20px;
    }
    .btmclass
    {
    	margin-top:30px;
    }
    .floating
    {
    	float:left;
    }
   
    .form1 .card_2
    {
    	margin-top:70px;
    	height:40px;
    }
    .form1 .rad
    {
    	margin-top:70px;
    }
    </style>
</head>
<div class="card-group">
 <div class="col-sm-4">
  <div class="card">
    <div class="card-body">
      <s:label value="Tranfers Between Accounts" ></s:label>
      <s:form action="transfer">
      <s:label value="FROM Account" cssClass="lbs"></s:label>
      <s:textfield name="sendaccountno" label="Account Number" placeholder="Account Number" cssClass="mytext"></s:textfield>
      <s:textfield name="sendusername" label="Username" placeholder="Username" cssClass="mytext"></s:textfield>
      <s:radio name="sendaccounttype" label="Account type" list="{'Savings','Checking'}" cssClass="rad"></s:radio>
      <s:textfield name="amount" label="Money$" placeholder="Money in Dollers $" cssClass="mytext"></s:textfield>
      <s:label value="TO Account" cssClass="lbs"></s:label>
      <s:textfield name="recaccountno" label="Account Number" placeholder="Account Number" cssClass="mytext"></s:textfield>
      <s:textfield name="recusername" label="Username" placeholder="Username" cssClass="mytext"></s:textfield>
      <s:radio name="recaccounttype" label="Account type" list="{'Savings','Checking'}" cssClass="rad"></s:radio>
      <s:submit name="trans" value="Transfer" cssClass="btn"></s:submit>
      </s:form>
    </div>
  </div>
  </div>
   <div class="col-sm-4">
  <div class="card">
    <div class="card-body" class="single">
      <s:form  action="deposit" cssClass="form1">
      <s:label value="Deposit/Credit"></s:label>
      <s:textfield name="accountnumber" label="Account Number" placeholder="Account Number" cssClass="card_2" ></s:textfield>
      <s:radio name="accounttype" label="Account type"  list="{'Savings','Checking'}"  cssClass="rad"></s:radio>
      <s:textfield name="amount" label="Money$" placeholder="Money in Dollers $" cssClass="card_2"></s:textfield>
      <s:submit name="dep" value="Deposit" cssClass="btn" ></s:submit>
      </s:form> 
    </div>
  </div>
  </div>
   <div class="col-sm-4">
  <div class="card">
      <div class="card-body" class="single">
       <s:form action="withdraw" cssClass="form1">
      <s:label value="Withdraw/Debit" id="lbbt"></s:label>
      <s:textfield name="accountnumber" label="Account Number" placeholder="Account Number" cssClass="card_2" ></s:textfield>
      <s:radio name="accounttype" label="Account type" list="{'Savings','Checking'}" cssClass="rad"></s:radio>
      <s:textfield name="amount" label="Money$" placeholder="Money in Dollers $"  cssClass="card_2"></s:textfield>
      <s:submit name="draw" value="Withdraw" cssClass="btn"></s:submit>
      </s:form>
      </div>
     </div>
  </div>
  </div>
  
  
  <div class="card-group">
 <div class="col-sm-4">
  <div class="card">
    <div class="card-body"  class="single">
      <s:label value="Add Customer" ></s:label>
       <s:form cssClass="form1" action="createaccount">
      <s:textfield name="accountusername" label="Username" placeholder="UserName" cssClass="card_2" ></s:textfield>
      <s:textfield name="accountnumber" label="Account Number" placeholder="Account Number"  cssClass="card_2"></s:textfield>
      <s:submit name="add_acct" value="Add Customer" cssClass="btn"></s:submit>
      </s:form>
    </div>
  </div>
  </div>
   <div class="col-sm-4">
  <div class="card">
    <div class="card-body" class="single">
    <s:label value="Delete Customer" ></s:label>
      <s:form action ="delete" cssClass="form1">
      <s:textfield name="accountusername" label="Username" placeholder="UserName" cssClass="card_2" ></s:textfield>
      <s:textfield name="accountnumber" label="Account Number" placeholder="Account Number"  cssClass="card_2"></s:textfield>
      <s:submit name="delet_acct" value="Delete Customer" cssClass="dbtn"></s:submit>
      </s:form>
     
    </div>
  </div>
  </div>
   <div class="col-sm-4">
  <div class="card">
   
      <div class="card-body"  class="single">
      <s:label value="Customer Transactions"></s:label>
      <s:form cssClass="form1">
      <s:textfield name="username" label="Username" placeholder="UserName" cssClass="card_2" ></s:textfield>
      <s:textfield name="addaccount" label="Account Number" placeholder="Account Number"  cssClass="card_2"></s:textfield>
      <s:radio name="act_type" label="Account type" list="{'Savings','Checking'}" cssClass="rad"></s:radio>
      <s:submit name="trans" value="Transactions" cssClass="btn"></s:submit>
      </s:form>
      </div>
      </div>
    </div>
    </div>
     
 
    <!-- YOUR CODE HERE -->
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>