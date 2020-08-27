<%-- 
    Document   : shipmentEdit
    Created on : 06/06/2020, 6:44:24 PM
    Author     : admin
--%>

<%@page import="ASD.SmartCard.Model.shipment"%>
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
            <a href="StoreServlet" style="float: left;">All Products</a>--%>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>
        </div>
        
        <main class="main-content">
  
        
        
        <h1>Edit Shipment Information</h1>
        <form method="post" action="shipmentUpdateServlet">
        <table>  
            <tr><td>ShipmentID</td><td><input type="text" name="shipmentID"  readonly></td></tr>
            <tr><td>UserID</td><td><input type="text" name="userID"  readonly></td></tr>
            <tr><td>PreferName</td><td><input type="text" name="name" ></td></tr>
            <tr><td>Email</td><td><input type="email" name="email" ></td></tr>
            <tr><td>Phone_number</td><td><input type="text" name="phone" ></td></tr>
            <tr><td>Address</td><td><input type="text" name="address" ></td></tr>
            <tr><td>City</td><td><input type="text" name="city" ></td></tr>
            <tr><td>Territory</td><td><input type="text" name="territory" ></td></tr>
            <tr><td>Post_code</td><td><input type="text" name="post_code" ></td></tr>
            <tr><td>StartDate</td><td><input type="date" name="startDate" ></td></tr>
            <tr><td>ShipmentMethod</td><td><input type="text" name="shipmentMethod" ></td></tr>
            <tr><td>CurrentStatus</td><td><input type="text" name="currentStatus" readonly></td></tr>
            <tr>
            <td>
            <a class ="button" href="shipmentSearchResult.jsp">Back</a></td>
            <td><input class ="button" type="submit" value="Update"></td>
            </tr>
        </table>
       </form>
        </main>
    </body>
</html>
