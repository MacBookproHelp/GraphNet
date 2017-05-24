/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.uac.entityclass.Uacuser;
import org.uac.session.UacuserFacadeLocal;


@WebServlet(name = "registerUser", urlPatterns = {"/registerUser"})
public class registerUser extends HttpServlet {

   @EJB
   private UacuserFacadeLocal uacuserBean;
   String username,password,firstname,lastname,email,usertype;
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
       
       Uacuser u = new Uacuser();
       u.setFirstname(request.getParameter("firstname"));
       u.setLastname(request.getParameter("lastame"));
       u.setEmail(request.getParameter("regemail"));
       u.setUsername(request.getParameter("regusername"));
       u.setPassword(request.getParameter("regpassword"));
       u.setUsertype("user");
       uacuserBean.create(u);
       response.sendRedirect("userLogin.jsp");           
       }
          
     

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   

}
