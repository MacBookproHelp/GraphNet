<%-- 
    Document   : registerConfirm
    Created on : Apr 5, 2017, 9:32:35 PM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Confirmation</title>
        <%@include file="headers/userheader.jsp" %>
    </head>
    
    
    <body>
        <jsp:useBean id="regbean" scope="session" class="org.uac.register" />
        <jsp:setProperty name="regbean" property="regusername" />
        <jsp:setProperty name="regbean" property="regemail" />
        <jsp:setProperty name="regbean" property="regpassword" />
        
        <%
          int a = regbean.registerUser();
          if(a==1){
         %>
            <h1>Congratulations you are registered to Graph Net</h1>
            <% }
            else{ %>
            <h2>Wrong Username or Password, Please register again </h2>
            <%}            
        %>
        
    </body>
</html>
