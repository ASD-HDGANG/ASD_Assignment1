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
	<title>New Smart Card</title>
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
    <h1>Create New Smart Card</h1>
<div align="center">
    <form role="form" action="AddSmartCardServlet" method="post">
            <h3 align="center">Please choose the type of card</h3>
            <input type="radio" name="smartCardType" value="adult" required/><img class="logo" src="css/adult.jpg"/>
            <input type="radio" name="smartCardType" value="child" ><img class="logo" src="css/child.jpg"/>
            <input type="radio" name="smartCardType" value="senior" ><img class="logo" src="css/senior.jpg"/><br>
            <a class="button"  href="smartCardManagement.jsp"> Cancel </a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" type ="submit" value="Create"> 
    </form>         
</div> 
  
</body>
</html>
