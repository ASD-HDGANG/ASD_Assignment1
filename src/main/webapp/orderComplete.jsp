<%-- 
    Document   : searchOrder
    Created on : Sep 26, 2020, 12:59:31 AM
    Author     : yike8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Order"%>

 <%String orderId = session.getAttribute("orderId").toString();%>
 <%String fromLocation = session.getAttribute("fromLocation").toString();%>
 <%String smartCardNumber = session.getAttribute("smartCardNumber").toString();%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Complete Order</title>
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
    <h1>Complete Order</h1>
    <h2 align="center">Please select the destination and enter your security code</h2>
<table border="0">
    <form role="form" action="OrderCompleteServlet" method="post">
     <tr>
         <td><h4 style="color:blue">Destination</h4></td>
             <td><input type="text" name="toLocation" list="toLocationList" required> 
            <datalist id="toLocationList">
                <option value="Central">
                <option value="Broadway">
                <option value="Newtown">
            </datalist></td>
            </tr>
            <tr>
            <td><h4 style="color:blue">Security code</h4></td> 
         <input type="hidden" name="orderId" value="<%=orderId%>"/>
         <input type="hidden" name="fromLocation" value="<%=fromLocation%>"/>
         <input type="hidden" name="smartCardNumber" value="<%=smartCardNumber%>"/>
         <td><input type="text" name="securityCode"  maxlength="4" placeholder="4-digits security code" required></td>
    </tr>
      <tr>
          <td><a class="button"  href="orderList.jsp"> Cancel </a></td>
         <td><input class="button" type ="submit" value="Confirm"></td>
    </tr>
    </form> 
</table> 
</body>
</html>