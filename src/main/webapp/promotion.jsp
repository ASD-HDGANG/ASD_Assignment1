<%@page import="java.util.ArrayList"%>
<%@page import="entity.Promotion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
    <title>Promotion</title>
</head>
<body>
    <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
        </ul>
        </div>
        <div class="topnav">

            <a href="home.jsp" style="float: left;"> Home </a>
        </div>
        
        <main class="main-content">
    <%
        ArrayList<Promotion> promotions = (ArrayList<Promotion>) session.getAttribute("promotions");
        String existErr = (String) session.getAttribute("existErr");
        String deleted = (String) session.getAttribute("deleted");
    %>
    <h1>Promotions</h1><h2><%=(existErr != null ? existErr : "")%><%=(deleted != null ? deleted : "")%></h2>

  <table>
      <h1>
                <a class="button"  href = "AllPromotionServlet">All Promotions</a>
      </h1>
                <tr>
                    <td>Promotion Title</td>
                    <td>Start Date</td>
                    <td>End Date</td>
                    <td>Author</td>
                    <td>Status</td>
                    <td>Description</td>

                </tr>
                
                
                <c:forEach var="promotion" items="${promotions}">
                    <tr>
                        <td><c:out value="${promotion.title}"/></td>
                        <td><c:out value="${promotion.startDate}"/></td>
                        <td><c:out value="${promotion.endDate}"/></td>
                        <td><c:out value="${promotion.author}"/></td>
                        <td><c:out value="${promotion.status}"/></td>
                        <td><c:out value="${promotion.description}"/></td>
                        
<!--                  <td>    <a href="ShipmentEditServlet?email=<c:out value ="${shipment.email}"/>&date=<c:out value="${shipment.arriveDate}"/>">Detail</a>
                          <a href="ShipmentDeleteServlet?email=<c:out value ="${shipment.email}"/>&date=<c:out value="${shipment.arriveDate}"/>">Delete</a>            
                    </td>-->
                    </tr>
                </c:forEach>
       
        </table>
    <h2>
             <a class="button"  href = "newPromotion.jsp">New Promotions</a>
    </h2>
    
        </main>
</body>
</html>