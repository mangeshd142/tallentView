<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- <%@page import="com.talent.contestmodel.ContestInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.talent.contestmodel.DAO.ContestInfoDAO"%>
<%@page import="com.talent.usermodel.controler.GetInfo"%> --%>
<%@taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<script src="<ss:url value="/resources/js/jquery.countdown.js"/>"></script> 
<link rel="stylesheet" href="<ss:url value="/resources/css/w3.css"/>"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="<ss:url value="/resources/js/im-embed.min.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<style>
body {
	margin: 0px;
	padding: 0px;
}

#topLoader {
	width: 256px;
	height: 256px;
}

.score-pane {
	float: right;
}

#container {
	width: 70px;
	padding: 0px;
	margin-left: 0px;
	margin-right: 0px;
}
</style>
<%@include file="Subfiles/cssjshead.jsp" %> 

<%@ include file="Subfiles/head.jsp" %>    
</head>

<body>


<div class="w3-card-4" style="width: 70%;margin-top:150px;margin-bottom:70px">

	<header class="w3-container w3-grey" >
		<h1>Contest Name: ${contestInfo.name}</h1>
	</header>

	<div class="w3-container" >
		
		<div class="view-result" style="margin-top: 20px">
		<h4 class="contest-name">
				<span style="text-decoration: none; border-bottom: 1px solid; margin-right: 200px">
				Contest Fees: &#x20b9; ${contestInfo.entry_fee}</span>
			</h4>
			<p>
				<span style="font-weight: bold;">1. </span> 
				This contest is in ${contestInfo.language} language.
			</p>
			<p>
				<span style="font-weight: bold;">2. </span> 
				In every group there are random ${contestInfo.participant} participants.
			</p>
			<p>
				<span style="font-weight: bold;">3. </span> 
				You have to complete this contest within ${timeLimit} hrs.
			</p>
			<p>
				<span style="font-weight: bold;">4. </span>
				To win this contest, you have to get minimum of 50% marks and top in group.
			</p>
			<p>
				<span style="font-weight: bold;">5. </span>
				The winner of contest will be given &#x20b9; ${contestInfo.prise} of winning amount.
			</p>
			<p>
				<span style="font-weight: bold;">6. </span>
				The result will be declare after Group Contest Complete.
			</p>
			
			<p>
				<span style="font-weight: bold;">7. </span>
				For practice you can solve problems on <a href="selectSampleContest">skill contest</a>.
			</p>
			
			<h4 class="contest-name">
				<span style="text-decoration: none; border-bottom: 1px solid; margin-right: 200px">
				Instructions: </span>
			</h4>
			
			<p>
				<span style="font-weight: bold;">1. </span>
				<span style="color: red;">* Don't try to move from the contest tab,
				if you move from tab then your result will automatically submitted as per your current program.
				</span>
			</p>
			
			<p>
				<span style="font-weight: bold; ">2. </span>
				If you close contest tab your result will not be submitted.
			</p>
			
			<p>
				<span style="font-weight: bold; ">3. </span>
				Check your Internet connection is working properly before starting contest.
			</p>
		</div>
		
<br/>
			<a href="https://test.instamojo.com/@mangeshd142/${order_id}" rel="im-checkout" data-behaviour="remote" data-style="light" data-text="Pay and Proceed to Contest" ></a>
		<%-- <a href="https://www.instamojo.com/@tallentview/${order_id}" rel="im-checkout" data-behaviour="remote" data-style="light" data-text="Pay and Proceed to Contest" ></a> --%>

	</div>
	<footer class="w3-container w3-grey">
		<h5>Tallent View</h5>
	</footer>
</div>

<%@ include file="Subfiles/footer.jsp" %>

<%@ include file="Subfiles/cssjsfoot.jsp"%>


</body>
</html>
