<%-- 
    Document   : facebookwelcome
    Created on : Apr 16, 2017, 2:00:00 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <%@include file="headers/userheader.jsp" %>
    </head>
    <body>
         <%              
              String userProf=(String)session.getAttribute("user");    
         %>     
        <h1>Welcome to GraphNet Application</h1>               
        
            <h2>Hello, Welcome <%=userProf%></h2>
                               
    </body>
</html>