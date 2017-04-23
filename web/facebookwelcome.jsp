<%-- 
    Document   : facebookwelcome
    Created on : Apr 16, 2017, 2:00:00 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="floginBean" scope="session" class="org.uac.login" />
    <jsp:setProperty name="floginBean" property="username" />
    <jsp:setProperty name="floginBean" property="useremail" />
    
        <%
          int a = floginBean.faceverify();
          if(a==1){
              session.setAttribute("user",floginBean.getUsername());
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
            <% }
            else{ %>
            <h2>Wrong Username or Password, Please try again </h2>
            <%}            
        %>                        
    </body>
</html>