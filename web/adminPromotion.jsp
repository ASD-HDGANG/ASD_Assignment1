<%-- 
    Document   : adminPromotion
    Created on : 28/08/2020, 12:58:54 PM
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
        <h1>Promotions(Admin)</h1>
        <table>
            <tr><td><a class="button"  href ="createPromotion.jsp">New Promotion</a></td></tr>
            <tr><td><a class="button"  href ="userPromotion.jsp">View Promotions</a></td></tr>
        </table>
    </body>
</html>
