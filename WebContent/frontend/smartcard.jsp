


<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.smartcard.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- <%
	List<SmartCard> smartCardList = (ArrayList) session.getAttribute("smartCardList");
%>
<%
	String userId = session.getAttribute("customerId").toString();
%>
<%
	String pic = "";
%>
 --%>


<!DOCTYPE html>
<html>
<head>

<%@ include file="/fragment/meta.jsp"%>
<title>Smartcard</title>
</head>
<body>

	<%@ include file="/fragment/header.jsp"%>

	<div class="container">
		<div align="center">

			<h3 align="center">Please choose the type of card</h3>





			<form method="GET">
				<a href="view_cart">test</a>
			</form>

			<div class="row">

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img id="adult" src="../resources/images/adult.jpg"
							alt="adult smart card">
						<div class="caption">

							<a href="view_cart">
								<button class="btn btn-primary" name="adult" value="adult"
									type="submit">Order</button>
							</a>

						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img id="adult" src="../resources/images/child.jpg"
							alt="child smart card">
						<div class="caption">

							<a href="view_smartcard?cardType=${smartcard.cardType.youth}"><button
									class="btn btn-primary" name="youth" value="youth"
									type="submit" role="Add">Order</button></a>

						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img id="senior" src="../resources/images/senior.jpg"
							alt="senior smart card">
						<div class="caption">
							<span><input name="senior" value="order"
								class="btn btn-primary" type="submit" role="Add"></span>
						</div>
					</div>
				</div>
			</div>

			</form>
		</div>
	</div>

	<%@ include file="/fragment/footer.jsp"%>

</body>
</html>