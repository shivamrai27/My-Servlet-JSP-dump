/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReqObjDemo extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		Enumeration<String> headernames=req.getHeaderNames();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		
		while(headernames.hasMoreElements())
		{
			String headername=headernames.nextElement();
			String headervalue=req.getHeader(headername);
			out.println("<tr>");
			out.println("<td>"+headername+"</td>");
			out.println("<td>"+headervalue+"</td>");
			out.println("</tr>");
		}

		out.println("</body>");
		out.println("</html>");
    }
    
    
}
