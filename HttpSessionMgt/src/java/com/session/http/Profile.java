/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.session.http;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author SR
 */
public class Profile extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("session_name");
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("WELCOM - "+name);
            out.print("<br><br>");
            out.print("<a href='Logout'>Logout</a>");
            out.print("</body>");
            out.print("</html>");
    }
    
}
