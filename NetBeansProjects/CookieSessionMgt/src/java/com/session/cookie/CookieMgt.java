/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.session.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SR
 */
public class CookieMgt extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String email1 = req.getParameter("email");
        String pass1 = req.getParameter("pass");
        String remember2 = req.getParameter("selected");
        
        if(email1.equals("shivam@gmail.com")&&pass1.equals("shivam123")){
            if(compare(remember2, "selected")){
            Cookie ck1 = new Cookie("username", email1);
            ck1.setMaxAge(60*60*24*365);
            resp.addCookie(ck1);
            
            Cookie ck2 = new Cookie("status", "true");
            ck1.setMaxAge(60*60*24*365);
            resp.addCookie(ck2);
            }
             resp.sendRedirect("Profile");
        }else{
        out.print("Id or password didnt matched");
            RequestDispatcher rd = req.getRequestDispatcher("Login.html");
            rd.include(req, resp);
        }
        
    }
    public static boolean compare(String str1, String str2){
    return (str1==null ? str2==null : str1.equals(str2));
    }
    
}
