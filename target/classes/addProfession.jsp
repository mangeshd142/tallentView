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



     <form:form action="saveProfession" commandName="profession" method="get">
			
			
			<label>Company Name :</label>
			<form:errors path="companyName" style="float:right;color:red"/> 
			<form:input path="companyName" placeholder="" />
			<label>profile :</label>
			<form:errors path="profile" style="float:right;color:red"/> 
			<form:input path="profile" placeholder="" />
			<label>Currently working :</label>
			<form:errors path="currently_working" style="float:right;color:red"/> 
			
			<form:radiobutton path="currently_working" value="yes" label="Yes" /> 
            <form:radiobutton path="currently_working" value="no" label="No" /><br />
			<label>Experience :</label>
			<form:errors path="experience" style="float:right;color:red"/> 
			<form:select path="experience" class="form-control" style="width:300px">
			    <form:option value="" label="Select One" />
			    <form:option value=">3 month"/><form:option value=">6 month"/><form:option value=">1 year"/>
			    <form:option value=">2 year"/><form:option value=">3 year"/><form:option value=">4 year"/>
			    <form:option value=">5 year"/><form:option value=">6 year"/><form:option value=">7 year"/>
			    <form:option value=">8 year"/><form:option value=">9 year"/><form:option value=">10 year"/>
			    <form:option value=">11 year"/><form:option value=">12 year"/><form:option value=">13 year"/>
			    <form:option value=">14 year"/><form:option value=">15 year"/><form:option value=">16 year"/>
			    <form:option value=">17 year"/><form:option value=">18 year"/><form:option value=">19 year"/>
			    <form:option value=">20 year"/><form:option value=">21 year"/><form:option value=">22 year"/>
			</form:select><br/>
			<label>Description :</label>
			<form:input path="description" placeholder=""/>
			
			<input type="submit" value="Save" id="button"/>
	</form:form>
    
  </div>
  
</div>
</div>
<%@ include file="Subfiles/footer.jsp" %>
<%@ include file="Subfiles/cssjsfoot.jsp" %>

</body>
</html>
