<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="entity.User" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>User Profile Page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("currentUser"); %>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
      <%-- if you want to use button, you can use the below styling
        <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
      --%>
        </ul>
        </div>
        
        <h1>${currentUser.getFullName()} Profile</h1>
        
        <h2>Personal Details</h2>
        <table>
            <tr>
                <td>User ID: ${currentUser.getUserId()}</td>
            </tr>
            <tr>
                <td>Name: ${currentUser.getFullName()}</td>
            </tr>
            <tr>
                <td>Email: ${currentUser.getUserId()}</td>
            </tr>
            <tr>
                <td>Password: ${currentUser.getPassword()}</td>
            </tr>
            <tr>
                <td><a class="button"  href ="editProfile.jsp">Edit Details</a></td>
            </tr>

        </table>
    </body>
</html>
