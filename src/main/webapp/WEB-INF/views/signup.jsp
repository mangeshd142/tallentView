<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="Subfiles/cssjshead.jsp" %> 
<%@ include file="Subfiles/head.jsp" %>    
</head>

<body>


<div class="page-header">
  <div class='form aniamted bounceIn'>
  
 
  <div class='register'>
    <h2>Join With Us</h2>
    	<%String error =(String) session.getAttribute("error");
	           	if(error!=null){%>
	         <div class='alert'>
      			<div class='fa fa-times-circle'></div>
	          <font color="red"><%	out.println(error);%></font>
	         </div>
	           	<%}
	         	  	session.removeAttribute("error");
           		 %>
            <s:if test="hasActionErrors()">
			   <div class="errors">
			      <s:actionerror/>
			   </div>
			</s:if>
            
    <form:form action="signup" commandName="signup" method="post">
    
			<label>First Name</label>
			<form:errors path="fname" style="float:right;color:red"/> 
			<form:input path="fname" placeholder="First Name" label="First Name" />
			<label>Last Name</label>
			<form:errors path="lname" style="float:right;color:red"/> 
			<form:input path="lname" placeholder="Last Name" label="First Name" />
			<label>Gender </label><br />
			<form:errors path="gender" style="float:right;color:red"/> 
			<form:radiobutton path="gender" value="male" label="M" /> 
            <form:radiobutton path="gender" value="female" label="F" /><br />
            <label>Email</label>
            <form:errors path="email" style="float:right;color:red"/> 
            <form:input path="email" placeholder="Email" label="First Name" />
            <label>Password</label>
            <form:errors path="password" style="float:right;color:red"/> 
            <form:password path="password" placeholder="Password" label="Password"/>
			
			<input type="submit" value="Signup" id="button"/>
			
		
	</form:form>
  </div>
  <footer>
    Already a member with us? <a href='login'><span class="reg">Login</span></a> |<a href='javascript:void(0);' data-toggle="modal" data-target="#myModal"><span class="reg"> Forgot Password</span></a>
  </footer>
</div>

 <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title">Forgot Password</h4>
				        </div>
				        <div class="modal-body">
				          <p>Enter Email Id:</p>
				        	<div id="results"></div>
					         <input type="email" name="email" id="forgot_email" placeholder="Email"/>   			           		
			           		 <button type="button" class="btn btn-default" onclick="forgot()">Submit</button>
			       
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  
				  <script>
				 function forgot(){
					 var forgot_email = $("#forgot_email").val();
					 //alert("forgot"+forgot_email);
					 $.get("forgot", { forgot_email : forgot_email }, function(data) {
			            	
			            	$('#results').html(data);
			            } );
				 }
				 
				 
				 </script>
 
</div>

<%@ include file="Subfiles/cssjsfoot.jsp" %>
<%@ include file="Subfiles/footer.jsp" %>


</body>
</html>
