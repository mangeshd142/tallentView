<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- <%@page import="com.talent.contestmodel.ContestInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.talent.contestmodel.DAO.ContestInfoDAO"%>
<%@page import="com.talent.usermodel.controler.GetInfo"%> --%>
<%@taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<ss:url value="/resources/js/jquery.countdown.js"/>"></script> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style>
html, body {
    max-width: 100%;
    overflow-x: hidden;
}
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3d5c5c;
  width: 60px;
  height: 60px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
<%@include file="Subfiles/cssjshead.jsp" %> 
<!-- <script>
function getContestDetail(){
	
	   $("#contest").html("");
	   $('.loader').show();
	   
	   var value="Java";
	   
	   $.post("getContestDetail",{language:value},function(data){
		   $('.loader').hide();
		   $("#contest").html(data);
		   });
};
</script> -->

 <script> 
 getContestDetail(); 
</script> 

<script>

function getContest(obj){
	$("#contest").html("");
	   $('.loader').show();
	   
	   
	   $.post("getContestDetail",{language:obj},function(data){
		   $('.loader').hide();
		   $("#contest").html(data);
		   });
}
</script>

<script>
var months = ['Jan', 'Feb', 'Mar', 'Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
		        $(document).ready(function(){
				$("#language").change(function(){
				   var value = $(this).val();
				   $("#contest").html("");
				   $('.loader').show();
				   
				   
				   $.post("getContestDetail",{language:value},function(data){
					   $('.loader').hide();
					   $("#contest").html(data);
					   });
					});
				});
        </script>

<%@ include file="Subfiles/head.jsp" %>    

</head>

<body>

 <!-- <label> Select Language</label><select class="form-control" style="width:300px" id="language">
            		<option >select Language</option>
                	<option >c</option>
                    <option >c++</option>
                    <option >Java</option>
                </select> -->
              <div>
              <div class="col-md-2 pull-left">
		              	
						<div class="well"> 
							
							<span>Contest Languages</span>
							
			              	<ul class="nav nav-stacked" id="sidebar">
			              	  <li><a href="javascript:void(0);" onclick="getContest('all')">All</a></li>
			                  <li><a href="javascript:void(0);" onclick="getContest('Java')">Java</a></li>
			                  <li><a href="javascript:void(0);" onclick="getContest('c#')">C#</a></li>
			                  <li><a href="javascript:void(0);" onclick="getContest('c')">C</a></li>
			                  <li><a href="javascript:void(0);" onclick="getContest('c++')">C++</a></li>
			              	</ul>
		  				</div>
 				 </div>
                
                <div class="loader" hidden="true" style="margin-top:160px; padding-right:02px;padding-left:02%; float:right; margin-right:530px; margin-bottom:630px" ></div>
               
  <div id="contest" class="pull-left">
                 <%
			       	int size2 = (Integer) request.getAttribute("contestSize");
			       	
			       	for (int i =0; i < size2; i++) {
						request.setAttribute("counter", i);       
			     %>
        		
		 <div class="col-md-10">
			 <a href="proceedContest?progid=${contestInfo[counter].prog_id}&contestid=${contestInfo[counter].contest_id}" style="color: black;">
            <div class="panel panel-default">
                <div class="panel-heading">
                     <h4>Contest Name: ${contestInfo[counter].name}</h4>
                </div>
                <ul class="list-group list-group-flush ">
                	 <li class="list-group-item">
                      <span> <b>Language: </b> ${contestInfo[counter].language} </span>
                      <span class="pull-right"> <b>Group: </b>${contestInfo[counter].participant} members</span>
                    </li>
                    <li class="list-group-item">
                       <span> <b>Price: </b>&#x20b9; ${contestInfo[counter].prise} </span>
                      <span class="pull-right"> <b>Entry fees: </b>&#x20b9; ${contestInfo[counter].entry_fee}</span>
                    </li>
                    <li class="list-group-item">
                       <span> <b>Start Date </b> </span>
                      <span class="pull-right"> <b>End Date </b></span><br/>
                      <span> 
                      <script>
						 var date = new Date('${contestInfo[counter].start_date}');
						 
						 var start_date = months[(date.getMonth())] + '-' + date.getDate() + '-' +  date.getFullYear();
						 document.write(start_date);
						</script>
                      
                      <%-- ${contestInfo[counter].start_date} --%>  </span>
                      <span class="pull-right">
                       <script>
						 var date2 = new Date('${contestInfo[counter].end_date}');
						 
						 var end_date = months[(date2.getMonth())] + '-' + date2.getDate() + '-' +  date2.getFullYear();
						 document.write(end_date);
						</script> </span>
                    </li>
                    
                </ul>
                
            </div>
            </a>
        </div>
        
		
        <%} 
        request.removeAttribute("contestSize");
        request.removeAttribute("counter");
        %> 
    </div>
        
  </div>    
                

 

<div style="margin-top: 580px">
<%@ include file="Subfiles/footer.jsp" %>
</div>

<%@ include file="Subfiles/cssjsfoot.jsp"%>









</body>
</html>
