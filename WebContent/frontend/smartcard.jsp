


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


			<%-- 				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<c:forEach items="${smartcard} var="smartcard">
								<img
									src="\resources\\images\\<c:out value="${smartcard}"/> alt="
									smart card"/>
							</c:forEach>
							<!-- FileServlet?path=D:\Users\\Patty\\eclipse-workspace\\smartcardDemo/WebContent\\resources\\images\\ -->
							<div class="caption">
								<span><input name="adult" value="adult"
									class="btn btn-primary" type="submit" role="Add"></span>
								<a href="view_smartcard?cardType=${smartcard.cardType}" ></a>
							</div>
						</div>
					</div>
				</div> --%>



			<div class="row">
				<form role="form" action="/order_adult" method="GET">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img id="adult" src="../resources/images/adult.jpg"
								alt="adult smart card">
							<div class="caption">
								<button class="btn btn-primary" name="adult" value="adult" type="submit" role="Add">
									Order
								</button>
								<a href="view_smartcard?cardType=${smartcard.cardType.adult}"></a>
							</div>
						</div>
					</div>
				</form>

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img id="adult" src="../resources/images/child.jpg"
							alt="child smart card">
						<div class="caption">
							<span><input name="smartCardType" name="smartCardType"
								value="order" class="btn btn-primary" type="submit" role="Add"></span>
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