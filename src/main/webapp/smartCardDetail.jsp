<%-- 
    Document   : new Smart Card
    Created on : Sep 24, 2020, 11:28:22 PM
    Author     : yike8
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <%String userId = session.getAttribute("userId").toString();%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Smart Card Detail</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="css/SmartCard.css">
</head>
<body>
       <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
      <%-- if you want to use button, you can use the below styling
        <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
      --%>
        </ul>
        </div>
        <div class="topnav">
        <%--left    button
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>--%>
            <a href="home.jsp" style="float: left;"> Home </a>
            <a href="tripPlanner.jsp" style="float: left;"> Trip_Planner </a>
            <a href="orderManagement.jsp" style="float: left;">Order </a>
            <a href="smartCardManagement.jsp" style="float: left;">Card </a>
            <a href="bill.jsp" style="float: left;">Bill </a>
            <a href="shipmentNew.jsp" style="float: left;">Shipment </a>
            <a href="reporting.jsp" style="float: right;">Report </a>
            <a href="userProfile.jsp" style="float: right;">Profile</a>
            <a href="AllAdminServlet" style="float: right;">Admin</a>

        </div>
    <h1>Successfully Created!!</h1>
    <h1><%=userId%></h1>
<div align="center">
            <h3 align="center">Smart Cart Information</h3>
            <table>
                <tr>
                    <td>Smart Card Number: </td>
                    <td>${requestScope.smartCardNumber}</td>
                </tr>
                <tr>
                    <td>Security Code: </td>
                    <td>${requestScope.securityCode}</td>
                </tr>
                <tr>
                    <td>Card Type: </td>
                    <td>${requestScope.smartCardType}</td>
                </tr>
            </table>
            <div align="center">
            <a class="button"  href="smartCardManagement.jsp"> Go back </a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <form role="form" action="SmartCardLinkingServlet" method="post">
             <input type="hidden" name="userId" value="<%=userId%>"/>
             <input type="hidden" name="smardCardNumber" value="${requestScope.smartCardNumber}"/>
             <input type="hidden" name="securityCode" value="${requestScope.securityCode}"/>
             <input class="button" type ="submit" value="Link with current account"/>
             </form> 
            </div>
</div> 
  
</body>
</html>
