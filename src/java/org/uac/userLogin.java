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
import javax.servlet.http.HttpSession;
import org.uac.session.UacuserFacadeLocal;


@WebServlet(name = "userLogin", urlPatterns = {"/userLogin"})
public class userLogin extends HttpServlet {
    
    @EJB
    private UacuserFacadeLocal uacuserBean;
    String username, password; 
    Boolean result;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       username=request.getParameter("username");
       password = request.getParameter("password");
       
       result = uacuserBean.verifyLogin(username, password);
        if(result){
            HttpSession session=request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("userLogin.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
