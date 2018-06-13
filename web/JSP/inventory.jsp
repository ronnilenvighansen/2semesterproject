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
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/admin.jsp">Browse Items</a>
                    </li>
                    <li class="active">
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
                        <a href="${pageContext.request.contextPath}/JSP/edit.jsp">Edit Product</a>
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
    <div class="container-fluid" id="content3">
        <div class="row">
            <div class="col-md-1">
                <p class="bold">Product id</p>
            </div>
            <div class="col-md-1">
                <p class="bold">Product name</p>
            </div>
            <div class="col-md-2">
                <p class="bold">Product description</p>
            </div>
            <div class="col-md-2">
                <p class="bold">In stock in warehouse 1</p>
            </div>
            <div class="col-md-2">
                <p class="bold">In stock in warehouse 2</p>
            </div>
            <div class="col-md-2">
                <p class="bold">In stock in warehouse 3</p>
            </div>
            <div class="col-md-1">
                <p class="bold">Origin Country</p>
            </div>
            <div class="col-md-1">
                <p class="bold">Price</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-1">
                <p>01</p>
            </div>
            <div class="col-md-1">
                <p>Wine nr 1</p>
            </div>
            <div class="col-md-2">
                <p>Description</p>
            </div>
            <div class="col-md-2">
                <p>4</p>
            </div>
            <div class="col-md-2">
                <p>15</p>
            </div>
            <div class="col-md-2">
                <p>0</p>
            </div>
            <div class="col-md-1">
                <p>Some country</p>
            </div>
            <div class="col-md-1">
                <p>150.00 kr</p>
            </div>
        </div>


        <div class="row">
            <div class="col-md-1">
                <p>02</p>
            </div>
            <div class="col-md-1">
                <p>Wine nr 02</p>
            </div>
            <div class="col-md-2">
                <p>Description</p>
            </div>
            <div class="col-md-2">
                <p>10</p>
            </div>
            <div class="col-md-2">
                <p>7</p>
            </div>
            <div class="col-md-2">
                <p>5</p>
            </div>
            <div class="col-md-1">
                <p>Country</p>
            </div>
            <div class="col-md-1">
                <p>2050.00 kr</p>
            </div>
        </div>

    </div>
</div>


<!-- Modal -->
<div id="logoutAdmin" class="modal fade" role="dialog">
    <%@include file="includes/confirmLogoutAdmin.jsp"%>
</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>

