<%-- 
    Document   : welcome
    Created on : 23/03/2018, 3:13:21 PM
    Author     : george
--%>

<%@page import="uts.asd.model.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="animation.js"></script>
        <link rel="stylesheet" type="text/css" href="css/demo.css">
        <title>Welcome Page</title>
    </head>   
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(name, email, password);
        session.setAttribute("user", user);        

    %>
    <body style="background:none transparent;"> 

        <p class="form_title">Your Information have been updated.</p>
        <table class="table">
            <tr><td>Name: </td><td class="text"><%=name%></td></tr>
            <tr><td>Email: </td><td class="text"><%=email%></td></tr>
            <tr><td>Password: </td><td class="text"><%= password%></td></tr>
        </table>       
    </body>
    <p class="p">Click <a href="index.jsp" class="link" target="_parent"> here </a> to go to main page.</p>

</html>
