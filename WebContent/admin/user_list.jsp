<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Management</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

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

<c:forEach var="user" items="${userList}">
	<tr>
		<%-- <td>${status.index + 1}</td> --%>
		<td>${user.userId}</td>
		<td>${user.email}</td>
		<td>${user.fullName}</td>
		<td><a href="edit_user?id=${user.userId}">Edit</a> &nbsp; <a
			href="javascript:void(0);" class="deleteLink" id="${user.userId}">Delete</a>
		</td>
	</tr>
</c:forEach>

		</table>
	</div>


	<%@ include file="/fragment/footer.jsp"%>
</body>
</html>