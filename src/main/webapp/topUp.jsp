<%@page import="entity.SmartCard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top Up</title>
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
            <a href="tripPlanner.jsp" style="float: left;"> Trip_Planner </a>
            <a href="orderManagement.jsp" style="float: left;">Order </a>
            <a href="smartCardManagement.jsp" style="float: left;">Card </a>
            <a href="bill.jsp" style="float: left;">Bill </a>
            <a href="shipmentNew.jsp" style="float: left;">Shipment </a>
            <a href="reporting.jsp" style="float: right;">Report </a>
            <a href="userProfile.jsp" style="float: right;">Profile</a>
            <a href="AllAdminServlet" style="float: right;">Admin</a>

        </div>
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>
        <h1>Top Up</h1>
        <form method = "post" action="TopUpServlet">   
            <label for="name">Smart Card Number</label><input type="text" id="smartCardNumber" name="smartCardNumber"  maxlength="16" size="16" placeholder="16-digits card number" required>
            <label for="name">Security Code</label><input type="password" id="securityCode" name="securityCode" maxlength="4"size="4" placeholder="4-digit security code" required> 
            <label for="name">Amount</label><input type="text" id="topUpAmount" name="topUpAmount" list="amountList" maxlength="10" size="10" placeholder="Top up amount" required> 
            <datalist id="amountList">
                                     <option value="10.0">
                                     <option value="20.0">
                                     <option value="50.0">
                                     <option value="100.0">
            </datalist>
            <div align="center">
            <a class="button"  href="smartCardManagement.jsp"> Cancel </a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="button" type ="submit" value="Top up"></div>
            </form>
        </main>
        <script type="text/javascript">
             var msg="${requestScope.topup}";
	    if(msg=="error"){
		alert('Wrong card number or security code!!');
	}
       </script>
    </body>
</html>