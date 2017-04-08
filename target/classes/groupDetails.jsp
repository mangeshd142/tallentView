<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="Subfiles/cssjshead.jsp" %> 
   
</head>
	<body>
		<%@ include file="Subfiles/head.jsp" %> 
	
		<div class="page-block">
			
						
				<div class="container">
  <h2>Your Group Result For This Contest</h2>
  <p class="pull-right" style="color: #4d88ff">${winningMessage}</p>            
  <table class="table table-bordered">
    <thead>
    	
	      <tr>
	        <th>User Name</th>
	        <th>result</th>
	        <th>Time to Complete Program(hrs)</th>
	        <th>Time Required to run program(ms)</th>
	        <th>Rank in Contest</th>
	      </tr>
    </thead>
    <%
    int size = (Integer) request.getAttribute("groupSize");
	for (int i =0; i < size; i++) {
		request.setAttribute("counter", i);      
	  %>
	  
    <tbody>
	      <tr>
	        <td>${groupResults[counter].user_name}</td>
	        <td>${groupResults[counter].result}</td>
	        <td>${groupResults[counter].required_time}</td>
	        <td>${groupResults[counter].complition_time}</td>
	        <td><%=i+1 %></td>
	      </tr>
	   <%} %>
    </tbody>
  </table>
</div>
				
			 
		</div>
		
		<%@ include file="Subfiles/footer.jsp" %>
	
	<%@ include file="Subfiles/cssjsfoot.jsp"%>
	
	</body>
</html>
