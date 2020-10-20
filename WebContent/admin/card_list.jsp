<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Card Management</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Card Management</h2>
		<h3>
			<a href="card_form.jsp">Create card</a>
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
				<th>card number</th>
				<th>security code</th>
				<th>card type</th>
				<th>card balance</th>
				<th>Action</th>
			</tr>

			<%-- <c:forEach items="${cardList}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${card.id}</td>
					<td>${card.number}123412565678 3456</td>
					<td>${card.code}4567</td>
					<td>${card.type}Concession</td>
					<td>${card.balance}$20</td>


					<td><a href="edit_card?id=${card.id}">Edit</a> &nbsp; <a
						href="delete_card?id=${card.id}" class="deleteLink"
						id="${card.id}">Delete</a></td>
				</tr>
			</c:forEach> --%>

			<tr>
				<td>${status.index + 1}</td>
				<td>${card.id} 59597867699</td>
				<td>${card.number}1234125656783456</td>
				<td>${card.code}4567</td>
				<td>${card.type}Concession</td>
				<td>${card.balance}$20.00</td>


				<td><a href="edit_card?id=${card.id}">Edit</a> &nbsp; <a
					href="delete_card?id=${card.id}" class="deleteLink" id="${card.id}">Delete</a></td>
			</tr>

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