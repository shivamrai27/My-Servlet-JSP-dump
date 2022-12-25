/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.url.rewriting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SR
 */
public class UrlRewriting extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        HttpSession session =req.getSession();
        String newUrl = resp.encodeURL("");
         
        out.print(newUrl+"<br><br>");
        out.print("First Sevlet <br><br>");
        String sec ="second";
        out.print("<a href ='"+sec+""+newUrl+"'>Clic here to go to second Servlet</a>");
        
        
    }
    
}
