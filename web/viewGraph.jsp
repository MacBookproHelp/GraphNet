<%-- 
    Document   : editgraph
    Created on : Apr 23, 2017, 2:33:54 PM
    Author     : Keerthana
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Graph</title>
        <%@include file="headers/graphHeader.jsp" %>
    </head>
    <body>
        <h1>View Graph Here </h1>
        <form class ="form-signin" action="viewGraph" method="POST">
        <input type="text" class="form-control" placeholder="Enter your graph name" name="graphname">
        <br>
        <input type="submit" class="btn btn-success" value="View Graph">
        </form>
              
        <br>
                        
            <%
                    if(session.getAttribute("graphFind")=="true"){
                       
                        
            %>
            Grpah is found
            
                        <c:forEach var="gp" items="${graphDetails}" >
                            ${gp}
                        </c:forEach>
                        
                        <%session.removeAttribute("graphFind");}
                        if(session.getAttribute("graphFind")=="false"){

                            %>
                        <div class="alert alert-success" role="alert">Graph is not found</div>
                        <%session.removeAttribute("graphFind");}                     
                        
                        
                %>
    </body>
</html>