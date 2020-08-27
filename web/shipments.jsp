<%@page import="java.util.ArrayList"%>
<%@page import="ASD.SmartCard.Model.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
    <title>Shipment</title>
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
            <a href="StoreServlet" style="float: left;">All Products</a>--%>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>
        </div>
        
        <main class="main-content">
    <%
        ArrayList<shipment> shipments = (ArrayList<shipment>) session.getAttribute("shipments");
        String existErr = (String) session.getAttribute("existErr");
        String deleted = (String) session.getAttribute("deleted");
    %>
    <h1>Shipments</h1><h2><%=(existErr != null ? existErr : "")%><%=(deleted != null ? deleted : "")%></h2>

  <table>
      <h1>
                <a class="button"  href ="shipmentSearch.jsp">shipmentSearch</a>
                <a class="button"  href = "AllShipmentsServlet">All shipments </a>
      </h1>
                <tr>
                    <td>shipmentID </td>
                    <td> userID</td>
                    <td> preferName</td>
                    <td> email</td>
               <%--     <td> phone_number</td>
                    <td> address</td>
                    <td>city</td>
                    <td> territory</td>     --%>
                    <td> post_code</td>
                    <td>  startDate</td>
                    <td> shipmentMethod</td>
                    <td> currentStatus</td>
                    <td> Action</td>
                </tr>
                
       
        </table>
    
        </main>
</body>
</html>