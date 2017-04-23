<%-- 
    Document   : logout
    Created on : Apr 8, 2017, 7:55:00 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogOut</title>
        <%@include file="headers/header.jsp" %>
    </head>
    <body>
        <h1>See you soon again</h1>
        <%
            session.invalidate();
        %>
    </body>
</html>
