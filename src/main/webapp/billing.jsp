<%-- 
    Document   : billing
    Created on : 28/08/2020, 2:36:45 PM
    Author     : Martin
--%>

<%@page import="entity.Billing"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Billing Page</title>
    </head>
    <body>
        
        
        <%
            ArrayList<Billing> billings = (ArrayList<Billing>) session.getAttribute("billings");
        
        %>
        
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
            <h1>SMARTCARD System</h1>
            
        <section>
            <div>
                <label for ="search" style="font-size: 40px;">Search</label><br><br>
                <label for ="Date">Date</label><br>   
                <input id="searchDate" name="searchDate" type="date" placeholder="" required = "true"/><br><br>
                <label for ="Time">Time</label><br>   
                <input id="time" name="time" type="time" placeholder="" required = "true"/><br><br>
            </div>
        <div>
            <table>
              <tr>
                <td style="font-size: 40px;">Date</td>
                <td style="font-size: 40px;">Order ID</td>
                <td style="font-size: 40px;">Location</td>
                <td></td>
              </tr>
              
              
            <c:forEach var="billing" items="${billings}">
              <tr>
                <td><c:out value="${billing.paymentDate}"/></td>
                <td><c:out value="${billing.orderID}"/></td>
                <td><c:out value="${billing.location}"/></td>
                <td></td>
              </tr>
            </c:forEach>
              
            </table>
        </div>
                <!-- <a href="ShipmentDeleteServlet?id=<c:out value ="${shipment.arriveDate}"/>">Delete</a> -->   
    </section>
    </body>
</html>