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

    <!-- Create Warehouse -->
    <h3>Add A Warehouse</h3>
    <form class="form-signin" method="POST" action="Controller.WarehouseRegulation">
        <p>Warehouse Name:</p>
        <input type="text" class="form-control" name="name_warehouse" value="String Required" required="" autofocus=""/>
        <br>
        <p>Address:</p>
        <input type="text" class="form-control" name="address" value="String Required" required="" autofocus=""/>
        <br>
        <p>Description:</p>
        <input type="text" class="form-control" name="description" value="String Required" required="" autofocus=""/>
        <br>
        <button class="btn btn-lg btn-primary btn-block btn-trans" name="submit_btn_wrhs" type="submit">Submit to Database</button>
        <br>
    </form>

    <h2>List of warehouses:</h2>
    <%=session.getAttribute("warehouseList")%>

</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>