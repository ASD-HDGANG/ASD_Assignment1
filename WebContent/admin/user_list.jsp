<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Management</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Users Management</h2>
		<h3>
			<a href="user_form.jsp">Create New User</a>
		</h3>
	</div>

	<c:if test="${msg != null}">
		<div align="center">
			<h4 class="msg">${msg}</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${userList}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.id}</td>
					<td>${user.email}</td>
					<td>${user.fullName}</td>


					<td><a href="edit_user?id=${user.id}">Edit</a> &nbsp;
					<a href="delete_user?id=${user.id}" class="deleteLink" id="${user.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>


	
	<%@ include file="/fragment/footer.jsp"%>

<!-- 	<script>
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					userId = $(this).attr("id");
					if (confirm('Delete the user with ID ' +  userId + '?')) {
						window.location = 'delete_user?id=' + userId;
					}					
				});
			});
		});
	</script> -->

	
</body>
</html>