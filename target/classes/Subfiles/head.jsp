<%@page import="com.tallentview.tallentview.user.model.User"%>
<%String userids = (String) session.getAttribute("userid");
           %>
<div class="header">
<nav class="navbar1 navbar-default">
  <div class="container-fluid">
   
  
    <div class="navbar-header">
      <a class="navbar-brand" style="padding: 8px 0px;" href="/"><img alt="Brand" src="<ss:url value="/resources/img/logo4.png" />" ></a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
    <%try{
		User userses = (User)session.getAttribute("userSession");
if(userses==null) {%>
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     <%}
       		else{   
       		%>
       	
       	
       	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=userses.getFname()+" "+userses.getLname() %><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="profile"><i class="fa fa-th"></i>   Profile</a></li>
            <li><a href="logout"><i class="fa fa-power-off"></i>   Log Out</a></li>
          </ul>
        </li>
       	<% }
    }catch(NullPointerException e){%>
    	<li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    <%}%>
    </ul>
  </div>
  
  
    <nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" id="sidebar-toggle" class=" navbar-toggle pull-left" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li ><a href="/">Home</a></li>
      <li><a href="selectSampleContest">Skill Contest</a></li> 
      <li><a href="selectContest">Contest</a></li>
      <li><a href="selectOpenContest">Open Contest</a></li>
      <li><a href="skillPages">Skill Pages</a></li> 
      <li><a href="hiringContest">Hiring Contest</a></li> 
    </ul>
    
  </div>
</nav>
</nav>
</div>