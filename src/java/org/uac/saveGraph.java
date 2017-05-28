/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.uac.entityclass.Graph;
import org.uac.entityclass.Node;
import org.uac.session.EdgeFacadeLocal;
import org.uac.session.GraphFacadeLocal;
import org.uac.session.NodeFacadeLocal;


public class saveGraph extends HttpServlet {
    
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
        
        Graph grp = GraphBean.find(graphname);
        String mycontent="name " + grp.getGraphname();
        
        String realContextPath = request.getSession().getServletContext().getRealPath("/WEB-INF/graphfiles/");
        String filename = realContextPath+"\\"+graphname+".txt";
        System.out.println("file path is " + filename);
        try{
        File outputFile = new File(filename);
        outputFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(outputFile,true);
        
        byte[] bytesArray = mycontent.getBytes();
	fos.write(bytesArray);
	fos.flush();
        fos.close();
        }
        catch(Exception e){
            System.out.println("file exception"+e);
        }
	System.out.println("File Written Successfully");

//
////System.out.println("the path for file creation is "+request.getServletContext().getRealPath("/graphfiles"));
//        System.out.println("file path is " + realContextPath);
//        //File outputFile = new File(request.getServletContext().getRealPath("/graphfiles")+graphname+".graph");
//        File outputFile = new File(realContextPath);
//        outputFile.createNewFile();        
//        FileWriter fout = new FileWriter(outputFile, true);
//        fout.write("name " + grp.getGraphname());
//        System.out.println(grp.getDescription());
//        fout.write("description " + grp.getDescription());
//        fout.flush();
        
        session.setAttribute("file", filename);
        response.sendRedirect("download.jsp");        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   

}
