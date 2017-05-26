/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.uac.entityclass.Edge;
import org.uac.entityclass.Node;
import org.uac.session.EdgeFacadeLocal;
import org.uac.session.GraphFacadeLocal;
import org.uac.session.NodeFacadeLocal;


public class updateGraph extends HttpServlet {
    
    @EJB
    private GraphFacadeLocal GraphBean; 
    @EJB
    private NodeFacadeLocal NodeFacade;
    @EJB
    private EdgeFacadeLocal EdgeFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
           HttpSession session=request.getSession();
           String graphname = request.getParameter("graphname");
           String item = request.getParameter("item");
           String action = request.getParameter("action");
           String value = request.getParameter("value");
           String valueUpdate = request.getParameter("valueupdate");
           if(action.contains("add")){
               
               if(item.contains("node")){
                   Node node = new Node();
                   node.setGpname(graphname);
                   node.setNodeid(value);
                   NodeFacade.create(node);
               }else{
                   Edge edge = new Edge();
                   edge.setGrname(graphname);
                   edge.setEdgeid(value);
                   EdgeFacade.create(edge);
               }
               
           }
           if(action.contains("remove")){
               
               if(item.contains("node")){
                   Node node = new Node();
                   node.setGpname(graphname);
                   node.setNodeid(value);
                   NodeFacade.remove(node);
                   
               }else{
                   Edge edge = new Edge();
                   edge.setGrname(graphname);
                   edge.setEdgeid(value);
                   EdgeFacade.remove(edge);
               }
               
           }
            session.setAttribute("update", "Success");
            response.sendRedirect("editgraph.jsp");

        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    

}
