<%-- 
    Document   : readNotifications
    Created on : 25/10/2020, 10:47:23 PM
    Author     : Martin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Notification"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Notifications Page</title>
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
        <h1>Notifications</h1>
        <%
            ArrayList<Notification> notifications = (ArrayList<Notification>) session.getAttribute("notifications");
        
        %>
        <table>
        <h1>
                  <a class="button"  href = "AllNotificationServlet">All shipments </a>
        </h1>
                <tr>
                    <td> Notification ID</td>
                    <td> Customer ID</td>
                    <td> Created Date</td>
                    <td> Notification Date</td>
                    <td> Priority Level</td>
                    <td> Message</td>
                </tr>
                
                
                <c:forEach var="notification" items="${notifications}">
                    <tr>
                        <td><c:out value="${notification.notificationID}"/></td>
                        <td><c:out value="${notification.customerID}"/></td>
                        <td><c:out value="${notification.createdDate}"/></td>
                        <td><c:out value="${notification.notificationDate}"/></td>
                        <td><c:out value="${notification.priority}"/></td>
                        <td><c:out value="${notification.message}"/></td>
                        <td>
                            <a href="UpdateNotificationServlet?notificationID=<c:out value ="${notification.notificationID}"/>"/>Detail</a>
                            <a href="ShipmentDeleteServlet?email=<c:out value ="there"/>&date=<c:out value="${shipment.arriveDate}"/>">Delete</a>            
                        </td>
                    </tr>
                </c:forEach>
       
        </table>
        </main>
    </body>
</html>
