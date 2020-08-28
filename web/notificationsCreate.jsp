<%-- 
    Document   : notificationsCreate
    Created on : 28/08/2020, 3:01:05 PM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/notifications.css">
        <title>Create Notifications Page</title>
    </head>
    <body>
        <h1>SMARTCARD System</h1>
        
        <div class="createDiv">
            <label for="Date">Date</label>
            <input id="name" name="name" type="date" placeholder="" required = "true"/><br><br>
            <label for="Time">Time</label>
            <input id="Time" name="time" type="time" placeholder="" required = "true"/><br><br>
            <label for="message">Message</label><br>
            <textarea id="message" name="message" rows="4" cols="50">Type in your notification here.</textarea>
            <br><br><br><br><br>
            <label for="frequency">Repeat:</label>
            <select name="frequency" id="frequency">
              <option value="Once">Once</option>
              <option value="Daily">Daily</option>
              <option value="Weekly">Weekly</option>
              <option value="Monthly">Monthly</option>
            </select>
            <br><br>
            <a class="button" href ="notification.jsp">back</a>
        </div>
    </body>
</html>
