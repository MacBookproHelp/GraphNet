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
        <title>Edit Graph</title>
        <%@include file="headers/graphHeader.jsp" %>
    </head>
    <body>
        <h1>Edit your graph here</h1>
        <form class ="form-signin" action="updateGraph" method="POST">
        <input type="text" class="form-control" placeholder="Enter your graph name" name="graphname">
        <br>     
        <select name="item">
            <option value="node">NODE</option>
            <option value="edge">EDGE</option>          
        </select>
        <select name="action">
            <option value="add">ADD</option>
            <option value="remove">REMOVE</option>
            <option value="update">MODIFY</option>            
        </select>  
        <br><br>
        <input type="text" class="form-control" placeholder="Enter Node/Edge id" name="value">
        <br>
        <input type="submit" class="btn btn-primary" value="Update">
        </form> 
        <br>
            <%
                    if(session.getAttribute("update")=="Success"){
                    %>
                        <div class="alert alert-success" role="alert">Graph Updated Successfully</div>
                        <% session.removeAttribute("update");}
                %>
    </body>
</html>
