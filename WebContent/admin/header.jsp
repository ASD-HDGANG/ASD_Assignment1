
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div align="center">
	<div>
		<p>this is the header</p>
	</div>
	<div>
		Welcome,
		<c:out value="${sessionScope.useremail}" />
		| <a href="logout">Logout</a> <br /> <br />
	</div>

	<h2>Dashboard</h2>

	<b> <a href="list_users">staff</a> | <a href="list_cards">smartcards</a>
		| <a href="list_customer">customers</a> | <a href="reports">reports</a>
		| <a href="orders">orders</a> |
	</b>

</div>
