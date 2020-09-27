<%-- 
    Document   : notificationTable
    Created on : 28/08/2020, 2:58:10 PM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <title>NotificationTable Page</title>
    </head>
    <body>
        <table id="profile_table">
                <tr>
                <thead><th>Email</th><th>Message</th></thead>
                </tr>
            <tr><td>${user.name}</td><td>${user.email}</td><td>${user.password}</td><td>${user.dob}</td><td>${user.gender}</td><td>${user.address}</td><td>${user.postcode}</td><td>${user.phoneNumber}</td></tr>
            </table>
    </body>
</html>
