/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.uac.entityclass.Graph;
import org.uac.session.EdgeFacadeLocal;
import org.uac.session.GraphFacadeLocal;
import org.uac.session.NodeFacadeLocal;


public class viewGraph extends HttpServlet {

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
        String grpName = request.getParameter("graphname");
        List<String> grpvalues = new ArrayList<String>();
        //String graphDetails = GraphBean.getGraph(user, grpName);
        List<Graph> graphDetails = GraphBean.getUsergraphs(user, grpName);
        
        Iterator itr = graphDetails.iterator();
        while(itr.hasNext()) {
            Object[] arrObj = (Object[])itr.next();
            for(Object obj:arrObj) {
                grpvalues.add(String.valueOf(obj));
            }
        }
        //System.out.println("the grpahname is.......... "+grpvalues.get(0));
       // response.sendRedirect("viewGraph.jsp");
        
       if(grpvalues.isEmpty()){
            session.setAttribute("graphFind", "false");
            response.sendRedirect("viewGraph.jsp");
       }else{
            session.setAttribute("graphFind", "true");
           // session.setAttribute("graphDetails", grpvalues);
            request.setAttribute("graphDetails", grpvalues); 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewGraph.jsp");
            rd.forward(request, response);
            
        }
        
       
        
    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
