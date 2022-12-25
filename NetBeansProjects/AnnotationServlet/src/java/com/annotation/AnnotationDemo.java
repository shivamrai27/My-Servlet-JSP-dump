/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SR
 */

//@WebServlet("/demo1")                                        //way 1
//@WebServlet(value="/demo2")                                 //way 2
//@WebServlet(urlPatterns = {"/demo3", "/demo4", "/demo4"})  // way 3

//@WebServlet(
//            name = "Way4",
//            urlPatterns = {"/demo5","/demo6","/demo7"},
//            loadOnStartup = 1
//            )



@WebServlet(
            name = "Providing Config Object",
            urlPatterns = {"/demo5","/demo6","/demo7"},
            loadOnStartup = 1,
            
            initParams = {
                @WebInitParam(name = "Naam", value = "Shivam"),
                @WebInitParam(name = "Email", value = "2000shivamrai@gamil.com"),
                @WebInitParam(name = "Age", value = "22"),
            }
            
            )

public class AnnotationDemo extends HttpServlet{

    @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        out.println("Hello, This is the demo of servlet config through annotation");
        out.print("<br><br>");
        out.print("Name : "+config.getInitParameter("Naam"));
        out.print("<br><br>");
        out.print("Email : "+config.getInitParameter("Email"));
        out.print("<br><br>");
        out.print("Age : "+config.getInitParameter("Age"));
    }

}
