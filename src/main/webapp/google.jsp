<%--
  Created by IntelliJ IDEA.
  User: daohuxia
  Date: 23/9/20
  Time: 6:18 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Travel Modes in Directions</title>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDp9lLPFW1nI38tEcp1gMHEPea50oNCxJQ&callback=initMap&libraries=&v=weekly"
            defer
    ></script>
    <style type="text/css">
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }

        /* Optional: Makes the sample page fill the window. */
        html,
        body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        #floating-panel {
            position: absolute;
            top: 10px;
            left: 25%;
            z-index: 5;
            background-color: #fff;
            padding: 5px;
            border: 1px solid #999;
            text-align: center;
            font-family: "Roboto", "sans-serif";
            line-height: 30px;
            padding-left: 10px;
        }



    </style>
    <%request.setCharacterEncoding("utf-8");
        String departure =request.getParameter("departure");
        String destination =request.getParameter("destination");%>

    <script>

        function logout(){
            alert("are you sure you want to search again?");
            window.location.href="tripPlanner.jsp"
        }



        "use strict";

        var departure = "<%=departure%>";
        var destination = "<%=destination%>";
var a =0;
var b=0;
var c=0;
var d=0;
        if(departure==="epping"){
            a=-33.777771;
            b=151.081349;
        }  if(departure==="mq"){
            a=-33.777199;
            b=151.124115;
        }
        if(departure==="carlinford")
        {a=-33.78269;
            b=151.04888;}
        if(departure==="eastwood")
        {a=-33.7904;
            b=151.0817;}





        if(destination==="epping"){
            c=-33.777771;
            d=151.081349;
        }  if(destination==="mq"){
            c=-33.777199;
            d=151.124115;
        }
            if(destination==="carlinford")
            {c=-33.78269;
                d=151.04888;}

        if(destination==="eastwood")
        {c=-33.7904;
            d=151.0817;}






        function initMap() {



            const directionsRenderer = new google.maps.DirectionsRenderer();
            const directionsService = new google.maps.DirectionsService();
            const map = new google.maps.Map(document.getElementById("map"), {
                zoom: 14,
                center: {
                    lat: -33.865143,
                    lng: 151.209900
                }
            });
            directionsRenderer.setMap(map);
            calculateAndDisplayRoute(directionsService, directionsRenderer);
            document.getElementById("mode").addEventListener("change", () => {
                calculateAndDisplayRoute(directionsService, directionsRenderer);
            });
        }

        function calculateAndDisplayRoute(directionsService, directionsRenderer) {
            const selectedMode = document.getElementById("mode").value;
            directionsService.route(
                {
                    origin: {
                        lat: a,
                        lng: b
                    },
                    destination: {
                        lat: c,
                        lng: d
                    },
                    // Note that Javascript allows us to access the constant
                    // using square brackets and a string value as its
                    // "property."
                    travelMode: google.maps.TravelMode[selectedMode]
                },
                (response, status) => {
                    if (status == "OK") {
                        directionsRenderer.setDirections(response);
                    } else {
                        window.alert("Directions request failed due to " + status);
                    }
                }
            );
        }

        function setValue(value){
            if (departure=="epping"&&destination=="mq"){
                var route="24 mins" +" "+ " "+ " "+"$6";
            }
            if (departure=="mq"&&destination=="epping"){
                var route="24 mins" +" "+ " "+ " "+"$6";
            }
            if (departure=="epping"&&destination=="carlinford"){
                var route="15 mins" +" "+ " "+ " "+"$2";
            }
            if (departure=="carlinford"&&destination=="epping"){
                var route="15 mins" +" "+ " "+ " "+"$2";
            }
            if (departure=="epping"&&destination=="eastwood"){
                var route="2 mins" +" "+ " "+ " "+"$2";
            }
            if (departure=="eastwood"&&destination=="epping"){
                var route="2 mins" +" "+ " "+ " "+"$2";
            }
            if (departure=="mq"&&destination=="carlinford"){
                var route="20 mins" +" "+ " "+ " "+"$3";
            }
            if (departure=="carlinford"&&destination=="mq"){
                var route="20 mins" +" "+ " "+ " "+"$3";
            }
            if (departure=="mq"&&destination=="eastwood"){
                var route="12 mins" +" "+ " "+ " "+"$2";
            }
            if (departure=="eastwood"&&destination=="mq"){
                var route="15 mins" +" "+ "Train 9"+ " "+"$4";
            }
            if (departure=="eastwood"&&destination=="carlinford"){
                var route="14 mins" +" "+ " "+ " "+"$5";
            }
            if (departure=="carlinford"&&destination=="eastwood"){
                var route="20 mins" +" "+ " "+ " "+"$6";
            }


            document.getElementById("test").value=route;

        }

    </script>
</head>
<body >



<div id="floating-panel">
    <b>Mode of Travel: </b>
    <select id="mode">
<%--        <option value="DRIVING">Driving</option>--%>
<%--        <option value="WALKING">Walking</option>--%>
<%--        <option value="BICYCLING">Bicycling</option>--%>
        <option value="TRANSIT">Transit</option>
    </select>
    <input name="" type="button" value="search again " onClick="javascript:logout()" />


    <input type="text" id="test"/>


    <input type="button" onclick="javascript:setValue('abc')" value="Route Details"/>

</div>



<div id="map"></div>
</body>
</html>