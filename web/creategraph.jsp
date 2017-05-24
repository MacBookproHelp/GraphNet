<%-- 
    Document   : creategraph
    Created on : Apr 23, 2017, 2:32:48 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Graph Page</title>
        <%@include file="headers/graphHeader.jsp" %>
    </head>
    <body>
        <h1>Create your Graph here by uploading .grpah file </h1>
        <div class="row">
          <div class="col-md-8" >
            <div class="jumbotron">
            <form action="creategraph.jsp" method="POST">
                <div class="form-group col-md-4">
                  <label for="graphname">Grpah Name</label>
                  <input type="graphname" class="form-control" id="graphname" placeholder="GraphName">
                </div>
                <div class="form-group">
                  <label for="exampleInputFile">File input</label>
                  <input type="file" id="exampleInputFile">
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox"> Waited Graph (select check box if grpah is waited)
                  </label>
                </div>
                <button type="submit" class="btn btn-primary col-md-4">Submit</button>
              </form>
            </div>
         </div>
       </div>
    </body>
</html>
