<%-- 
    Document   : welcome
    Created on : Apr 2, 2017, 10:00:55 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <%@include file="userheader.jsp" %>
    </head>
    <body>
        <h1>Welcome to GraphNet Application</h1>
        
        <jsp:useBean id="loginBean" scope="session" class="org.uac.login" />
        <jsp:setProperty name="loginBean" property="username" />
        <jsp:setProperty name="loginBean" property="password" />
        
        <%
          int a = loginBean.verify();
          if(a==1){
              session.setAttribute("user",loginBean.getUsername());
              String userProf=(String)session.getAttribute("user");
         %>
            <h1>Hello, Welcome <%=userProf%></h1>
            <% }
            else{ %>
            <h2>Wrong Username or Password, Please try again </h2>
            <%}            
        %>
       
                         
    </body>
</html>
