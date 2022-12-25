/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.servletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SR
 */
public class ConfigDemo extends HttpServlet{

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        ServletConfig config = getServletConfig();
        String name1 = config.getInitParameter("name");
        String age1 = config.getInitParameter("age");
        String name = config.getServletName();
        out.print(name1);
        out.println("<br>");
        out.println("<br>");
        out.println(age1);
        out.println("<br>");
        out.println("<br>");
        out.println(name);
        
        
    }
    
}
