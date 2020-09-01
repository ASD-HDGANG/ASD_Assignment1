<%-- 
    Document   : userEmailRegoTest
    Created on : 30 Aug. 2020, 7:09:21 pm
    Author     : Patty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test email Page</title>
        <link rel="stylesheet" href="css/SmartCard.css">
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
        <form action="UserVerification" method="POST">
            <label>User Name</label>
            <input type="text" name="name">
            <label>User Email</label>
            <input type="email" name="email">
            <input type="submit" value="Register">
        </form>

    </body>
</html>
