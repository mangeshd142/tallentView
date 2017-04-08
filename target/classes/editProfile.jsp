<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@page import="com.talent.usermodel.controler.GetInfo"%>
<%@page import="java.util.Date"%>
<%@page import="com.talent.usermodel.Profile"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> --%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<%@ include file="Subfiles/cssjshead.jsp" %> 
<script type="text/javascript" src="<ss:url value="/resources/bootstrap/datepikar/jquery-1.12.4.min.js"/>"></script>
<link rel="stylesheet" href="<ss:url value="/resources/bootstrap/datepikar/bootstrap-datepicker3.css"/>"/>

<%@ include file="Subfiles/head.jsp" %>   
 <script>
	$(document).ready(function(){
		var date_input=$('input[id="date"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'M-dd-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
</script>
</head>

<body>


<div class="page-header">
  
<div class='form aniamted bounceIn'>
             
  <div class='register'>
    <h2>Create An Account</h2>
    	
            <s:if test="hasActionErrors()">
			   <div class="errors">
			      <s:actionerror/>
			   </div>
			</s:if>
            
            
            <div class="container">
    <div class="row">
        
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>



     <form:form action="saveProfile" commandName="profile" method="post">
			
			
			<label>Date of Birth :</label>
			<form:errors path="dob" style="float:right;color:red"/> 
			<form:input path="dob" class="form-control" id="date" placeholder="dd-mm-yyyy" />
			
			<label>Phone no :</label>
			<form:errors path="phoneno" style="float:right;color:red"/> 
			<form:input path="phoneno" placeholder="" />
			<label>Address :</label>
			<form:input path="address" placeholder="" />
			<label>Country :</label>
			<form:input path="country" placeholder="" />
			<label>State :</label>
			<form:input path="state" placeholder="" />
			<label>City :</label>
			<form:input path="city" placeholder="" />
			<label>Pin Code :</label>
			<form:errors path="pincode" style="float:right;color:red"/> 
			<form:input path="pincode" placeholder="" />
			<label>Enter your Skills :</label>
			<form:input path="skills" placeholder="" />
			<input type="submit" value="Save" id="button"/>
	</form:form>
    
  </div>
  
</div>
</div>
<%@ include file="Subfiles/footer.jsp" %>
<%@ include file="Subfiles/cssjsfoot.jsp" %>

</body>
</html>
