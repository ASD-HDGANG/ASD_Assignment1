<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SmartCard.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>New Promotion</title>
    </head>

   <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/SmartCard.png"/></a></li>

        </ul>
        </div>
        <div class="topnav">
            <a href="home.jsp" style="float: left;"> Home </a>
        </div>
        
        <main class="main-content">
        <%
            String  postCodeErr  = (String) session.getAttribute("postCodeErr"); 
            String  phoneErr  = (String) session.getAttribute("phoneErr");
        %>
        <h1>New Promotion</h1>
        <form method = "post" action="NewPromotionServlet">
            
            <label for="title">Title</label><input type="text" name="title" placeholder="Enter title" required>
            <label for="startDate">Start Date</label><input type="date" name="startDate" placeholder="Enter startDate" required>    
            <label for="endDate">End Date</label><input type="date" name="endDate" placeholder="Enter endDate" required>  
            <label for="author">Author</label><input type="text" name="author" placeholder="Enter author name" required> 
            <label for="status">Status</label><input type="text" name="status" placeholder="Enter status" required>  
            <label for="description">Description</label><input type="text" name="description" placeholder="Enter description" required>

            <input class="button" type ="submit" value="submit">
                
        
            </form>
        </main>
    </body>
</html>
