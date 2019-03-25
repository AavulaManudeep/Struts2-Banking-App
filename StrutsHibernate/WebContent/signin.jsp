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
	 background-image: url("blue.png");
	 background-repeat: no-repeat, repeat;
	 background-size: cover;
	 height:100%;
}
.mytext
{
	height:50px;
	width:450px;
	margin-top:20px;
}
#sub 
{
	margin-left:60px;
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
	height:600px;
	width:650px;
	background-image: url("Banner.png");
	background-repeat: no-repeat, repeat;
	background-size: cover;
	height:100%;
	margin-left:650px;
	margin-top:300px;
	opticity:0.2;
	
	
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
<%-- <div class="regi">
<s:text name="Registration Form for Customers" ></s:text>
<s:form action="register" method="post">
<s:textfield name="username" label="UserName" placeholder="username" cssClass="mytext"></s:textfield>
<s:password name="pass" label="Password" placeholder="password" cssClass="mytext"></s:password>
<s:password  name="cpass" label="ConfirmPassword" placeholder="re-enter" cssClass="mytext"></s:password >
<s:textfield name="email" label="EmailId" placeholder="emailid" cssClass="mytext"></s:textfield>
<s:textfield name="phone" label="Phone.No" placeholder="0123456789" cssClass="mytext" maxlength="10"></s:textfield>
<s:textfield name="address" label="Address" placeholder="234 abc st,piscatawa,NJ" cssClass="mytext"></s:textfield>
<s:textfield name="zipcode" label="Zipcode" placeholder="12345" cssClass="mytext"></s:textfield>
<s:radio name="usertype" label="Usertype" list="{'Admin','Customer'}" ></s:radio>
<s:checkboxlist name="accounttype" label="AccountType" list="{'Savings','Checking'}"></s:checkboxlist>

<s:submit name="sub"></s:submit>
<s:reset name="reset"></s:reset>
<table>
<tr><td><input type="submit" value="Register" name="register" id="sub" class="btn">
<input type="reset" value="Reset" name="reset" id="res" class="btn"></td>
</tr>
</table>
</s:form>
</div> --%>
<div class="regi1">
<s:text name="Customer and Admin SignIn" ></s:text>
<s:form action="signin" method="post">
<s:textfield name="susername" label="UserName" placeholder="username" cssClass="mytext"></s:textfield>
<s:password  name="spass" label="Password" placeholder="password" cssClass="mytext"></s:password >
<s:radio name="susertype" label="Usertype" list="{'Admin','Customer'}" ></s:radio>
<table>
<tr><td><input type="submit" value="SignIn" name="signin" id="sub" class="btn">
<input type="reset" value="Reset" name="reset" id="res" class="btn"></td>
</tr>
</table>
</s:form>
<a href="index.jsp">Registration</a>
</div>
</body>
</html>