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



     <form:form action="saveEducation" commandName="addEducation" method="get">
			
			
			<label>Institute Name :</label>
			<form:errors path="institute_name" style="float:right;color:red"/> 
			<form:input path="institute_name" placeholder="" />
			<label>Degree :</label>
			<form:errors path="degree" style="float:right;color:red"/> 
			<form:input path="degree" placeholder="" />
			<label>Field :</label>
			<form:errors path="field" style="float:right;color:red"/> 
			<form:input path="field" placeholder="" />
			<label>Pass out Year :</label>
			<form:errors path="passout_year" style="float:right;color:red"/> 
			<%-- <form:input path="passout_year" placeholder="" /> --%>
			<form:select path="passout_year" class="form-control" style="width:300px">
			    <form:option value="" label="Select One" />
			    <form:option value="1980"/><form:option value="1981"/><form:option value="1982"/>
			    <form:option value="1983"/><form:option value="1984"/><form:option value="1985"/>
			    <form:option value="1986"/><form:option value="1987"/><form:option value="1988"/>
			    <form:option value="1989"/><form:option value="1990"/><form:option value="1991"/>
			    <form:option value="1992"/><form:option value="1993"/><form:option value="1994"/>
			    <form:option value="1995"/><form:option value="1996"/><form:option value="1997"/>
			    <form:option value="1998"/><form:option value="1999"/><form:option value="2000"/>
			    <form:option value="2001"/><form:option value="2002"/><form:option value="2003"/>
			    <form:option value="2004"/><form:option value="2005"/><form:option value="2006"/>
			    <form:option value="2007"/><form:option value="2008"/><form:option value="2009"/>
			    <form:option value="2010"/><form:option value="2011"/><form:option value="2012"/>
			    <form:option value="2013"/><form:option value="2014"/><form:option value="2015"/>
			    <form:option value="2016"/><form:option value="2017"/><form:option value="2018"/>
			    
			</form:select><br/>
			
			<label>Percentage :</label>
			<form:errors path="percentage" style="float:right;color:red"/> 
			<form:input path="percentage" placeholder=""/>
			
			<input type="submit" value="Save" id="button"/>
	</form:form>
    
  </div>
  
</div>
</div>
<%@ include file="Subfiles/footer.jsp" %>
<%@ include file="Subfiles/cssjsfoot.jsp" %>

</body>
</html>
