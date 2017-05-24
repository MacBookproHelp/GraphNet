/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.uac.session.UacuserFacadeLocal;

/**
 *
 * @author Teja
 */
@WebServlet(name = "fbLogin", urlPatterns = {"/fbLogin"})
public class fbLogin extends HttpServlet {

    @EJB
    private UacuserFacadeLocal uacuserBean;
    String username, email, usertype; 
    Boolean result;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       username=request.getParameter("username");
       email = request.getParameter("useremail");
       
       result = uacuserBean.verifyFb(username, email);
        if(result){
            HttpSession session=request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("welcome.jsp");
        }else
        {   
            if(uacuserBean.registerUser(email, username, "user")){
                 HttpSession session=request.getSession();
                 session.setAttribute("user", username);
                 response.sendRedirect("welcome.jsp");
            }else{
                response.sendRedirect("welcome.jsp");
            }
           
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
