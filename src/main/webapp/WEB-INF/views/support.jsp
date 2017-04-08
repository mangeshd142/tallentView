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
	<center>
	<h4 style="margin-top: 2%">Please your query in below form or mail us on <span style="color: blue">support@tallentview.com</span></h4>
	</center>
	<div class="col-sm-6 pull-right" style=" margin-right:25%;margin-top: 02%;margin-bottom: 6%">
	 
		<div class="panel panel-default">
	      <div class="panel-heading">Enter Support Query </div>
	     	 <div class="panel-body">
	     
							  <form:form action="thankYou" commandName="support" method="post">
							  	
							  	<div class="form-group row">
							      <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
							      <div class="col-sm-10">
							         <form:input path="name" class="form-control" id="inputEmail3" placeholder="Enter Your Name"/>
							      <form:errors path="name" style="float:right;color:red"/> 
							      </div>
								</div>
							  
							    <div class="form-group row">
							      <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
							      <div class="col-sm-10">
							         <form:input path="email" class="form-control" id="inputEmail3" placeholder="Enter Email"/>
							      <form:errors path="email" style="float:right;color:red"/> 
							      </div>
								</div>
								
							    <div class="form-group row">
							      <label for="inputPassword3" class="col-sm-2 col-form-label">Subject</label>
							      <div class="col-sm-10">
							        <form:input path="subject" class="form-control" id="inputPassword3" placeholder="Enter Subject"/>
							      <form:errors path="subject" style="float:right;color:red"/> 
							      </div>
							    </div>
							    
							    <div class="form-group row">
							      <label for="inputPassword3" class="col-sm-2 col-form-label">Message</label>
							      <div class="col-sm-10">
							        <form:textarea rows="8" path="message" class="form-control" id="inputPassword3"/>
							      <form:errors path="message" style="float:right;color:red"/> 
							      </div>
							    </div>
							    
							    
							    <div class="form-group row" style="float: right">
							      <div class="offset-sm-2 col-sm-6">
							        <input type="submit" value="Send" class="btn btn-primary"/>
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
