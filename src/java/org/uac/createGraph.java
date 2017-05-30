/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.uac.entityclass.Edge;
import org.uac.entityclass.Graph;
import org.uac.entityclass.Node;
import org.uac.entityclass.Uacuser;
import org.uac.session.EdgeFacadeLocal;
import org.uac.session.GraphFacadeLocal;
import org.uac.session.NodeFacadeLocal;
import org.uac.session.PropFacadeLocal;

public class createGraph extends HttpServlet {
    
    @EJB
    private GraphFacadeLocal GraphBean;
    @EJB
    private NodeFacadeLocal NodeFacade;
    @EJB
    private EdgeFacadeLocal EdgeFacade;
    
    HashMap hm = new HashMap();
    List<String> nodeArry=new ArrayList<>();
    List<String> edgeArry=new ArrayList<>();
    int lineCount;
    String leftnode;
    String rightnode;
    String edge;
    Boolean result;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session=request.getSession();
        Node nodebean = new Node();
        Edge edgebean = new Edge();
        String user = request.getSession().getAttribute("user").toString();
        System.out.println("The user name of the profle is "+user);
        Part filePart = request.getPart("graphfile");
        InputStream fileContent = filePart.getInputStream();
        Scanner s = new Scanner(fileContent).useDelimiter("\n");
       
        while(s.hasNext()){
            String dat = s.next();
            System.out.println(dat);            
            hm.put(dat.split(" ")[0],dat.split(" ")[1]);
            nodeArry.add(dat.split(" ")[0]);
            edgeArry.add(dat.split(" ")[1]);                       
        }
        
        //Graph grp = new Graph();
        String nodesize = Integer.toString(nodeArry.size()-3);
        String edgesize = Integer.toString(edgeArry.size()-3);
        String gsize = Integer.toString(nodeArry.size()-3 + edgeArry.size()-3);
        System.out.println("the sizes are  "+nodesize +"; "+edgesize+";"+gsize);   
        try{
        if(hm.get("weighted").toString().contains("true")){            
           session.setAttribute("weighted", "true");            
           response.sendRedirect("creategraph.jsp");
        }else{
            
            for(int i=3;i<nodeArry.size();){
              leftnode=nodeArry.get(i);
              edge = edgeArry.get(i);
              System.out.println("letnode is "+leftnode);
              System.out.println("edge is "+edge);
              nodebean.setNodeid(leftnode);
              nodebean.setGpname(hm.get("name").toString());
              edgebean.setEdgeid(edge);
              edgebean.setGrname(hm.get("name").toString());
              EdgeFacade.create(edgebean);
              NodeFacade.create(nodebean);
              i++;
           }
        }}catch(Exception e){ 
              System.out.println("Exception in saving grpah is "+e.toString());
              response.sendRedirect("creategraph.jsp"); 
         }
            result = GraphBean.addGraph(hm.get("name").toString(), hm.get("description").toString(), nodesize, edgesize, gsize, hm.get("weighted").toString(), user);
            //result = true; 
            if(result=true){
                session.setAttribute("save", "Success");
                response.sendRedirect("creategraph.jsp");
            }else{
               response.sendRedirect("creategraph.jsp"); 
            }
           
            
       
        }
        
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
