
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Shipment_Search</title>
    </head>
    <body onload="startTime()">
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
        <h1>Shipment_Search</h1>
        <form action ="shipmentSearchServlet" method="post">
            <table>
                <tr>
                    <td>ShipmentID:</td>
                    <td><input type="text"  name="shipmentID" required></td>
                </tr>
                <tr><td>Date</td>
                    <td><input type="date"  name="shipmentDate" required> </td>
                </tr>
                <tr><td></td>
                     <td><a class="button"  href = "AllShipmentsServlet">Back </a><input class="button" type="submit" value="Search"></td>
                </tr>
               
            </table>   
        </form>
        </main>
    </body>
</html>
