<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
           

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="Subfiles/cssjshead.jsp" %> 
<%@ include file="Subfiles/head.jsp" %>   

</head>

<body>


<div class="page-block">


 
 <div class="col-md-2" id="leftCol" style="float:left; margin-top:5px">
              	
				<div class="well"> 
					<center>
					<span>Results</span>
					</center>
	              	<ul class="nav nav-stacked" id="sidebar">
	                  <li><a href="contestResult">Contest</a></li>
	                  <li><a href="#sec2">Skill Contest</a></li>
	              	</ul>
  				</div>
 </div>
 
<div style="padding-right:0px;padding-left:0%; float:left">

<table class="table" >

			    <thead>
			      <tr>
			        <th><span class="user-name"><b>${name }</b></span>
				        <a href="editProfile"><span class="edit-info">Edit Profile</span></a> 
				        <span style="margin-left: 50px">
				        	Wallet Amount:  &#x20b9; <span id="subfild">${wallet}</span>
				        	<a href="claim"><span class="edit-info">claim for pay</span></a> </span>
			        </th>
			      </tr>
			    </thead>
				    <tbody>
				      <tr>
				        <td>Email: <span id="subfild">${emailId}</span></td>
				        <td><span style="float:right;margin-right:200px"> Phone no:<span id="subfild">${phoneno}</span></span></td>
				       
				      </tr>
				      <tr>
				        <td>Date Of Birth: <span id="subfild">${dob}</span></td>
				        <td><span style="float:right;margin-right:200px">Current City: <span id="subfild" >${city}</span></span></td>
				      </tr>
				      <tr>
				        <td>State: <span id="subfild">${state}</span></td>
				       <td><span style="float:right;margin-right:200px">Country: <span id="subfild">${country}</span></span></td>
				      </tr>
				      <tr>
				        <td>Pin Code: <span id="subfild">${pincode}</span></td>
				        <td><span style="float:right;margin-right:200px">Skills: <span id="subfild">${skills}</span></span></td>
				      </tr>
				    </tbody>
			 </table>
 
<script>
  function hii(obj) {
    // Check URL using setTimeout as it may not change before
    // listener is called
   alert("hello"+obj);
  }
  
  </script>

<!-- Education -->
<table class="table">
<thead>
			      <tr>
			        <th><span class="user-name"><b>Education</b></span>
				        <a href="addEducation"><span class="edit-info">Add Education</span></a> 
			        </th>
			      </tr>
			    </thead>
			 </table>
			 
			 <%
       	int size2 = (Integer) request.getAttribute("eduSize");
       	
       	for (int i =0; i < size2; i++) {
			request.setAttribute("counter", i);       
     %>
<table class="table">
			    <thead>
			      <tr>
			        <th><span >${education[counter].institute_name}</span>
				        <a href="editEducation?edu_id=${education[counter].edu_id}"><span class="edit-info">Edit</span></a>
				          <%-- <a href="deleteEducation?edu_id=${education[counter].edu_id}"><span class="edit-info">Delete</span></a> --%>
				         <%-- <a href="#deleteEducation" onclick="hii(${education[counter].edu_id})"><span class="edit-info" >Delete</span></a> --%>  
			        </th>
			      </tr>
			    </thead>
				    <tbody>
				      <tr>
				        <td>Degree: <span id="subfild">${education[counter].degree}</span></td>
				        <td><span style="float:right;margin-right:200px">Field: <span id="subfild">${education[counter].field}</span></span></td>
				      </tr>
				      <tr>
				        <td>Pass out Year: <span id="subfild">${education[counter].passout_year}</span></td>
				        <td><span style="float:right;margin-right:200px">Percentage: <span id="subfild">${education[counter].percentage}</span></span></td>
				      </tr>
				     
				    </tbody>
			 </table>
			 <%} %>
			 
			<!-- Profile --> 
			
			
			<table class="table">
<thead>
			      <tr>
			        <th><span class="user-name"><b>Professional Information</b></span>
				        <a href="addProfession"><span class="edit-info">Add Profession</span></a> 
			        </th>
			      </tr>
			    </thead>
			 </table>
			 <%
       	int size = (Integer) request.getAttribute("profSize");
       	
       	for (int j =0; j < size; j++) {
			request.setAttribute("counter2", j);       
     %>
<table class="table">
			    <thead>
			      <tr>
			        <th><span >${profession[counter2].companyName}</span>
				        <a href="editProfession?prof_id=${profession[counter2].prof_id}"><span class="edit-info">Edit</span></a>
				       
			        </th>
			      </tr>
			    </thead>
				    <tbody>
				      <tr>
				        <td>Company Name: <span id="subfild">${profession[counter2].companyName}</span></td>
				        <td><span style="float:right;margin-right:200px">Job Profile: <span id="subfild">${profession[counter2].profile}</span></span></td>
				      </tr>
				      <tr>
				        <td>Currently Working: <span id="subfild">${profession[counter2].currently_working}</span></td>
				        <td><span style="float:right;margin-right:200px">Experience: <span id="subfild">${profession[counter2].experience}</span></span></td>
				      </tr>
				      <tr>
				        <td>Description: <span id="subfild">${profession[counter2].description}</span></td>
				       
				      </tr>
				     
				    </tbody>
			 </table>
			 <%} %>
			 
			 </div>
 
</div>


<%@ include file="Subfiles/footer.jsp" %>

<%@ include file="Subfiles/cssjsfoot.jsp" %>

</body>
</html>
