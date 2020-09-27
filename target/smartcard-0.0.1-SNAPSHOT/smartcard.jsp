<%-- 
    Document   : smartcard
    Created on : 27 Sep. 2020, 4:58:10 pm
    Author     : Patty
--%>

<%@ page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="uts.asd.enumType.SmartCardType" %>


<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose your card</h1>



        <form action="addValue" method="POST">
            <!--            <c:forEach var="type" items="<%= uts.asd.enumType.SmartCardType.values() %>">
                            <input type="checkbox" name="smartcard" value="ON">
                            <span>${type}</span>
                            </input>
                            <br/>
            </c:forEach>                -->

            <table>
                <tr>
                    <td><input type="checkbox" name="youth" value="youth"/>Youth</td>
                </tr>
            </table>            
        </form>

    </body>
</html>
