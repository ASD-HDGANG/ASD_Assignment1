<%-- 
    Document   : main
    Created on : 2020-4-30, 2:12:07
    Author     : AAKK
--%>

<%@page import="ASD.SmartCard.Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <title>Main Page</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
 <div class="dropdown">
	<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" 
			data-toggle="dropdown">
		Features
		<span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
		<li role="presentation">
			<a role="menuitem" tabindex="-1" href="#"></a>
		</li>
		<li role="presentation">
			<a role="menuitem" tabindex="-1" href="tripPlanner.jsp">Trip Planner</a>
		</li>
		<li role="presentation">
			<a role="menuitem" tabindex="-1" href="reporting.jsp">Reporting</a>
		</li>
		<li role="presentation" class="divider"></li>
		<li role="presentation">
			<a role="menuitem" tabindex="-1" href="#">Other stuff</a>
		</li>
	</ul>
</div>
    
    <body>
        <h2>User Profile</h2>
        
        <p class="right">
        <a class="button"  href="logout.jsp"> Logout</a>
        </p>
        
        <div>
            <jsp:include page="profile.jsp" flush="true" />
        </div>
        
        
 
        
     
  
    </body>
</html>
