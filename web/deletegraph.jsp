<%-- 
    Document   : editgraph
    Created on : Apr 23, 2017, 2:33:54 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Graph</title>
        <%@include file="headers/graphHeader.jsp" %>
    </head>
    <body>
        <h1>Delete Graph Here </h1>
        <form class ="form-signin" action="deleteGraph" method="POST">
        <input type="text" class="form-control" placeholder="Enter your graph name" name="graphname">
        <br>
        <input type="submit" class="btn btn-success" value="Delete">
        </form>
        <br>
            <%
                    if(session.getAttribute("delete")=="Success"){
                    %>
                        <div class="alert alert-success" role="alert">Graph Deleted Successfully</div>
                        <%session.removeAttribute("delete");}
                %>
    </body>
</html>
