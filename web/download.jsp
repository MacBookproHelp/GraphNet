
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Graph</title>
        <%@include file="headers/graphHeader.jsp" %>
    </head>
    <body>
        <h1>Download Graph Here </h1>
        <form class ="form-signin" action="saveGraph" method="POST">
        <input type="text" class="form-control" placeholder="Enter your graph name" name="graphname">
        <br>
        <input type="submit" class="btn btn-success" value="Download">
        </form>
        <br>
            <%
                    if(session.getAttribute("file")!= null){
                        String path = session.getAttribute("file").toString();
                        System.out.println(path);
                    %>  
                    <a href="${path}" />Download here</a>
                        <%session.removeAttribute("file");}
                %>
    </body>
</html>
