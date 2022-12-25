/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.browserCommunication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SR
 */
public class SunMicrosystem extends HttpServlet{
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           resp.setContentType("text/html");
           PrintWriter out = resp.getWriter();
           
           out.print("<html>");
           out.print("<head>");
           out.print("</head>");
           out.print("<body>");
           out.print("<h1>Java WebSite has shifted to new server</h1>");
           out.print("<a href ='http://localhost:8080/ServCommBrowser/opennewjava'>Click Here</a>");
           out.print("</body>");
           out.print("</html>");
           
               // 2 Request Redirection by setting headers method (setStatus() & setHeader())
//		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//		resp.setHeader("location", "http://localhost:8080/ServCommBrowser/opennewjava");
		
		// 3. Request Redirection by using sendRedirect() method of HttpServletResponse (Used)
		resp.sendRedirect("http://localhost:8091/ServletCommWithBrowser/opennewjava");
                
                //In second and 3rd way html coding is ignored and directly redirected to new given link
           //
    }
}
