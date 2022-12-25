/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shivam.browserCommunication;

import com.sun.org.apache.xml.internal.utils.LocaleUtility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Servlet communication with browser through req resp object(used)
    resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name1");
        String email = req.getParameter("email1");
        String pass = req.getParameter("pass1");
        String gender = req.getParameter("gender1");
        String city = req.getParameter("city1");
        String [] lang = req.getParameterValues("lang1");
        if (city.equals("Select City")) {
        // 2. Servlet communication with browser through sendError() method
            resp.sendError(501,"Select any City");
        }
        else{
              out.println(name);
        out.println(email);
        out.println(pass);
        out.println(gender);
        for(int i=1; i<lang.length;i++){
        out.print(lang[i]);
        }
        out.println();
        out.print(city);    
        }
    }
    
}
