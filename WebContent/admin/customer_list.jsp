<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Customer Management</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Customer Management</h2>
		<h3>
			<a href="customer_form.jsp">Create New Customer</a>
		</h3>
	</div>

	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>City</th>
				<th>State</th>
				<th>Post Code</th>
				<th>Registered Date</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${customer.customerId}</td>
					<td>${customer.email}</td>
					<td>${customer.fullName}</td>
					<td>${customer.state}</td>
					<td>${customer.postCode}</td>
					<td>${customer.registerDate}</td>

					<td><a href="edit_customer?id=${customer.customerId}">Edit</a>
						&nbsp; <a href="javascript:void(0);" class="deleteLink"
						id="${customer.customerId}">Delete</a></td>
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