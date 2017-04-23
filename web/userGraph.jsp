<%-- 
    Document   : userGraph
    Created on : Apr 22, 2017, 1:09:24 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Graphs</title>
         <%@include file="headers/graphHeader.jsp" %>
         <%@include file="sigmasrc.jsp" %>
    </head>
    <body>
        <table align="center">
            <tr align="center">
                <td><h2>View Graph</h2></td>
                
            </tr> 
            <tr></tr>
            <tr align="center"><td><button type="button" class="btn btn-success">Save Graph</button></td></tr>
        </table>
             
        
        <div id="container">
            <style>
              #graph-container {
                top: 30%;
                bottom: 5%;
                left: 5%;
                right: 5%;
                position: absolute;
                background: #9EB9D4
              }
            </style>
            <div id="graph-container"></div>
          </div>
          <script>
          /**
           * This is a basic example on how to instantiate sigma. A random graph is
           * generated and stored in the "graph" variable, and then sigma is instantiated
           * directly with the graph.
           *
           * The simple instance of sigma is enough to make it render the graph on the on
           * the screen, since the graph is given directly to the constructor.
           */
          var i,
              s,
              N = 20,
              E = 40,
              g = {
                nodes: [],
                edges: []
              };

          // Generate a random graph:
          for (i = 0; i < N; i++)
            g.nodes.push({
              id: 'n' + i,
              label: 'Node ' + i,
              x: Math.random(),
              y: Math.random(),
              size: Math.random(),
              color: '#FF5733'
            });

          for (i = 0; i < E; i++)
            g.edges.push({
              id: 'e' + i,
              source: 'n' + (Math.random() * N | 0),
              target: 'n' + (Math.random() * N | 0),
              size: Math.random(),
              color: ' #00FF7F'
            });

          // Instantiate sigma:
          s = new sigma({
            graph: g,
            container: 'graph-container'
          });
       </script>
       
       
              
     </body>
</html>
