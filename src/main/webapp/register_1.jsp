<%-- 
    Document   : register
    Created on : 28/08/2020, 3:05:56 PM
    Author     : Kyle
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mongodb.Mongo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/SmartCard.css">

        <title>Register Page</title>
    </head>
    <body>
        <div class="header-img">
            <a href="index.jsp"><img class="logo" src="images/SmartCard.png"/></a>
                <%-- if you want to use button, you can use the below styling
                  <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
                    <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
                --%>
        </div>
        <h1>Registration</h1>


        <form action="index.jsp" method="POST">
            <label for="firstName">Enter first name:</label><input type="text" name="firstName" placeholder="Enter first name">
            <label for="lastName">Enter last name:</label><input type="text" name="lastName" placeholder="Enter last name">
            <label for="email">Enter Email:</label><input type="email" name="email" placeholder="Enter email" >
            <label for="address">Enter Address:</label><input type="text" name="address" placeholder="Enter address">
            <label for="password">Enter Password:</label><input type="password" name="password" placeholder="Enter password">
            <input class="button" type="submit" value="Register">
        </form>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <!-- If you're using Stripe for payments -->
        <!--<script type="text/javascript" src="https://js.stripe.com/v2/"></script>-->
        <script type="text/javascript" src="js/credit_card.js"></script>

    </body>
</html>












