<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body
{
	 background-image: url("banking.jpeg");
	 background-repeat: no-repeat, repeat;
	 background-size: cover;
	 height:100%;
}
.mytext
{
	height:50px;
	width:450px;
	margin-top:20px;
	allign:center;
}
#sub 
{
	margin-left:100px;
	margin-right:300px;
	background-color:green;
	height:50px;
	width:100px;
	border-radius:5px;
	cursor:pointer;
}
#res 
{
	margin-top:50px;
	background-color:green;
	height:50px;
	width:100px;
	border-radius:5px;
	cursor:pointer;
}

.regi1
{
	
	color:white;
	font-size:25px;
	height:900px;
	width:1000px;
	background-image: url("Banner.png");
	background-repeat: no-repeat, repeat;
	background-size: cover;
	margin-left:500px;
	margin-top:20px;
	
}
.text
{
margin-left:100px;
}
.form{
align:center;
margin-left:100px;
}

a
{
 text-decoration:none;
 color:white;
 text-align:center;
 margin-left:250px
}
a:hover
{
	color:blue;
}
</style> 

</head>
<body>
<div class="regi1">
<s:form action="register" method="post" cssClass="form">
<s:text name="Registration Form for Customers" ></s:text>
<s:textfield name="username" label="UserName" placeholder="username" cssClass="mytext"></s:textfield>
<s:password name="pass" label="Password" placeholder="password" cssClass="mytext"></s:password>
<s:textfield name="email" label="EmailId" placeholder="emailid" cssClass="mytext"></s:textfield>
<s:textfield name="phone" label="Phone.No" placeholder="0123456789" cssClass="mytext" maxlength="10"></s:textfield>
<s:textfield name="address" label="Address" placeholder="234 abc st,piscatawa,NJ" cssClass="mytext"></s:textfield>
<s:textfield name="zipcode" label="Zipcode" placeholder="12345" cssClass="mytext"></s:textfield>
<s:radio name="usertype" label="Usertype" list="{'Admin','Customer'}" ></s:radio>
<s:radio name="savings" label="Savings" list="{'Savings'}" ></s:radio>
<s:radio name="checking" label="Checking" list="{'Checking'}" ></s:radio>
<%-- <s:checkboxlist name="accounttype" label="AccountType" list="{'Savings','Checking'}"></s:checkboxlist> --%>
<s:submit name="sub"></s:submit>
</s:form>
</div>
</body>
</html>