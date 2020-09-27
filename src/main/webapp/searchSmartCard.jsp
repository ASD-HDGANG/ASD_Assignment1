<%-- 
    Document   : searchOrder
    Created on : Sep 26, 2020, 12:59:31 AM
    Author     : yike8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.SmartCard"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Search Linked Smart Card</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="css/SmartCard.css">
</head>
<body>
       <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
      <%-- if you want to use button, you can use the below styling
        <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
      --%>
        </ul>
        </div>
        <div class="topnav">
        <%--left    button
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>--%>
            <a href="home.jsp" style="float: left;"> Home </a>

        </div>
    <h1>Search by User ID</h1>
<table border="0">
    <form role="form" action="SmartCardListServlet" method="get">
     <tr>
         <td><input type="text" name="userId"  maxlength="16" required></td>
         <td><input class="button" type ="submit" value="Search"></td>
    </tr>
    </form> 
</table> 
</body>
</html>