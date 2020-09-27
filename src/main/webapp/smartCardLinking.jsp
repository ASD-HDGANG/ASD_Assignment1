<%-- 
    Document   : smartCardLinking
    Created on : Sep 27, 2020, 5:24:43 AM
    Author     : yike8
--%>

<%@page import="entity.SmartCard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Card Linking</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" href="css/SmartCard.css">
    </head>
   <body onload ="startTime()">
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

        </div>
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>
        <h1>Smart Card Linking</h1>
        <form method = "post" action="SmartCardLinkingServlet">   
            <label for="name">Smart Card Number</label><input type="text" id="smartCardNumber" name="smartCardNumber"  maxlength="16" size="16" placeholder="16-digits card number" required>
            <label for="name">Security Code</label><input type="password" id="securityCode" name="securityCode" maxlength="4"size="4" placeholder="4-digit security code" required> 
            <label for="name">User Id</label><input type="text" id="userId" name="userId" maxlength="10" size="10" placeholder="Account number" required> 
            <a class="button"  href="smartCardManagement.jsp"> Cancel </a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" type ="submit" value="Link">
            </form>
        </main>
        <script type="text/javascript">
             var msg="${requestScope.link}";
	    if(msg=="linked"){
		alert('Sorry! this card has already been linked to another card..');
	}
       </script>
    </body>
</html>