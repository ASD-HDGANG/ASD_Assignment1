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
        <h1>New Admin</h1>
        <form method = "post" action="NewAdminServlet">
            
            <label for="name">UserID</label><input type="text" name="userID" placeholder="Enter userID" required>
            <input class="button" type ="submit" value="submit">
                
        
            </form>
        </main>
    </body>
</html>
