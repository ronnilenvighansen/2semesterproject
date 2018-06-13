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
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/inventory.jsp">Inventory Status</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/addAdmin.jsp">Add New Admin Account</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/addProduct.jsp">Add New Product</a>
                    </li>
                    <li class="active">
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
    <div class="container-fluid" id="content">
        <h3>Get product by ID</h3>
        <form class="form-signin" method="POST" action="Controller.ContentAdmin">
            <p>Enter Produt ID:</p>
            <input type="text" class="form-control" name="idforEdit" value="Integer Required" required="" autofocus=""/>
            <br>
            <button class="btn btn-lg btn-primary btn-block btn-trans" name="submit_btn_getID" type="submit">Submit ID</button>
            <br>
            <br>
        </form>

        <!-- Edit Product -->
        <h3>Edit Product:</h3>
        <form class="form-signin" method="POST" action="Controller.ContentAdmin">
            <p>Product name:</p>
            <input type="text" class="form-control" name="product_name" value="Product name" required="" autofocus=""/>
            <br>
            <p>Color:</p>
            <input type="text" class="form-control" name="color" value="Color" required="" autofocus=""/>
            <br>
            <p>Grape:</p>
            <input type="text" class="form-control" name="grape" value="Grape" required=""/>
            <br>
            <p>Country of Origin:</p>
            <input type="text" class="form-control" name="origin_country" value="Country of Origin" required="" autofocus=""/>
            <br>
            <p>Area of Origin:</p>
            <input type="text" class="form-control" name="origin_area" value="Area of Origin" required="" autofocus=""/>
            <br>
            <p>Description:</p>
            <input type="text" class="form-control" name="description" value="Description" required="" autofocus=""/>
            <br>
            <p>Production Year:</p>
            <input type="text" class="form-control" name="production_year" value="Production Year" required="" autofocus=""/>
            <br>
            <p>Production Date:</p>
            <input type="text" class="form-control" name="production_date" value="Production Date" required="" autofocus=""/>
            <br>
            <p>Quantity:</p>
            <input type="text" class="form-control" name="quantity" value="Quantity" required="" autofocus=""/>
            <br>
            <p>Location:</p>
            <input type="text" class="form-control" name="location" value="Location" required="" autofocus=""/>
            <br>
            <p>Price:</p>
            <input type="text" class="form-control" name="price" value="Price" required="" autofocus=""/>
            <br>
            <p>Volume:</p>
            <input type="text" class="form-control" name="volume" value="Volume" required="" autofocus=""/>
            <br>
            <p>Sparkly:</p>
            <input type="text" class="form-control" name="sparkly" value="Sparkly" required="" autofocus=""/>
            <br>
            <p>For Sale:</p>
            <input type="text" class="form-control" name="for_sale" value="For Sale" required="" autofocus=""/>
            <br>
            <p>Date Added:</p>
            <input type="text" class="form-control" name="date_added" value="Date Added" required="" autofocus=""/>
            <br>
            <button class="btn btn-lg btn-primary btn-block btn-trans" name="submit_btn_edit" type="submit">Submit to Database</button>
            <br>
            <br>
        </form>

        <%-- Outcommented because of error with JSTL --%>
        <%--<form class="form-signin" method="POST" action="Controller.ContentAdmin">--%>
        <%--<%=session.getAttribute("product")%>--%>
            <%--<p>Product name:</p>--%>
            <%--<input type="text" class="form-control" name="product_name" value="${product.product_name}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Color:</p>--%>
            <%--<input type="text" class="form-control" name="color" value="${product.color}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Grape:</p>--%>
            <%--<input type="text" class="form-control" name="grape" value="${product.grape}" required=""/>--%>
            <%--<br>--%>
            <%--<p>Country of Origin:</p>--%>
            <%--<input type="text" class="form-control" name="origin_country" value="${product.origin_country}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Area of Origin:</p>--%>
            <%--<input type="text" class="form-control" name="origin_area" value="${product.origin_area}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Description:</p>--%>
            <%--<input type="text" class="form-control" name="description" value="${product.description}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Production Year:</p>--%>
            <%--<input type="text" class="form-control" name="production_year" value="${product.production_year}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Production Date:</p>--%>
            <%--<input type="text" class="form-control" name="production_date" value="${product.production_date}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Quantity:</p>--%>
            <%--<input type="text" class="form-control" name="quantity" value="${product.quantity}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Location:</p>--%>
            <%--<input type="text" class="form-control" name="location" value="${product.location}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Price:</p>--%>
            <%--<input type="text" class="form-control" name="price" value="${product.price}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Volume:</p>--%>
            <%--<input type="text" class="form-control" name="volume" value="${product.volume}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Sparkly:</p>--%>
            <%--<input type="text" class="form-control" name="sparkly" value="${product.sparkly}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>For Sale:</p>--%>
            <%--<input type="text" class="form-control" name="for_sale" value="${product.for_sale}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<p>Date Added:</p>--%>
            <%--<input type="text" class="form-control" name="date_added" value="${product.date_added}" required="" autofocus=""/>--%>
            <%--<br>--%>
            <%--<button class="btn btn-lg btn-primary btn-block btn-trans" name="submit_btn_edit" type="submit">Submit to Database</button>--%>
            <%--<br>--%>
            <%--<br>--%>
        <%--</form>--%>

    </div>
</div>

<%=session.getAttribute("productList")%>
<%@include file="includes/footer.jsp"%>
</body>
</html>

