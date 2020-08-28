<%-- 
    Document   : createPromotion
    Created on : 28/08/2020, 2:13:51 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Create Promotion Page</title>
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
        <h1>Create new promotion</h1>
        <form>
            <table>
                <tr>
                    <td><label for="title">Enter Promotion Title:</label><input type="text" name="title" placeholder="Promotion title" required></td>
                </tr>
                <tr>
                    <td><label for="startDate">Enter start date:</label><input type="text" name="startDate" placeholder="Enter start date" required></td>
                </tr>
                <tr>
                    <td><label for="endDate">Enter end date:</label><input type="text" name="endDate" placeholder="Enter end date" required></td>
                </tr>
                <tr>
                    <td><label for="description">Enter description:</label><input type="text" name="description" placeholder="Enter description" required></td>
                </tr>
                <tr>
                    <td><a class="button"  href ="userPromotion.jsp">Post Promotion</a></td>
                </tr>
            </table>
    </body>
</html>
