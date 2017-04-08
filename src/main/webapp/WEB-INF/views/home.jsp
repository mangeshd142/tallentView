
<%@ page session="false" %>
<html>
<head>

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


from jsp tag:<%=request.getParameter("serverTime") %>
</body>
</html>
