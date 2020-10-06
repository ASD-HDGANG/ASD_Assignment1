<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.smartcard.entity.*"%>
<%@page import="com.smartcard.service.*"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="animation.js"></script>
<link rel="stylesheet" type="text/css" href="css/demo.css">
<title>Welcome Page</title>
</head>
<%
String firstName = request.getParameter("firstname");
String email = request.getParameter("email");
String password = request.getParameter("password");

User user = new User(firstName, email, password);
session.setAttribute("email", email);
session.setAttribute("password", password);
%>
<body style="background: none transparent;">

	<h1 class="form_title">Registration success, thank you.</h1>

	<p class="p">
		Hi,
		<%=firstName%>
		: email :
		<%=email%>. We have sent you a email to confirm you have signed up. <br />
		<br />please click <a href="frontend/index.jsp" class="link" target="_parent">
			here </a> to go to main page.
	</p>
</body>


</html>