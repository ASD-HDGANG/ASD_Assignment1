<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%!int pageCount = 0;

	void addCount() {
		pageCount++;
	}%>
<%
	addCount();
%>


<!DOCTYPE html>
<html>
<head>



<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
<link href="/login.css" rel="stylesheet">
</head>
<body>

	<%
		String email = (String) session.getAttribute("email");
	String password = (String) session.getAttribute("password");
	%>


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>


				<ul class="nav navbar-nav navbar-right">
					<form class="navbar-form navbar-left" role="search">

						<div class="form-group">

							<a href="registration.jsp">Sign up</a> <span
								style="color: #fff;">&nbsp;&nbsp;or&nbsp;&nbsp;</span>

							<%-- 					<%
						//String email = (String) session.getAttribute("email");
					if (true) {

					} else {

					}
					%> --%>
							<input type="text" class="form-control" placeholder="Email">
							<input type="text" class="form-control" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-default">Login</button>
					</form>
					<!-- <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li> -->
				</ul>
			</div>
		</div>
	</nav>





</body>
</html>