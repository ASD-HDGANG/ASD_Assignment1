<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Registration Form</title>
<!-- Register css -->
<link rel="stylesheet" href="../resources/css/register.css">
</head>
<body>

	<%@ include file="header.jsp"%>





	<div class="main">
		<div class="container">
			<div class="sign-up-content">

				<div align="center">
					<h2 class="pageheading">
						<c:if test="${customer != null}">
				Edit Account
			</c:if>
						<c:if test="${customer == null}">
				Create Account
			</c:if>
					</h2>
				</div>

				<form action="create_customer" method="POST" class="signup-form">

					<div class="form-textbox">
						<label for="email">Email</label> <input type="text" name="email"
							id="email" value="${customer.email}" />
					</div>

					<div class="form-textbox">
						<label for="fullName">Full Name</label> <input type="text"
							name="fullName" id="fullName" value="${customer.fullName}" />

					</div>

					<div class="form-textbox">
						<label for="password">Password</label> <input type="password"
							id="password" name="password" value="${customer.password}" />
					</div>

					<%-- 					<div class="form-textbox">
						<label for="password">Confirm Password</label> <input type="password"
							name="confirmPassword" id="confirmPassword" value="${customer.password}" />
					</div> --%>

					<div class="form-textbox">
						<label for="phone">Phone Number</label> <input type="text"
							name="phone" id="phone" value="${customer.phone}" />
					</div>

					<div class="form-textbox">
						<label for="address">Address</label> <input type="text"
							name="address" id="address" value="${customer.address}" />
					</div>

					<div class="form-textbox">
						<label for="city">City</label> <input type="text" name="city"
							id="city" value="${customer.city}" />
					</div>

					<div class="form-textbox">
						<label for="state">state</label> <input type="text" name="state"
							id="state" value="${customer.state}" />
					</div>

					<div class="form-textbox">
						<label for="state">Post Code</label> <input type="text"
							name="postCode" id="postCode" value="${customer.postCode}" />
					</div>

					<!-- 					<div class="form-group">
						<input type="checkbox" name="agree-term" id="agree-term"
							class="agree-term" /> <label for="agree-term"
							class="label-agree-term"><span><span></span></span>I
							agree all statements in <a href="#" class="term-service">Terms
								of service</a></label>
					</div> -->

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