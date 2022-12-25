
package com.mindmill.product.controller;


import com.mindmill.product.Dao.ProductDao;
import com.mindmill.product.bean.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/")
public class productServlet extends HttpServlet {
ProductDao productDao;
    public productServlet() {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
       this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String operation = req.getServletPath();
       switch(operation){
       case"/first":
           firstWindow(req, resp);
           break;
           case "/addProduct":
               addProduct(req, resp);
           break;
           case"/updateProduct":
           {
               try {
                   updateProduct(req, resp);
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
           break;

           case"/deleteProduct":
           {
               try {
                   deleteProduct(req, resp);
               } catch (SQLException ex) {
               }
           }
           break;

           case "/productList":
           {
               try {
                   Productlist(req, resp);
               } catch (SQLException ex) {
               }
           }
           break;

           default:
           break;
       }
    }
    
    void firstWindow(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
    RequestDispatcher rd = req.getRequestDispatcher("product_form.jsp");
    rd.forward(req, resp);
    }
    
    void addProduct(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
    
    int p_id = Integer.parseInt(req.getParameter("p_id"));
    String productName = req.getParameter("p_name");
    String productBrand = req.getParameter("p_brand");
    
    Product addProduct = new Product(p_id,productName,productBrand);
    productDao.addProduct(addProduct);
    resp.sendRedirect("list");
    } 
    void Productlist(HttpServletRequest req, HttpServletResponse resp)throws SQLException, IOException, ServletException {
        List <Product > ProductList = productDao.showProduct();
        req.setAttribute("productList", ProductList);
        RequestDispatcher rd = req.getRequestDispatcher("product_list.jsp");
        rd.forward(req, resp);
    }
    void updateProduct(HttpServletRequest req, HttpServletResponse resp)throws SQLException, IOException {
    int p_id = Integer.parseInt(req.getParameter("p_id"));
        String p_name = req.getParameter("p_name");
        String p_brand = req.getParameter("p_brand");
        Product prodcut = new Product(p_id,  p_name, p_brand);
        productDao.updateProduct(prodcut);
        resp.sendRedirect("list");
    }
    void deleteProduct(HttpServletRequest req, HttpServletResponse resp)throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("p_id"));
        productDao.deleteProduct(id);
        resp.sendRedirect("list");

    }
    


}