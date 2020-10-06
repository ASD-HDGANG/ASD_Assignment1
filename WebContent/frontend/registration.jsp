<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
<!-- Register css -->
<link rel="stylesheet" href="../resources/css/register.css">
</head>
<body>

	<%--<%@ include file = "header.jsp" %>--%>
<div class="main">
		<div class="container">
			<div class="sign-up-content">
				<form action="<%=request.getContextPath()%>/register"
					method="POST" class="signup-form">
					<h2 class="form-title">Create Account</h2>

					<div class="form-textbox">
						<label for="name">First Name</label> <input type="text"
							name="firstname" id="name" />
					</div>

					<div class="form-textbox">
						<label for="email">Email</label> <input type="email" name="email"
							id="email" />
					</div>

					<div class="form-textbox">
						<label for="pass">Password</label> <input type="password"
							name="password" id="pass" />
					</div>

					<div class="form-group">
						<input type="checkbox" name="agree-term" id="agree-term"
							class="agree-term" /> <label for="agree-term"
							class="label-agree-term"><span><span></span></span>I
							agree all statements in <a href="#" class="term-service">Terms
								of service</a></label>
					</div>

					<div class="form-textbox">
						<input type="submit" name="submit" id="submit" class="submit"
							value="Create account" />
					</div>
				</form>

				<p class="loginhere">
					Already have an account ?<a href="#" class="loginhere-link">
						Log in</a>
				</p>
			</div>
		</div>

	</div>


	<%@ include file="/fragment/footer.jsp"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>