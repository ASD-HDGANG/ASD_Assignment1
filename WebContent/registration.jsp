<%-- 
    Document   : registration
    Created on : 22 Sep. 2020, 8:31:16 pm
    Author     : Patty
--%>

<%@page language="java" contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Form</title>

        <!-- Register css -->
        <link rel="stylesheet" href="css/register.css">   
    </head>



    <body>

        <%--<%@ include file = "header.jsp" %>--%>

        <div class="main">
            <div class="container">
                <div class="sign-up-content">
                    <form action="<%= request.getContextPath() %>/register" method="POST" class="signup-form">
                        <h2 class="form-title">Create Account</h2>

                        <div class="form-textbox">
                            <label for="name">First Name</label>
                            <input type="text" name="fname" id="name" />
                        </div>

                        <div class="form-textbox">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" />
                        </div>

                        <div class="form-textbox">
                            <label for="pass">Password</label>
                            <input type="password" name="password" id="pass" />
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>

                        <div class="form-textbox">
                            <input type="submit" name="submit" id="submit" class="submit" value="Create account" />
                        </div>
                    </form>

                    <p class="loginhere">
                        Already have an account ?<a href="#" class="loginhere-link"> Log in</a>
                    </p>
                </div>
            </div>

        </div>

        <%@ include file = "common/footer.jsp" %>          

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
        <script src="js/regiser.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->



</html>
