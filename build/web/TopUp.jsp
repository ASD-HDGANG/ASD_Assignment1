<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Top-Up</title>
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
        <h1>Top Up</h1>
        <form method = "post" action="NewAdminServlet">   
            <label for="name">Card Number</label><input type="text" id="smartCardNumber" name="smartCardNumber"  maxlength="16" size="16" placeholder="16-digits card number" required>
            <label for="name">Security Code</label><input type="password" id="securityCode" name="securityCode" maxlength="4"size="4" placeholder="4-digit security code" required> 
            <label for="name">Amount</label><input type="text" id="topUpAmount" name="topUpAmount" list="amountList" maxlength="4" size="4" placeholder="Top up amount" required> 
            <datalist id="amountList">
                                     <option value="10">
                                     <option value="20">
                                     <option value="50">
                                     <option value="100">
            </datalist>
            <input class="button" type ="submit" value="submit">
            </form>
        </main>
    </body>
</html>