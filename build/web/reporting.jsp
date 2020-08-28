<%-- 
    Document   : reporting.jsp
    Created on : 27/08/2020, 11:46:21 PM
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
          <link rel="stylesheet" href="css/Report.css">
</head>
<body>
<form role="form">
	<div class="form-group">
		<label for="name">What problem you just met? </label>
		<textarea class="form-control" rows="5"></textarea>
	</div>
    
</form>
   
	  <div class="col-sm-offset-2 col-sm-20">
			
		 <a class="button"  href ="ReportServlet">send</a>
                 
            </div>
    <div class="col-sm-offset-2 col-sm-20">
			
	
                 <a class="button"  href ="main.jsp">back</a>
            </div>
	


</body>
</html>
