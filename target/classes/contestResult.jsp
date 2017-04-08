<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="Subfiles/cssjshead.jsp" %> 
   
</head>
	<body>
		<%@ include file="Subfiles/head.jsp" %> 
	
		<div class="page-block">
			
			<%-- <%
				long user_id = Long.parseLong(userids);
			
				UserResult usrres = new UserResult();
				List<ContestResult> reslist = usrres.getUserResult(user_id);
				%> --%>
				
				
				
				<div class="container">
  <h2>Contest Results</h2>
  <p></p>            
  <table class="table table-bordered">
    <thead>
    	
	      <tr>
	        <th>Contest Name</th>
	        <th>Language</th>
	        <th>Result</th>
	        <th>Rank in Contest</th>
	      </tr>
    </thead>
    <%
    int size = (Integer) request.getAttribute("resSize");
	for (int i =0; i < size; i++) {
		request.setAttribute("counter", i);      
	  %>
	  
    <tbody>
	      <tr>
	        <td>${contestResults[counter].contest_name} <a href='groupDetails?groupid=${contestResults[counter].group_id}&contid=${contestResults[counter].contest_id}'><span class="reg">view details </span></a></td>
	        <td>${contestResults[counter].contest_language}</td>
	        <td>${contestResults[counter].result}</td>
	        <td>${contestResults[counter].rank}</td>
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
