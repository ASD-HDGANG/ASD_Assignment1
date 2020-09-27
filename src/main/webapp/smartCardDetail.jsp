<%-- 
    Document   : new Smart Card
    Created on : Sep 24, 2020, 11:28:22 PM
    Author     : yike8
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Smart Card Detail</title>
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
    <h1>Successfully Created!!</h1>
<div align="center">
            <h3 align="center">Smart Cart Information</h3>
            <table>
                <tr>
                    <td>Smart Card Number: </td>
                    <td>${requestScope.smartCardNumber}</td>
                </tr>
                <tr>
                    <td>Security Code: </td>
                    <td>${requestScope.securityCode}</td>
                </tr>
                <tr>
                    <td>Card Type: </td>
                    <td>${requestScope.smartCardType}</td>
                </tr>
            </table>
            
            <a class="button"  href="smartCardManagement.jsp"> Go back </a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="button"  href="smartCardList.jsp"> Link with current account</a>
</div> 
  
</body>
</html>
