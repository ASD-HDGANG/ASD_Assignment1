<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>admin</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<hr width="60%" />
		<h3 class="pageheading">Brief Summary:</h3>
		<b> 
		<a href="staff_form.jsp">New Staff</a> &nbsp; |
		<a href="new_customer">New Customer</a>
		</b>
	</div>

	<div align="center">
		<hr width="60%" />
		<h3>Recent orders</h3>
	</div>

	<div align="center">
		<hr width="60%" />
		<h3>Recent Reports</h3>
	</div>


	<%@ include file="/fragment/footer.jsp"%>
</body>
</html>