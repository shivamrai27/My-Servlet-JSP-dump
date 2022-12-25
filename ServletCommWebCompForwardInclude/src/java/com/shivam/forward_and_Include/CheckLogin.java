/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.forward_and_Include;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SR
 */
public class CheckLogin extends HttpServlet{

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        
        String email = req.getParameter("email1");
        String pass = req.getParameter("pass1");
        
        if(email.equals("shivam@gmail.com")&& pass.equals("shivam123")){
            RequestDispatcher rd = req.getRequestDispatcher("Profile.html");
            rd.forward(req, resp);
        }else{
        RequestDispatcher rd = req.getRequestDispatcher("ErrorMsg.html");
        rd.include(req, resp);
        
        RequestDispatcher rd2 = req.getRequestDispatcher("Loging.html");
        rd2.include(req, resp);
    
        }
        
    }
}
