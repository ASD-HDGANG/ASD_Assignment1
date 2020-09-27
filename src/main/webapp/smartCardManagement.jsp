<%-- 
    Document   : smartCardManagement
    Created on : Sep 24, 2020, 11:29:28 PM
    Author     : yike8
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Smart Card Management</title>
    </head>   
    <body >
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
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>--%>
            <a href="home.jsp" style="float: left;"> Home </a>
            <a href="tripPlanner.jsp" style="float: left;"> Trip_Planner </a>
            <a href="userProfile.jsp" style="float: right;">Profile</a>
            <a href="AllAdminServlet" style="float: right;">Admin</a>
        </div>
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>

        <h1>Smart Card Management</h1>
        <br>
        <div align = "center">
            <a class="button"  href = "newSmartCard.jsp"> Create New Smart Card </a>       
            <br>     
            <a class="button"  href = "topUp.jsp"> Top Up </a>       
            <br> 
            <a class="button"  href = "smartCardLinking.jsp"> Link Smart Card </a>       
            <br>    
            <a class="button"  href = "searchSmartCard.jsp"> Linked Smart Card List </a>
            <br>
        </div>
        </main>
         <script type="text/javascript">
             var topup="${requestScope.topup}";
	    if(topup=="success"){
		alert('Top up successfull!!');
	}
       </script>
       <script type="text/javascript">
             var link="${requestScope.link}";
	    if(link=="success"){
		alert('Card linking successful!!');
	}
       </script>
       <script type="text/javascript">
             var unlink="${requestScope.unlink}";
	    if(unlink=="success"){
		alert('Unlink successfull!!');
	}
       </script>
    </body>
</html>
