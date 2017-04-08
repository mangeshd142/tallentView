<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="Subfiles/cssjshead.jsp" %> 
				<%@ include file="Subfiles/head.jsp" %>    
	</head>
	
	<body>
	
	<div class="col-sm-6" style="float:right; margin-right:25%;margin-top: 05%;margin-bottom: 6%">
	 
		<div class="panel panel-default">
	      <div class="panel-heading">Bank Information</div>
	     	 <div class="panel-body">
	     
							  <form:form action="authnticateAccountInfo" commandName="account" method="post">
							  	
							  	<div class="form-group row">
							      <label for="inputEmail3" class="col-sm-3 col-form-label">Bank Name</label>
							      <form:errors path="bank_nm" style="float:right;color:red"/> 
							      <div class="col-sm-10">
							         <form:input path="bank_nm" class="form-control" id="inputEmail3" placeholder="Enter Bank Name"/>
							      </div>
								</div>
							  
							    <div class="form-group row">
							      <label for="inputEmail3" class="col-sm-3 col-form-label">Account Holder Name</label>
							      <form:errors path="ac_name" style="float:right;color:red"/> 
							      <div class="col-sm-10">
							         <form:input path="ac_name" class="form-control" id="inputEmail3" placeholder="Enter Name"/>
							      </div>
								</div>
								
							    <div class="form-group row">
							      <label for="inputPassword3" class="col-sm-3 col-form-label">Account No</label>
							      <form:errors path="account_no" style="float:right;color:red"/> 
							      <div class="col-sm-10">
							        <form:input path="account_no" class="form-control" id="inputPassword3" placeholder="Enter Account Number"/>
							      </div>
							    </div>
							    
							    <div class="form-group row">
							      <label for="inputPassword3" class="col-sm-3 col-form-label">IFSC Code</label>
							      <form:errors path="ifcs_code" style="float:right;color:red"/> 
							      <div class="col-sm-10">
							        <form:input path="ifcs_code" class="form-control" id="inputPassword3" placeholder="Enter IFSC Code"/>
							      </div>
							    </div>
							    
							    
							    <div class="form-group row" style="float: right">
							      <div class="offset-sm-2 col-sm-6">
							        <input type="submit" value="Submit" class="btn btn-primary"/>
							      </div>
							    </div>
							  </form:form>
			</div>
		</div>
		
	</div>
	
		<%@ include file="Subfiles/footer.jsp" %>
		
		<%@ include file="Subfiles/cssjsfoot.jsp" %>
	
	</body>
</html>
