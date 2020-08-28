<%-- 
    Document   : userPromotion
    Created on : 28/08/2020, 12:58:38 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Promotions Page</title>
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
        <h1>Promotions</h1>
        <h1>
        <a class="button"  href ="shipmentNew.jsp">Shipment Address</a>
        </h1>
        <table>
            <tr>
                <td>promotionId</td>
                <td>promotionTitle</td>
                <td>promotionStartDate</td>
                <td>promotionEndDate</td>
                <td>promotionAuthor</td>
                <td>promotionDescription</td>
                <td>promotionStatus</td>
                
            </tr>
        </table>
    </body>
</html>
