<%-- 
    Document   : smartCardDelete
    Created on : Oct 22, 2020, 2:52:31 PM
    Author     : yike8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.SmartCard"%>

 <%List<SmartCard> smartCardList = (ArrayList) session.getAttribute("smartCardList");%>
 <%String smartCardNumber = session.getAttribute("smartCardNumber").toString();%>
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Delete Smart Card</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="css/SmartCard.css">
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
            <a href="tripPlanner.jsp" style="float: left;"> Trip_Planner </a>
            <a href="orderManagement.jsp" style="float: left;">Order </a>
            <a href="smartCardManagement.jsp" style="float: left;">Card </a>
            <a href="bill.jsp" style="float: left;">Bill </a>
            <a href="shipmentNew.jsp" style="float: left;">Shipment </a>
            <a href="reporting.jsp" style="float: right;">Report </a>
            <a href="userProfile.jsp" style="float: right;">Profile</a>
            <a href="AllAdminServlet" style="float: right;">Admin</a>

        </div>
    <%for (SmartCard s : smartCardList) {
        if (s.getCardNumber().equals(smartCardNumber) && Double.valueOf(s.getCardBalance()) > 0) {%>
        <h1>The balance of this card is<h1>
        <h1 style = "color:blue"><%=s.getCardBalance()%><h1>
    <h2 align = "center">Please enter another card number to transfer the balance</h2>
  <table border="0">
    <form role="form" action="SmartCardDeleteServlet" method="post">
     <tr>
         <td><input type="text" name="smartCardNumber"  maxlength="16" required></td>
         <td><input class="button" type ="submit" value="Transfer and Delete"></td>
         <td><input type="hidden" name="balance" value="<%=s.getCardBalance()%>">
          <input type="hidden" name="deleteSmartCardNumber" value="<%=s.getCardNumber()%>">
             <a class="button" href ="smartCardList.jsp">Cancel</a></td>
     </tr>   
    </form> 
   </table> 
  <%}
}%>
<script type="text/javascript">
             var delete="${requestScope.delete}";
	    if(delete=="error"){
		alert('Please enter a valid card number!!');
	}
 </script>
</body>
</html>