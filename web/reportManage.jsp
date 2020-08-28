<%-- 
    Document   : reportManage.jsp
    Created on : 28/08/2020, 12:32:08 AM
    Author     : daohuxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/SmartCard.css">
        <title>JSP Page</title>
    </head>
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

        </div>
    <body>
        <h1>Manage your report here</h1>
        <div class="col-sm-offset-2 col-sm-10">
			
                 <a class="button"  href ="reporting.jsp">Add new Report</a>   
                 <a class="button"  href ="home.jsp">back</a>
            </div>
    </body>
</html>
