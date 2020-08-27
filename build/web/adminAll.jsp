<%-- 
    Document   : adminNew
    Created on : 27/08/2020, 10:31:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>New Shipment</title>
    </head>
    <body onload ="startTime()">
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
            <a href="AllAdminServlet" style="float: right;">Admin</a>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>
        </div>
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>

        <h1>All Admin</h1>
        <table>
            
            <h1>        <a class="button"  href = "adminNew.jsp">Add new admin </a>
            </h1>
             <tr>
                <td>AdminID </td>
                <td>UserID</td>
                <td>Email</td>
             </tr>
        </table>        
        
            </form>
        </main>
    </body>
</html>
