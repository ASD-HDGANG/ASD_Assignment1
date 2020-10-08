<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />


<%-- 	<div align="center">
		<h2 class="pageheading">
			<c:if test="${user != null}">
				Edit User
			</c:if>
			<c:if test="${user == null}">
				Create New User
			</c:if>
		</h2>
	</div> --%>
	
	
	<div align="center">
<!-- ================================== -->
<%-- 		<c:if test="${user != null}">
			<form action="update_user" method="post" id="userForm">
				<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<c:if test="${user == null}">
			<form action="create_user" method="post" id="userForm">
		</c:if> --%>
<!-- ==================================== -->

<form action="create_user" method="post" id="userForm">
		<table class="form" >
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="" /></td>
			</tr>
			<tr>
				<td align="right">Full name:</td>
				<td align="left"><input type="text" id="fullname"
					name="fullname" size="20" value="" /></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" id="password"
					name="password" size="20" value="" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>
		</table>
		</form>
	</div>


	<%@ include file="/fragment/footer.jsp"%>
</body>
</html>