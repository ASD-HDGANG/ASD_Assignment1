<%-- 
    Document   : verify.page
    Created on : 30 Aug. 2020, 6:52:43 pm
    Author     : Patty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>

        <span>Please enter your code to verify</span>
        
        <form action="VerifyCode" method="POST">
            <input type="text" name="authcode">
            <input type="submit" name="verify">            
        </form>       
        
    </body>
</html>
