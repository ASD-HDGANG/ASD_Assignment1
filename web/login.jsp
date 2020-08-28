<%-- 
    Document   : login
    Created on : 27/08/2020, 11:36:42 PM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Login Page</title>
    </head>
    <body>
        <h1>SMARTCARD System</h1>
        
        <form style="text-align: center;" method="post" action="LoginServlet">
            <h1>Login</h1>
            <label for="email">Email address</label>
            <input id="email" name="email" type="text" placeholder="email"/>
            
            <label for="password">Password</label>
            <input id="password" name="password" type="text" placeholder="password"/>
            <br>
            <a class="button" href="index.jsp"> Cancel </a>
            <input class="button" type="submit" value="Login"/><br>
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        </form>
        
    </body>
</html>
