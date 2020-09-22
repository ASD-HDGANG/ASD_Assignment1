<%-- 
    Document   : reportManage
    Created on : 19/09/2020, 3:38:48 PM
    Author     : daohuxia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Reporting</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="css/SmartCard.css">
                <script src="/1.11.1/jquery.min.js"></script>  
 <script src="/js/bootstrap.min.js"></script>  
 <script src="/bootbox.js"></script>  
        
</head>
   <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>
     
        </ul>
        </div>
        <div class="topnav">
        <%--left    button
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="AllShipmentsServlet" style="float: right;">Shipments</a>--%>
            <a href="home.jsp" style="float: left;"> Home </a>

        </div>
<body>
    


<form role="form" action="ReportManageServlet" method="get">
	
<div class="form-group">
<!--		<label for="name">Your Bug Report submitted successfully</label>-->
              
               
            <div class="page-header">
 <h1>Your Bug Report submitted successfully</h1>
 
</div>
<%  
            String description = request.getParameter("description");  
            session.setAttribute("description",description);  
         %>  
         
        
<div class="alert alert-success"> your description：     <%=description%>  </div>
                

	</div>
    
<div class="col-sm-offset-2 col-sm-20">
			
		 <a class="button"  href ="reporting.jsp">Add One More</a>
                 <a class="button"  href ="ReportManageServlet?todo=deleteReport" data-toggle="modal" data-target="#myModal">Withdraw</a>
                  <a class="button"  href ="ReportManageServlet?todo=updateReport">update</a>
                 <a class="button"  href ="home.jsp">Home</a>
                 
	  
                 

            </div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
        Submission Withdrawed successfully
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<!--        <button type="button" class="btn btn-primary">Save changes</button>-->
      </div>
    </div>
  </div>
</div>

</form>
   



	


</body>
</html>
