<%-- 
    Document   : userProfile
    Created on : 28/08/2020, 12:59:19 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile Page</title>
    </head>
    <body>
        <h1>"Username"'s Profile</h1>
        <h2>Personal Details</h2>
        <table>
            <tr>
                <td>UserID: "userId"</td>
            </tr>
            <tr>
                <td>Name: firstName + lastName</td>
            </tr>
            <tr>
                <td>Email: 123@email.com</td>
            </tr>
            <tr>
                <td>Password: ******</td>
            </tr>
            <tr>
                <td>Address: 123 Mary St</td>
            </tr>
            <tr>
                <td><a class="button"  href ="editProfile.jsp">Edit Details</a></td>
            </tr>

        </table>
    </body>
</html>
