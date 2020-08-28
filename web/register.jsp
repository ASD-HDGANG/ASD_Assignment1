<%-- 
    Document   : register
    Created on : 28/08/2020, 3:05:56 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Register Page</title>
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
        <h1>Registration</h1>
                <form>
            <table>
                <tr>
                    <td><label for="firstName">Enter first name:</label><input type="text" name="firstName" placeholder="Enter first name" required></td>
                </tr>
                <tr>
                    <td><label for="lastName">Enter last name:</label><input type="text" name="lastName" placeholder="Enter last name" required></td>
                </tr>
                <tr>
                    <td><label for="email">Enter Email:</label><input type="email" name="email" placeholder="Enter email" required></td>
                </tr>
                <tr>
                    <td><label for="address">Enter Address:</label><input type="text" name="address" placeholder="Enter address" required></td>
                </tr>
                <tr>
                    <td><label for="password">Enter Password:</label><input type="password" name="password" placeholder="Enter password" required></td>
                </tr>
                
                <tr>
                    <td><a class="button"  href ="main.jsp">Register</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
