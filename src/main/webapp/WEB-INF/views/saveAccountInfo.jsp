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
	
	    <div class="col-md-6" style="margin-left: 25%;margin-top: 60px; margin-bottom: 80px">
            <div class="panel panel-info">
                <div class="panel-heading">
                     <h4>Account Info</h4>
                </div>
                <ul class="list-group list-group-flush ">
                	 <li class="list-group-item">
                       <b>Claim Id: </b> <span>${claimDetails.ac_id}</span>
                    </li>
                    <li class="list-group-item">
                       <b>Account Holder Name: </b> <span>${claimDetails.ac_name} </span>
                    </li>
                    <li class="list-group-item">
                        <b>Bank Name: </b> <span>${claimDetails.bank_nm}</span>
                    </li>
                    <li class="list-group-item">
                        <b>Account Number: </b> <span>${claimDetails.account_no}</span>
                    </li>
                    <li class="list-group-item">
                       <b>IFSC Code: </b> <span>${claimDetails.ifcs_code}</span>
                    </li>
                    
                    <li class="list-group-item">
                       <b>Amount: </b> <span>${claimDetails.amount}</span><br />   
                    </li>
                </ul>
                <div class="panel-footer">
                    <span style="float:right">Amount will be transfered within 7 working days.</span><br/>
                </div>
            </div>
        </div>
	
	
	<h1></h1><br />
		
	
		<%@ include file="Subfiles/footer.jsp" %>
		
		<%@ include file="Subfiles/cssjsfoot.jsp" %>
	
	</body>
</html>
