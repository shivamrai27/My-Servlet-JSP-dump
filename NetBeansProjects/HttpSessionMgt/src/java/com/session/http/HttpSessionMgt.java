/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.session.http;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author SR
 */
public class HttpSessionMgt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String email1 = req.getParameter("email");
        String pass1 = req.getParameter("pass");
        
        if(email1.equals("shivam@gmail.com")&&pass1.equals("shivam123"))
        {
           HttpSession session = req.getSession();
           //Get  the name of user from DB
           String name = "SHIVAM RAI";
           session.setAttribute("session_name", name);
           resp.sendRedirect("Profile");
            
        }
        else
        {
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("Login error");
            out.print("</body>");
            out.print("</html>");
        }
        
    }
    
    
}
