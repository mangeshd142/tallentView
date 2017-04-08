
<%@taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script
	src="<ss:url value="/resources/js/jquery.percentageloader-0.1.js"/>"></script>
<link rel="stylesheet" href="<ss:url value="/resources/css/w3.css"/>">

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


<div class="w3-card-4" style="width: 70%;margin-top:150px;margin-bottom:70px">

	<header class="w3-container w3-grey">
		<h1>${userName}</h1>
	</header>

	<div class="w3-container" >
		<div class="score-pane">
			<div id="topLoader"></div>
			<p style="margin-top: 0px; margin-right: 103px; float: right;">
				<span style="font-weight: bold;">Score :</span> ${score}
			</p>
		</div>
		<h1 class="contest-name"
			style="text-decoration: none; border-bottom: 1px solid; margin-right: 300px">Contest
			Name: ${contestName}</h1>
		<div class="view-result" style="margin-top: 80px">
			<p>
				<span style="font-weight: bold;">Score :</span> ${score}
			</p>
			<p>
				<span style="font-weight: bold;">Test Cases :</span> ${result}
			</p>
			<p>
				<span style="font-weight: bold;">Time Complete Program:</span>
				${conetstTime} hrs
			</p>
			<p>
				<span style="font-weight: bold;">Time to run Program :</span>
				${runTime} sec
			</p>
		</div>

	</div>
	<footer class="w3-container w3-grey">
		<h5>Tallent View</h5>
	</footer>
</div>

<script>
       var progress = ${scorePoint};
        $(function() {
          var $topLoader = $("#topLoader").percentageLoader({width: 200, height: 256, controllable : false, progress : progress, onProgressUpdate : function(val) {
              $topLoader.setValue(Math.round(val * 100.0));
            }});
        });      
      </script>





<%-- Res: ${result}
Id: ${id}
Score : ${score}
contestName : ${contestName}
runTime : ${runTime} --%>