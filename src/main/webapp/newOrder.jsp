<%-- 
    Document   : newOrder
    Created on : Sep 24, 2020, 11:28:22 PM
    Author     : yike8
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>New Order</title>
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
            <a href="tripPlanner.jsp" style="float: left;"> Trip_Planner </a>
            <a href="orderManagement.jsp" style="float: left;">Order </a>
            <a href="smartCardManagement.jsp" style="float: left;">Card </a>
            <a href="bill.jsp" style="float: left;">Bill </a>
            <a href="shipmentNew.jsp" style="float: left;">Shipment </a>
            <a href="reporting.jsp" style="float: right;">Report </a>
            <a href="userProfile.jsp" style="float: right;">Profile</a>
            <a href="AllAdminServlet" style="float: right;">Admin</a>

        </div>
    <h1>New Order</h1>
<div>
    <form role="form" action="AddOrderServlet" method="post">
            <label for="name">Smart Card Number</label><input type="text" name="smartCardNumber"  maxlength="16" placeholder="16-digits card number" required>
            <label for="name">Start From</label><input type="text" name="fromLocation" list="fromLocationList" required> 
            <datalist id="fromLocationList">
                <option value="Central">
                <option value="Broadway">
                <option value="Newtown">
            </datalist>
            <div align="center"><label for="name">Type</label><input type="radio" name="orderType" value="Bus" required>Bus
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="orderType" value="Train" >Train
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="orderType" value="Ship" >Ship</div>
            <br/><div align="center"><a class="button"  href="orderManagement.jsp"> Cancel </a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="button" type ="submit" value="Create"></div> 
    </form>         
</div> 
</body>
</html>
