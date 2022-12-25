<%-- 
    Document   : product_list
    Created on : 16-May-2022, 6:28:01 am
    Author     : SR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Products</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Products </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Product</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
               

                <div class="container">
                    <h3 class="text-center">List of Products</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Product</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>P_ID</th>
                                <th>P_Name</th>
                                <th>P_Brand</th>

                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="product" items="${ProductList}">

                                <tr>
                                    <td>
                                        <c:out value="${prodcut.p_id}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.p_name}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.p_brand}" />
                                    </td>
                                    
                                    <td><a href="edit?id=<c:out value='${product.p_id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='$product.p_id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                      
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>
