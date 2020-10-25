<%-- 
    Document   : updateNotification
    Created on : 26/10/2020, 3:03:01 AM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Update Notification Page</title>
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
        <main class="main-content"></main>
            <h1>Edit Notification</h1>
            <form method="post" action="UpdateNotificationServlet">
                <table>  
                    <tr><td>Date</td><td><input type="date" name="notificationDate" ></td></tr>
                    <tr><td>Priority</td><td><select name="priority" style="width: 260px; margin: auto;">
                        <option value="normal">Normal</option>
                        <option value="urgent">Urgent</option>
                    </select></td></tr>
                    <tr><td>Message</td><td><textarea rows="4" cols="30" name="message">Type your message here....</textarea></td></tr>
                    <tr>
                    <td><a class ="button" href="notification.jsp">Back</a></td>
                    <td><input class ="button" type="submit" value="Update"></td>
                    </tr>
                </table>
           </form>
        </main>
    </body>
</html>
