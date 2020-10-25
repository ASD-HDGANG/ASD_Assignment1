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
        <h1>Login</h1>
        
        <div>
        <form method="get" action="LoginServlet">
            <label for="userName">User Name</label>
            <input id="userName" name="userName" type="text" placeholder="user name"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="text" placeholder="password"/>
            <br/>
            <div align="center">
            <a class="button" href="index.html"> Cancel </a>
            <input class="button" type="submit" name="Login"/>
            </div>
            <br/>
          <%--  <input class="button" type="submit" value="Login"/> --%>
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        </form>
        </div>
            
         <script type="text/javascript">
             var msg="${requestScope.login}";
	    if(msg=="fail"){
		alert('Incorrect user name or password...');
	}
       </script>
    </body>
</html>
