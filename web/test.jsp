<%-- 
    Document   : test
    Created on : Sep 25, 2020, 2:48:14 AM
    Author     : yike8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Order</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" href="css/SmartCard.css">
    </head>
   <body onload ="startTime()">
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
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>
        <h1>New Order</h1>
        <form method = "post" action="AddOrderServlet">   
            <label for="name">Card Number</label><input type="text" id="smartCardNumber" name="smartCardNumber"  maxlength="16" size="16" placeholder="16-digits card number" required>
            <label for="name">Start From</label><input type="text" id="fromLocation" name="fromLocation" placeholder="e.g. Central" required> 
            <label for="name">Destination</label><input type="text" id="toLocation" name="toLocation" placeholder="e.g. Broadway" required> 
            <label for="name">Type</label><input type="radio" name="orderType" value="orderType1">Bus     <input type="radio" name="orderType" value="orderType2">Train     <input type="radio" name="orderType" value="orderType3">Ship
            <label for="name">Date</label><input type="date" id="orderDate" name="orderDate" required>      
            <input class="button" type ="submit" value="submit">
         </form>
      </main>
    </body>
</html>