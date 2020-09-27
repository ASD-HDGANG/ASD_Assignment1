<%-- 
    Document   : adminNew
    Created on : 27/08/2020, 10:31:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>New Shipment</title>
    </head>   <body onload ="startTime()">
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

        <h1>Smart Card System</h1>
        <%--     <a class="button"  href = "TopUp.jsp"> Top up </a>       
            <br>
            <a class="button"  href = "OrderHistory.jsp"> Order History </a>
            <br>
            <a class="button"  href = "userPromotion.jsp"> Promotion </a>
            <br>
            <a class="button"  href ="AllShipmentsServlet">Shipment</a>
            <br>
            <a class="button"  href = "reportManage.jsp"> Report </a>
            <br>
            <a class="button"  href = "notification.jsp"> Notification </a>
                        <br>
            <a class="button"  href = "billing.jsp"> Billing </a>    --%>
        <h2>Lorem Ipsum</h2>
        <text>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</text>
        <h3>Why do we use it?</h3>
        <text>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</text>
            </form>
        </main>
    </body>
</html>
