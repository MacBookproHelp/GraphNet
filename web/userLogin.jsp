<%-- 
    Document   : userLogin.jsp
    Created on : Apr 8, 2017, 3:15:09 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Login to GraphNet</title>
        <%@include file="headers/header.jsp" %>
    </head>
    <body>
       <%
        String userPrfl=(String)session.getAttribute("user");
        
        //redirect user to home page if already logged in
        if(userPrfl!=null){
            response.sendRedirect("welcome.jsp");
        }
        %>
       <div class="container" align="center">
       
        <form class="form-signin" action="welcome.jsp" method="POST">
            <h2 class="form-signin-heading">Please Login Here</h2>
            <label class="sr-only" for="inputEmail">Username</label>
            <input type="text" name="username" class="form-control" placeholder="Enter Username" />
            <br>
            <label class="sr-only" for="inputPassword">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Enter Password" />
            <button type="submit" class="btn btn-primary"/>Login</button>                         
        </form>
       </div>
    </body>
    
</html>
