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
	<script >
		function validateForm() {
		    var password = $("#password").val();
		    var rePassword = $("#repassword").val();
		    $('#errorp').html("")
		   	$('#errorp').html("")
		    if (password == null || password == ""||password.length<6) {
		    	$('#errorp').html("Password must have at least 6 chaarector");
		    	
		       // alert("Password must have at least 6 chaarector");
		        return false;
		    }
		    if (password === rePassword) {
		        return true;
		    }
		    else{
		    	$('#errorrp').html("Password dosen't match");
		    	//alert("Password dosen't match");
		    	return false;
		    }
		    	
		}
	</script>
	
		<div class="page-block">
		  <div class='form aniamted bounceIn'>
		  
		         <div class='login'>
		             <h2>Reset Password</h2>
		            	<%String error =(String) request.getAttribute("error");
			           	if(error!=null){%>
				     <div class='alert'>
			      		<div class='fa fa-times-circle'></div>
				          <font color="red"><%	out.println(error);%></font>
				     </div>
				        <%}
				           	session.removeAttribute("error");
			           	%>
			           	<form action="resetAuth" method="get">
			           		<label >Password</label>
			           		<span id="errorp" style="float:right;color:red"></span>
			           		<input type="password" name="password" id="password" />
			           		<label >Re Enter Password</label>
			           		<span id="errorrp" style="float:right;color:red"></span>
			           		<input type="password" name="repassword" id="repassword"/>
			           	  <input type="submit" id="button" onclick="return validateForm()"/>
			           	</form>
			           	
			           	
			           	<%-- <form:form action="authenticate" commandName="login" method="post">
			           		
					            <label >Email</label>
					            <br/><form:errors path="email" style="float:right;color:red"/> 
					            <form:input path="email" placeholder="Email" label="First Name" />
					            
					            <label style="float:left">Password</label>
					            <br/><form:errors path="password" style="float:right;color:red"/> 
			           			<form:password path="password" placeholder="Password" label="Password"/>
			           		
			           		<input type="submit" id="button"/>
			           	</form:form> --%>
		          
					
		          </div>
		          <footer>
		             Do not have account? <a href='register'><span class="reg">Signup </span></a>|<a href='javascript:void(0);' data-toggle="modal" data-target="#myModal"><span class="reg"> Forgot Password</span></a>
		          </footer>
		   </div>
		 
		 <!-- popup -->
		 	
				  <!-- Modal -->
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
					 alert("forgot"+forgot_email);
					 $.get("forgot", { forgot_email : forgot_email }, function(data) {
			            	
			            	$('#results').html(data);
			            } );
				 }
				 
				 
				 </script>
		 
		 <!-- popup end -->
		 
		</div>
		<%@ include file="Subfiles/footer.jsp" %>
		
		<%@ include file="Subfiles/cssjsfoot.jsp" %>
	
	</body>
</html>
