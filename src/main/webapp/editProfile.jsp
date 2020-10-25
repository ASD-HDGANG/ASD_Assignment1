<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Edit Profile Page</title>
    </head>
    <body>
        <h1>Edit Profile</h1>
        
        <form action="UpdateUserServlet" method="post">
            
            <input type="hidden" value="${currentUser.getId()}" name="id">
            <input type="hidden" value="${currentUser.getEmail()}" name="Email">
            <input type="hidden" value="${currentUser.getPassword()}" name="Password">
            <p><label>New Name?</label><input type="text" value="${currentUser.getFirstName()}" name="FirstName"></p>
            <p><label>New Email?</label><input type="text" value="${currentUser.getLastName()}" name="LastName"></p>
            <p><label>Phone Number?</label><input type="text" value="${currentUser.getPhoneNumber()}" name="Phone"></p>
            
            <div class="button"><input type="submit" value="Save"></div>
            <div class="button"><input type="button" value="Cancel"></div>
        </form>
    </body>
</html>
