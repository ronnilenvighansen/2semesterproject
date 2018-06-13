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
                        <a href="#">Back to browsing</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" data-toggle="modal" data-target="#logoutAdmin" data-backdrop="static"
                           data-keyboard="false"><i class="fa fa-user fa-fw"></i>Log out</a>
                        <!-- Tilføj evt boolean confirm bow fra javaFX-->
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Display content -->
    <div class="container-fluid" id="content">
        <!-- First row -->
        <div class="row row-control">
            <div class="col-md-4">
                <table style="width:100%">
                    <tr>
                        <th>name</th>
                        <th>quantity</th>
                        <th>price</th>
                        <th>remove from cart?</th>
                    </tr>
                    <tr>
                        <td>pinot noir</td>
                        <td>2</td>
                        <td>300.00 kr</td>
                        <td><a href="#">remove</a></td>
                    </tr>
                    <tr>
                        <td>Zinfandel</td>
                        <td>4</td>
                        <td>480.00 kr</td>
                        <td><a href="#">remove</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<div>
    <a href="#">Proceed to checkout</a>
</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>

