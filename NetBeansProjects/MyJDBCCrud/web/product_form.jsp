<%-- 
    Document   : product_form
    Created on : 16-May-2022, 6:28:13 am
    Author     : SR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Product</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Product </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Product</a></li>
                    </ul>
                </nav>
            </header>
                    
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${product != null}">
                            <form action="updateProduct" method="post">
                        </c:if>
                        <c:if test="${product == null}">
                            <form action="addProduct" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${product != null}">
                                    Edit Product
                                </c:if>
                                <c:if test="${product == null}">
                                    Add New Product
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${product != null}">
                            <input type="hidden" name="id" value="<c:out value='${product.p_id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Product ID</label> <input type="text" value="<c:out value='${prodct.p_id}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Name</label> <input type="text" value="<c:out value='${product.p_name}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Brand</label> <input type="text" value="<c:out value='${product.p_brand}' />" class="form-control" name="country">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>
