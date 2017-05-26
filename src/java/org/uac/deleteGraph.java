/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.uac.entityclass.Edge;
import org.uac.entityclass.Graph;
import org.uac.entityclass.Node;
import org.uac.session.EdgeFacadeLocal;
import org.uac.session.GraphFacadeLocal;
import org.uac.session.NodeFacadeLocal;



public class deleteGraph extends HttpServlet {
    
    
    @EJB
    private GraphFacadeLocal GraphBean; 
    @EJB
    private NodeFacadeLocal NodeFacade;
    @EJB
    private EdgeFacadeLocal EdgeFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session=request.getSession();
           String user = request.getSession().getAttribute("user").toString();
           Graph grp = new Graph();
           
           String grpName = request.getParameter("graphname");
           grp.setGraphname(grpName);
           grp.setUsrname(user);
           
               NodeFacade.delNode(grpName);
               EdgeFacade.delEdge(grpName);
               GraphBean.remove(grp);
               session.setAttribute("delete", "Success");
               response.sendRedirect("deletegraph.jsp");
           
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
