<%-- 
    Document   : userProfile
    Created on : 28/08/2020, 12:59:19 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>User Profile Page</title>
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
        <h1>"Username"'s Profile</h1>
        <h2>Personal Details</h2>
        <table>
            <tr>
                <td>UserID: "userId"</td>
            </tr>
            <tr>
                <td>Name: firstName + lastName</td>
            </tr>
            <tr>
                <td>Email: 123@email.com</td>
            </tr>
            <tr>
                <td>Password: ******</td>
            </tr>
            <tr>
                <td>Address: 123 Mary St</td>
            </tr>
            <tr>
                <td><a class="button"  href ="editProfile.jsp">Edit Details</a></td>
            </tr>

        </table>
    </body>
</html>
