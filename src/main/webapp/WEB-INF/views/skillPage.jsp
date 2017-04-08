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
	
	<!-- <div class="col-md-4 col-md-offset-1">
							<div class="home-design-info "> -->
							<%-- <div style="margin-left: 200px">
								<figure >
									<img alt="Post your need" style="width: 80%; height: 30%"
										src="<ss:url value="/resources/img/underConstruction.jpg"/>">
								</figure>
							</div> --%>
							<div class="row">
								<img style="width: 80%; height: 30%" src="<ss:url value="/resources/img/underConstruction.jpg"/>" class="img-responsive"/>
							 </div>
							<!-- </div>
						</div> -->
	
		<%@ include file="Subfiles/footer.jsp" %>
		
		<%@ include file="Subfiles/cssjsfoot.jsp" %>
	
	</body>
</html>
