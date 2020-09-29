<%-- 
    Document   : viewBill
    Created on : 28/09/2020, 4:01:09 AM
    Author     : Martin
--%>
<%@page import="entity.Billing"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <title>Bill</title>
    </head>
    <body>
        <%
            Billing billing = (Billing)session.getAttribute("billing");
        %>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
      
        </ul>
        </div>
         <div class="topnav">
            <a href="home.jsp" style="float: left;"> Home </a>
        </div>
        <h1>Bill</h1>
        
        <div class="billForm" style="background-image: url(Invoice.jpg)">
            <label style="font-size: 20px;" for="orderID">Order ID: ${billing.orderID}</label><br>
            <label style="font-size: 20px;" for="customerID">Customer ID: ${billing.customerID}</label><br>
            <label style="font-size: 20px;" for="billDateGenerated">Date: ${billing.billDateGenerated}</label><br>
            <table>
                <tr>
                    <td style="font: bold; font-size: 40px;">Service</td>
                    <td style="font: bold; font-size: 40px;">Location</td>
                    <td style="font: bold; font-size: 40px;">Amount</td>
                </tr>
                <tr>
                    <td>${billing.service}</td>
                    <td>${billing.location}</td>
                    <td>${billing.amount}</td>
                </tr>
            </table>
            <label style="font-size: 20px;" for="tax">Tax: ${billing.tax}</label><br>
            <label style="font-size: 20px;" for="amountDue">Amount due: ${billing.amount}</label><br>
                
            <a class="button"  href ="BillingServlet">back</a>
            
        </div>
        
    </body>
</html>
