<%-- 
    Document   : orderList
    Created on : Sep 25, 2020, 6:02:05 PM
    Author     : yike8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.SmartCard"%>

 <%List<SmartCard> smartCardList = (ArrayList) session.getAttribute("smartCardList");
 String userId = session.getAttribute("userId").toString();
 String pic = "";%>
 
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Smart Card List</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <link rel="stylesheet" href="css/SmartCard.css">
         
    <style type="text/css">           
       table.gridtable {
          font-size:17px;
          color:#444444;
          border-width: 1px;
          border-color: #666666;
          border-collapse: collapse;
      }
      table.gridtable th {
          border-width: 1px;
          padding: 8px;
          border-style: solid;
          border-color: #666666;
          background-color: #dedede;
      }
      table.gridtable td {
          border-width: 1px;
          padding: 8px;
          border-style: solid;
          border-color: #666666;
          background-color: #ffffff;
      }
    </style>
</head>
<body>
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
    <h1>Smart Cards Linked With </h1><h1 style = "color: blue"><%=userId%></h1>
    <table border = "0">
        <tr>
            <form role="form" action="smartCardListServlet" method="get">
            <td><input type="text" name="userId"  maxlength="16" placeholder="Check another one" required></td>
            <td><input class="button" type ="submit" value="Search"></td>
            </form>
            <td> <a class="button"href ="orderManagement.jsp">Go back</a></td>
        </tr>   
    </table>
<div>
    <table class="gridtable">
                <thead>
                    <tr>
                        <th>Card Type</th>
                        <th>Card Number</th>
                        <th>Balance</th>
                        <th>Status</th>
                        <th></th>>
                    </tr>
                </thead>
                <tbody>
                    <%for (SmartCard s : smartCardList) {%>
                    <tr>
                        <td><%
                               if((s.getCardType()).equals("adult")){
                                   pic = "css/adult.jpg";
                               }
                               else if((s.getCardType()).equals("child")){
                                   pic = "css/child.jpg";
                               }
                               else if((s.getCardType()).equals("senior")){
                                   pic = "css/senior.jpg";
                               }
                               %><img src="<%=pic%>" /></td>
                        <td><%=s.getCardNumber()%></td>
                        <td><%=s.getCardBalance()%></td>
                        <td><%=s.getCardStatus()%></td>   
                        <td> 
                             <form role="form" action="SmartCardListServlet" method="post">     
                                <input type="hidden" name="smartCardNumber" value="<%=s.getCardNumber()%>"/><input type ="submit" value="unlink"/>
                             </form>
                         </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
</div> 
       
</body>
</html>

