<%-- 
    Document   : shipmentNew
    Created on : 08/06/2020, 10:24:58 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>New Shipment</title>
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
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>
        <h1>New Shipment</h1>
        <form method = "post" action="NewShipmentServlet">
            
            <label for="name">PreferName</label><input type="text" name="name" placeholder="Enter name" required>
            <label for="name">Email</label><input type="email" name="email" placeholder="Enter email" required>    
            <label for="name">Phone_number</label><input type="text" name="phone" placeholder="<%= (phoneErr != null ? phoneErr :"Enter phone")%>" required>  
           <label for="name">Address</label><input type="text" name="address" placeholder="Enter address" required> 
            <label for="name">City</label><input type="text" name="city" placeholder="Enter city" required>  
            <label for="name">Territory</label><input type="text" name="territory" placeholder="Enter territory" required>
            <label for="name">Post_code</label><input type="text" name="post_code" placeholder="<%= (postCodeErr != null ? postCodeErr :"Enter phone")%>" required>
           <label for="name">Wished Delivery Date</label><input type="date" name="startDate" placeholder="Enter date (yyyy-mm-dd)" required>
            <label for="name">Shipment Method</label><input type="text" name="shipmentMethod" placeholder="" required>
            <input class="button" type ="submit" value="submit">
                
        
            </form>
        </main>
    </body>
</html>
