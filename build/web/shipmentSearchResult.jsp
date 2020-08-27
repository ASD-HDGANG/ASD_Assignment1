<%@page import="ASD.SmartCard.Model.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
    <title>Shipment</title>
</head>
<body onload="startTime(); resetSearch();">
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
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>
        </div>
        
        <main class="main-content">

  <h1>Shipment Search Result</h1>
  <h1>
  <a class="button" href="ShipmentEditServlet">Edit</a>
  <a class="button" href="ShipmentDeleteServlet">Delete</a>
  </h1>
  

        </main>
</body>
</html>