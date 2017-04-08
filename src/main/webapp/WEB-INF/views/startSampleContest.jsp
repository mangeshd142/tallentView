<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<script type="text/JavaScript">
//courtesy of BoogieJack.com
function killCopy(e){
return false
}
function reEnable(){
return true
}
document.onselectstart=new Function ("return false")
if (window.sidebar){
document.onmousedown=killCopy
document.onclick=reEnable
} 
</script>

<script>
		var count=0;
		var count2=123;
		
		window.onbeforeunload = function (event) {
       		count2++;
		    var message = 'Important: Please click on \'Save\' button to leave this page.';
		    if (typeof event == 'undefined') {
		        event = window.event;
		    }
		    if (event) {
		        event.returnValue = message;
		        
		    }
		    return message;
		};
		
		$(function () {
			
		    $("a").not('#lnkLogOut').click(function () {
		    	
		        window.onbeforeunload = null;
		    });
		    $(".btn").click(function () {
		    	
		        window.onbeforeunload = null;
		});
		});
		
		
       	 </script>





<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3d5c5c;
  width: 60px;
  height: 60px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}
.loader2 {
margin-top : 20%;
margin-bottom : 15%;
  margin-left : 45%;
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
<script> 

var timeout = ${timeLimit}; 
function timer() 
{ 
if( --timeout > 0 ) 
{ 
//document.forma.clock.value = timeout; 

var seconds = timeout % 60;
var minutes = Math.floor(timeout / 60);
var hours = Math.floor(minutes / 60);
minutes %= 60;
hours %= 60;
document.getElementById("timer").innerHTML = hours + ": " + minutes + ": " + seconds + "";
window.setTimeout( "timer()", 1000 ); 
} 
else 
{ 
//document.forma.clock.value = "Time over"; 
alert("Submit Result.");
	var codeArea = $("#codearea").val();
    var progid = "<%out.print(request.getParameter("progid"));%>";
    var contestid = "<%out.print(request.getParameter("contestid"));%>";
    var userId = ${userId};
    
    	$('#results2').html("");
        $('.loader2').show();
    	
        $.post("saveSampleRes", { codeArea : codeArea, progid:progid, contestid:contestid,userId:userId }, function(data) {
        	$('.loader2').hide();
        	$('#results2').html(data);
        } );
    
///disable submit-button etc 
} 
} 
//--> 
</script> 





<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="Subfiles/cssjshead.jsp" %> 
<%@include file="Subfiles/codearealib.jsp" %> 
<%@ include file="Subfiles/head.jsp" %>   
<%userids="";if(userids==null) {response.sendRedirect("erroronlogin.jsp");}
          else{
          %> 
</head>

<body>

<div id="deals">
<div class="page-header">
<div class="loader2" hidden="true" ></div>
<div id="results2">

 		<script>
			/* window.onbeforeunload = function (event) {
			    var message = 'Important: Please click on \'Save\' button to leave this page.';
			    if (typeof event == 'undefined') {
			        event = window.event;
			    }
			    if (event) {
			        event.returnValue = message;
			        $('#samp').html("Hello");
			    }
			    
			    return message;
			};
			
			$(function () {
			    $("a").not('#lnkLogOut').click(function () {
			    	
			        window.onbeforeunload = null;
			    });
			    $(".btn").click(function () {
			    	
			        window.onbeforeunload = null;
			});
			    
			    
			    
			}); */
			
		</script>
<div id="samp"></div>
 		
<span style="float:right;margin-right:150px"><span style="font-weight: bold">Remaining Time: </span> <span id="timer"></span> </span>
		     <!-- <h3>Program Description:</h3> -->
		     
		  
		    <%--  <%@include file="conntest/sapmleContest/addition.jsp" %>  --%>
		    	<jsp:include page="conntest/sapmleContest/${detail}"></jsp:include>
		     <div ><%//out.print(disc);%> </div><br>
		     
		     Write Your Program:<br>
		    <div>
		    <form:form commandName="codeArea">
		    <div id="formtext">
		    <form:textarea path="codeArea" cols="115" rows="10" id="codearea"/>
			     </div>
			    <input type="hidden" name="progid" value="<%out.print(request.getParameter("progid"));%>"/>
			    <input type="hidden" name="contestid" value="<%out.print(request.getParameter("contestid"));%>"/>
			    <input type="hidden" name="userId" value="${userId}"/>
			     <input type="submit" value="Compile and Run" class="btn btn-primary"/>
			      <input type="button" value="Submit Result" class="btn btn-primary" onclick="subRes()"/>
		     </form:form>
		     
		     
		    
		     </div>
<script>
  var codearea = CodeMirror.fromTextArea(document.getElementById("codearea"), {
    lineNumbers: true,
    matchBrackets: true,
    mode: "text/x-java"
  });
</script>

		<script>
		    // When the form is submitted run this JS code
		    $('form').submit(function(e) {
		        // Post the form data to page.php
		        $('#results').html("");
		        $('.loader').show();
		        
		        $.post('getsampleresult', $(this).serialize(), function(resp) {
		            // Set the response data into the #div2
		            $('.loader').hide();
		            $('#results').html(resp);
		        });
		
		        // Cancel the actual form post so the page doesn't refresh
		        e.preventDefault();
		        return false;
		    });
		</script>
		
		<%-- <script >
 		var count=0;
 		
 		function submit(){
			
			if(count==0){
				
				var codeArea = $("#codearea").val();
	            var progid = "<%out.print(request.getParameter("progid"));%>";
	            var contestid = "<%out.print(request.getParameter("contestid"));%>";
	            var userId = ${userId};
	            
				$('#results2').html("");
			    $('.loader2').show();
				
			    $.post("saveSampleRes", { codeArea : codeArea, progid:progid, contestid:contestid,userId:userId }, function(data) {
			    	$('.loader2').hide();
			    	$('#results2').html(data);
			    } );
			count++;
			}else{
				
			}
		}
 		
			window.addEventListener( 'blur', function() { 
				submit();
				console.log( 'blur' ); } );
			
			
	</script> --%>
		
		
		 <script>
		//var count=0;
		
		
		
		
       	 function subRes(){
       		if(count==0&&count2==123){
		            var codeArea = $("#codearea").val();
		            var progid = "<%out.print(request.getParameter("progid"));%>";
		            var contestid = "<%out.print(request.getParameter("contestid"));%>";
		            var userId = ${userId};
		            
		            	$('#results2').html("");
				        $('.loader2').show();
		            	
			            $.post("saveSampleRes", { codeArea : codeArea, progid:progid, contestid:contestid,userId:userId }, function(data) {
			            	$('.loader2').hide();
			            	$('#results2').html(data);
			            } );
			      count++;
       		}
		            
		  }
       	 
       	
       	 
       	window.addEventListener( 'blur', function() { 
       		
       		subRes();
       		count2=123;
       		
			console.log( 'blur' ); } );
		
        </script> 
        
        

			<div class="loader" hidden="true" ></div>
		     <div id="results"></div>
		     <!-- <textarea id="results2"></textarea> -->
		     
 				<div id="resul" ></div><br> 
</div>
</div>



 <!-- <div>
 
 	<table class="table table-bordered">
    <thead>
    	
	      <tr>
	        <th>Input</th>
	        <th>Your Output</th>
	        <th>Expected Output</th>
	        
	      </tr>
    </thead>
   
    <tbody>
	      <tr>
	        <td>Time Taken </td>
	        <td>Test Cases </td>
	        <td>Result </td>
	        
	      </tr>
	   
    </tbody>
    
    
    <table class="table table-bordered">
    <thead>
    	
	      <tr>
	        <th>Input</th>
	        <th>Your Output</th>
	        <th>Expected Output</th>
	        
	      </tr>
    </thead>
   
    <tbody>
	      <tr>
	        <td>Time Taken </td>
	        <td>Test Cases </td>
	        <td>Result </td>
	        
	      </tr>
	   
    </tbody>
    
  </table>
 

 
 </div> -->

</div>
<%@ include file="Subfiles/footer.jsp"%>
<%} %>

<%@ include file="Subfiles/cssjsfoot.jsp"%>
 <script> 
timer(); 
</script> 
</body>
</html>
