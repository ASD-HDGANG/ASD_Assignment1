<%-- 
    Document   : billing
    Created on : 28/08/2020, 2:36:45 PM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/notifications.css">
        <title>Billing Page</title>
    </head>
    <body>
        <h1>SMARTCARD System</h1>
        <section class="container">
            <div class="searchDiv">
                <label for ="search" style="font-size: 40px;">Search</label><br><br>
                <label for ="Date">Date</label><br>   
                <input id="searchDate" name="searchDate" type="date" placeholder="" required = "true"/><br><br>
                <label for ="Time">Time</label><br>   
                <input id="time" name="time" type="time" placeholder="" required = "true"/><br><br>
            </div>
        <div class="billingSearchDiv">
            <table>
              <tr>
                <th style="font-size: 40px;">Date</th>
                <th style="font-size: 40px;">Bill ID number</th>
                <th style="font-size: 40px;">Location</th>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
        </div>
    </section>
    </body>
</html>
