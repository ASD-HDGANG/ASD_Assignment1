<%-- 
    Document   : notification
    Created on : 28/08/2020, 2:46:43 PM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/notifications.css">
        <title>Notifications Page</title>
    </head>
    <body>
        <h1>SMARTCARD System</h1>
        <div class = "notificationDiv">
        <a class="button" href ="notificationsCreate.jsp">Create Notification</a>
        <br><br><br><br>
        <br>
        <jsp:include page="notificationMessages.jsp" flush="true" />
        </div>
    </body>
</html>
