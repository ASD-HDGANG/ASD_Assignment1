
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
        String fname = request.getParameter("fname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(fname, email, password);
        session.setAttribute("user", user); 
    %>
    <body style="background:none transparent;"> 

        <h1 class="form_title">Registration success, thank you.</h1>

        <p class="p"> Hi, <%=fname%>, click <a href="index.jsp" class="link" target="_parent"> here </a> to go to main page.</p>
    </body>


</html>
