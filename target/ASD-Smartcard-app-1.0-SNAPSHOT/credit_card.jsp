<%-- 
    Document   : credit_card
    Created on : 28 Aug. 2020, 11:19:49 am
    Author     : Patty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Credit Card</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/credit_card.css">
        <!------ Include the above in your HEAD tag ---------->

        
    </head>

    <body>




        <div class="container">

            <hr>

            <div class="row">
                <aside class="col-sm-6">
                    <p>Payment form1</p>
                    <a button href ="userProfile.jsp"> Back</a>
                    <article class="card">
                        <div class="card-body p-5">
                            <p> <img src="/main/images/icons/pay-visa.png"> 
                                <img src="/main/images/icons/pay-mastercard.png"> 
                                <img src="/main/images/icons/pay-american-ex.png">
                            </p>
                            <p class="alert alert-success">Some text success or error</p>

                            <form role="form" action="validatePayment">
                                <div class="form-group">
                                    <label for="username">Full name (on the card)</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                        <input type="text" class="form-control" name="username" placeholder="" required="">
                                    </div> <!-- input-group.// -->
                                </div> <!-- form-group.// -->

                                <div class="form-group">
                                    <label for="cardNumber">Card number</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-credit-card"></i></span>
                                        </div>
                                        <input type="text" class="form-control" name="cardNumber" placeholder="">
                                    </div> <!-- input-group.// -->
                                </div> <!-- form-group.// -->

                                <div class="row">
                                    <div class="col-sm-8">
                                        <div class="form-group">
                                            <label><span class="hidden-xs">Expiration</span> </label>
                                            <div class="form-inline">
                                                <select class="form-control" style="width:45%">
                                                    <option>MM</option>
                                                    <option>01 - Janiary</option>
                                                    <option>02 - February</option>
                                                    <option>03 - February</option>
                                                </select>
                                                <span style="width:10%; text-align: center"> / </span>
                                                <select class="form-control" style="width:45%">
                                                    <option>YY</option>
                                                    <option>2018</option>
                                                    <option>2019</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label data-toggle="tooltip" title="" data-original-title="3 digits code on back side of the card">CVV <i class="fa fa-question-circle"></i></label>
                                            <input class="form-control" required="" type="text">
                                        </div> <!-- form-group.// -->
                                    </div>
                                </div> <!-- row.// -->
                                <button class="subscribe btn btn-primary btn-block" type="button" > Confirm  </button>
                            </form>
                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </aside> <!-- col.// -->

            </div> <!-- row.// -->

        </div> 
        <!--container end.//-->




        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <!-- If you're using Stripe for payments -->
        <!--<script type="text/javascript" src="https://js.stripe.com/v2/"></script>-->
        <script type="text/javascript" src="js/credit_card.js"></script>


    </body>
</html>
