<%-- 
    Document   : editProfile
    Created on : 28/08/2020, 1:51:21 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Edit User Page</title>
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
        <h1>Change Profile Details</h1>
        <form>
            <table>
                <tr>
                    <td><label for="firstName">Enter first name:</label><input type="text" name="firstName" placeholder="Enter first name" required></td>
                </tr>
                <tr>
                    <td><label for="lastName">Enter last name:</label><input type="text" name="lastName" placeholder="Enter last name" required></td>
                </tr>
                <tr>
                    <td><label for="email">New Email:</label><input type="email" name="email" placeholder="Enter email" required></td>
                </tr>
                <tr>
                    <td><a class="button"  href ="userProfile.jsp">Save</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
