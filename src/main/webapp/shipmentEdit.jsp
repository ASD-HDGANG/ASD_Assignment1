<%-- 
    Document   : shipmentEdit
    Created on : 06/06/2020, 6:44:24 PM
    Author     : admin
--%>

<%@page import="entity.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>ShipmentEdit Page</title>
    </head>
    <body onload = "startTime()">
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
            shipment shipment = (shipment) session.getAttribute("shipment");
        %>
        
        
        <h1>Edit Shipment Information</h1>
        <form method="post" action="shipmentUpdateServlet">
        <table>  
            <tr><td>PreferName</td><td><input type="text" name="name" value="${shipment.name}"></td></tr>
            <tr><td>Email</td><td><input type="email" name="email" value="${shipment.email}"></td></tr>
            <tr><td>Phone_number</td><td><input type="text" name="phone" value="${shipment.phone_number}"></td></tr>
            <tr><td>Address</td><td><input type="text" name="address" value="${shipment.address}"></td></tr>
            <tr><td>City</td><td><input type="text" name="city" value="${shipment.city}"></td></tr>
            <tr><td>Territory</td><td><input type="text" name="territory" value="${shipment.territory}"></td></tr>
            <tr><td>Post_code</td><td><input type="text" name="post_code" value="${shipment.post_code}"></td></tr>
            <tr><td>StartDate</td><td><input type="date" name="startDate" value="${shipment.arriveDate}"></td></tr>
            <tr><td>ShipmentMethod</td><td><input type="text" name="shipmentMethod" value="${shipment.shipmentMethod}"></td></tr>
            <tr><td>CurrentStatus</td><td><input type="text" name="currentStatus" value="${shipment.currentStatus}" readonly></td></tr>
            <tr>
            <td>
            <a class ="button" href="shipments.jsp">Back</a></td>
            <td><input class ="button" type="submit" value="Update"></td>
            </tr>
        </table>
       </form>
        </main>
    </body>
</html>
