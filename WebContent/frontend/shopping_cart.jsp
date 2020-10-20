<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/fragment/meta.jsp"%>
<title>Shop Cart</title>

</head>
<body>
	<%@ include file="/fragment/header.jsp"%>

	<div align="center">
		<h2>Card Summary</h2>

		<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>

		<form action="update_cart" method="post" id="cartForm">
			<div>
				<table border="1">
					<tr>
						<th>No</th>
						<th colspan="2">Type</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th></th>
					</tr>
					<c:forEach items="${cart.items}" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td><img src="" /></td>
							<td><span id="card-type">${item.key.type}</span></td>
							<td><input type="hidden" name="bookId"
								value="${item.key.cardId}" /> <input type="text"
								name="quantity${status.index + 1}" value="${item.value}"
								size="5" /></td>
							<td><fmt:formatNumber value="${item.key.price}"
									type="currency" /></td>
							<td><fmt:formatNumber value="${item.value * item.key.price}"
									type="currency" /></td>
							<td><a href="remove_from_cart?cardId_id=${item.key.cardId}">Remove</a></td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td></td>

						<td>Total:</td>
						<td colspan="2"><b><fmt:formatNumber
									value="${cart.totalAmount}" type="currency" /></b></td>
					</tr>
				</table>
			</div>
			<div>
				<table class="normal">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit">Update</button> &nbsp; &nbsp;</td>
						<td><input type="button" id="clearCart" value="Clear Cart" />&nbsp;&nbsp;</td>

						<td><a href="checkout">Checkout</a>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<br />
	<br />

	<%@ include file="/fragment/footer.jsp"%>


</body>
</html>