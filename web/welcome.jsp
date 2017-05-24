<%-- 
    Document   : welcome
    Created on : Apr 2, 2017, 10:00:55 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%              
              String userProf=(String)session.getAttribute("user");    
         %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <%@include file="headers/userheader.jsp" %>
    </head>
    <body>
        <h1>Welcome to GraphNet Application</h1>               
           
            <h2>Hello, Welcome <%=userProf%></h2>                           
    </body>
</html>
