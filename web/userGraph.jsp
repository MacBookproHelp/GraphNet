

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/sigma.js/1.2.0/sigma.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-router-dom/4.1.1/react-router-dom.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.pjax/2.0.1/jquery.pjax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-bootstrap/0.5pre/assets/css/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-domPath/1.0.0/jquery.domPath.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html.js/0.12.1/HTML.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dom4/1.8.3/dom4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/blob-util/1.2.1/blob-util.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.3/FileSaver.min.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drag & Drop</title>
    </head>
    <body>
 <div id="container">

    <style>
    #container {

      width: 90%;
      height: 90%;
      background-color: #ffffff;
      position: absolute;
    }
    </style>
    <p style="font-size:18px; color:DarkCyan  ;">»To create nodes: double click on the canvas.</p>
    <p style="font-size:18px; color:DarkCyan ;">»To create edges: First click on the source node and then double click on the target node.</p>
 <p>
  <button id="save-btn">Save Graph
    <style>
    #save-btn{
    padding:5px 15px; 
    background:#ccc; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
    }
    </style>
  </button>
  <button id="del-btn">Delete Nodes/Edges
    <style>
        #del-btn{
            padding:5px 15px; 
            background:#ccc; 
            border:0 none;
            cursor:pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px; 
        }  
    </style>
  </button>
     
  <button id="alg-btn">Maximun degree algorithm
    <style>
        #alg-btn{
            padding:5px 15px; 
            background:#ccc; 
            border:0 none;
            cursor:pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px; 
        }
    </style>
  </button>  
  <button id="size-btn">Size of graph
    <style>
        #size-btn{
            padding:5px 15px; 
            background:#ccc; 
            border:0 none;
            cursor:pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px; 
        } 
    </style>
  </button>


 </p>

  <div id="container"></div>
</div>
    <script>
        var i=0,
            j=0,
            maxDegree = 0,
            src,
            des,
            sum=0,
            f = '',
            fs = '',
            st = '',
            st1 = '',
            s,
            g = {
              nodes: [],
              edges: []
            };

        s = new sigma({  
          renderer: {
            container: document.getElementById('container'),
            type: 'canvas'
          },
          settings: {
            doubleClickEnabled: false,
            maxNodeSize : 16,
            enableEdgeHovering: true,
            maxEdgeSize : 5,
          }
        });

          s.bind("doubleClickStage", function (){		  
                        s.graph.addNode({
                         id: 'Node' + i,
                         label: 'Node' + i,
                         x: Math.random(),
                         y: Math.random(),
                         size: 1,
                         color: '#666'
                                 });
            s.refresh();
            i++;
          });

          s.bind("clickNode", function (){ 
            s.bind("outNode", function (e){ 
            src = e.data.node.id; 
            })
            }) 
          s.bind("doubleClickNode", function (e2){ 
              des = e2.data.node.id;  
              if (src != des){ 
                       s.graph.addEdge({    
                          id: 'Edge' + j,
                          label: 'Edge' + j,
                          source: src,
                          target: des,
                          size: 2,
                          hover_color: '#0',            
                           }) 
                s.refresh();
                  j++;      
                scr= '';
                des = '';
               }  
           })
          $("#del-btn").click(function() { 
             alert('Delete node: right click on desired node and for' + '\r\n' + 'deleting edges: right click on desired edges');   
             s.bind("rightClickEdge", function (e4){ 
                s.graph.dropEdge(e4.data.edge.id);
                s.refresh(); 
             })
             s.bind("rightClickNode", function (e3){         
                s.graph.dropNode(e3.data.node.id);
                s.refresh(); 
             })
          });        

        
          $("#save-btn").click(function() {
            s.graph.edges().forEach(function(ed){  
                f =  f + ed.source + ' ' + ed.target + '\r\n';
            })
            var person = prompt("Please choose the name of file: ", "Graph");
            fs = 'name ' + person + '\r\n' + 'description graph_used_to_test' + '\r\n' + 'weighted false' + '\r\n' + f;
            var blob = new Blob([fs]);
            saveAs(blob, person+".graph");
          });
            $("#alg-btn").click(function() {
            s.graph.nodes().forEach(function(n){      
                maxDegree = Math.max(maxDegree, s.graph.degree(n.id));  
            })
            st = 'The maximum node degree of the graph is: ' + maxDegree;
            alert(st); 	
          });

          $("#size-btn").click(function() {
              sum = s.graph.edges().length + s.graph.nodes().length;
              st1 = 'The size of graph(number of edges + nodes) is: ' + sum ;
              alert(st1);    
                });
                

 </script>
    </body>
</html>
       
       

