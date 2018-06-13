<%@ page import="Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- All reference links are located in the header file -->
    <%@include file="includes/header.jsp"%>
</head>
<body>

<div class="container">
    <!-- Header -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/JSP/admin.jsp">Browse Items</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/inventory.jsp">Inventory Status</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/addAdmin.jsp">Add New Admin Account</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/addProduct.jsp">Add New Product</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/addWarehouse.jsp">Add New Warehouse</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/edit.jsp">Edit New Product</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" data-toggle="modal" data-target="#logoutAdmin" data-backdrop="static"
                           data-keyboard="false"><i class="fa fa-user fa-fw"></i>Log out</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Display content -->
    <div class="container-fluid" id="content2">

    <!-- Display all products in a list, editable in Product.java class -->


        <%--<%=session.getAttribute("productList") %>--%>
        <!-- Outcommented due to errors with JSTL/EL-->
        <%--<jsp:useBean id="productList" scope="session" type="java.util.List"/>--%>
        <%--<c:forEach items="${productList}" var="Product">--%>
            <%--<div class="row row-control">--%>
                <%--<div>--%>
                    <%--<img class="col-md-2">--%>
                    <%--<br><br>--%>
                    <%--<img src="img/test.png" class="img-thumbnail" alt="img" width="80%" height="70%"/>--%>
                <%--</div>--%>

                <%--<div class="col-md-4">--%>
                    <%--<h3><c:out value="${Product.name_product}"/></h3>--%>
                    <%--<p><c:out value="${Product.description}"/></p>--%>
                <%--</div>--%>

                <%--<div class="col-md-1">--%>
                    <%--<br><br><br>--%>
                    <%--<p><c:out value="${Product.price}"/></p>--%>
                    <%--<p><c:out value="${Product.color}"/></p>--%>
                    <%--<p><c:out value="${Product.grape}"/></p>--%>
                    <%--<p><c:out value="${Product.quantity}"/></p>--%>
                    <%--<p><c:out value="${Product.location}"/></p>--%>
                <%--</div>--%>

                <%--<div class="col-md-2">--%>
                    <%--<br><br><br>--%>
                    <%--<input type="text" name="FirstName" placeholder="1" value="1"/>--%>
                <%--</div>--%>

                <%--<div class="col-md-2">--%>
                    <%--<br><br><br>--%>
                    <%--<a href="#">Add to cart</a>--%>
                <%--</div>--%>
                <%--<!-- Button rows -->--%>
                <%--<div class="row">--%>
                    <%--<div class="col-md-4"></div>--%>
                    <%--<div class="col-md-6">--%>
                        <%--<a href="${pageContext.request.contextPath}/JSP/edit.jsp" class="btn btn-succes" input type="submit" name="edit" value="edit"><i class="fa fa-pencil-square-o fa-lg"></i></a>--%>
                        <%--<a href="${pageContext.request.contextPath}/JSP/edit.jsp" class="btn btn-danger" input type="submit" name="delete" value="delete"><i class="fa fa-trash-o fa-lg"></i></a>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>


        <!-- First row -->
        <h2>List of products:</h2>
        <%=session.getAttribute("productList") %>

        <!-- Button rows -->
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-6">
                <a href="${pageContext.request.contextPath}/JSP/edit.jsp" class="btn btn-succes" input type="submit"><i class="fa fa-pencil-square-o fa-lg"></i></a>
                <a href="#" class="btn btn-danger" input type="submit" name="delete" value="delete"><i class="fa fa-trash-o fa-lg"></i></a>
            </div>
        </div>

        <br><br><br>
    </div>

</div>


<!-- Modal -->
<div id="logoutAdmin" class="modal fade" role="dialog">
    <%@include file="includes/confirmLogoutAdmin.jsp"%>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>
