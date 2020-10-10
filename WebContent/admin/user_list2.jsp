<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.smartcard.entity.*"%>

<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">

<title>User Management</title>
</head>


        <%
            ArrayList<User> userList = (ArrayList<User>) session.getAttribute("userList");
        
        %>

<body>

	<div align="center">
		<h2 class="pageheading">Users Management</h2>
		<h3>
			<a href="user_form.jsp">Create New User</a>
		</h3>
	</div>

	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<!-- <th>Index</th> -->
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${userList}" var="user" begin="1">
				<tr>
					<%-- <td>${status.index + 1}index 1</td> --%>
<%-- 					<td>${user.id}<!--  // show user shit!!! --></td>
					<td>${user.email}</td>
					<td>${user.fullName}</td> --%>

                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.fullName}"/></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>