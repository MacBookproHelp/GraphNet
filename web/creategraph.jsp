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
            <form action="createGraph" method="POST" enctype="multipart/form-data">
                <div class="form-group col-md-4">
                  
                </div>
                <div class="form-group">
                  <label for="exampleInputFile">File input</label>
                  <input type="file" id="graphFile" name="graphfile">
                </div>  
                <%
                    if(session.getAttribute("weighted")=="true"){
                         
                        %>
                            <div class="alert alert-danger" role="alert">Please upload both graph and prop files </div>
                            <div class="form-group">                      
                            <label for="exampleInputFile">File input</label>
                            <input type="file" id="graphFile" name="propfile">
                            </div>
                
                        <%
                        session.removeAttribute("weighted");
                    }
                %>  
                
                
                <button type="submit" class="btn btn-primary col-md-4">Submit</button>
              </form>
                
            </div>
                <%
                    if(session.getAttribute("save")=="Success"){
                    %>
                        <div class="alert alert-success" role="alert">Graph Save Successfully</div>
                    <%}
                %>
         </div>
       </div>
    </body>
</html>
