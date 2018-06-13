<%--JSTL Taglib (bruges til at skrive kode i .jsp filer: --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- All reference links are located in the header file -->
    <%@include file="includes/header.jsp" %>
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
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <!-- userModal-->
                        <a href="#" data-toggle="modal" data-target=<%=session.getAttribute("modalLink") %>><i class="fa fa-user fa-fw"></i><%=session.getAttribute("name") %></a>
                    </li>
                    <li>
                        <a href="#" data-toggle="modal" data-target="#adminModal"><i class="fa fa-user fa-fw"></i> Admin
                            Login</a>
                    </li>
                    <li>
                        <a href="edit.jsp" data-toggle="modal"> Browse</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Display all products in a list, editable in Product.java class -->
    <div class="container-fluid" id="content">

        <%=session.getAttribute("productList") %>
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
            <%--</div>--%>
        <%--</c:forEach>--%>
    </div>

</div>


<!-- User Login Modal -->
<div id="userModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header custom-header">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <h4 class="modal-title">User login</h4>
            </div>
            <div class="modal-body custom-body">
                <form class="form-signin" method="POST" action="Controller.LoginUser">
                    <p>Username</p>
                    <input type="text" class="form-control" name="username" required="" autofocus=""/>
                    <br>
                    <p>Password</p>
                    <input type="password" class="form-control" name="password" required=""/>
                    <a href="JSP/addUser.jsp" id="userLink">Create new user account</a>
                    <br><br>
                    <button class="btn btn-lg btn-primary btn-block btn-trans" type="submit">Login</button>
                </form>
            </div>
            <div class="modal-footer custom-footer">
                <br><br>
            </div>
        </div>
    </div>
</div>

<!-- Admin Login modal -->
<div id="adminModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content custom-content">
            <div class="modal-header custom-header">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <h4 class="modal-title">Admin login</h4>
            </div>
            <div class="modal-body custom-body">
                <form class="form-signin" method="POST" action="Controller.LoginAdmin">
                    <p>Username</p>
                    <input type="text" class="form-control" name="username" required="" autofocus=""/>
                    <br>
                    <p>Password</p>
                    <input type="password" class="form-control" name="password" required=""/>
                    <br><br>
                    <button class="btn btn-lg btn-primary btn-block btn-trans" type="submit">Login</button>
                </form>
            </div>
            <div class="modal-footer custom-footer">
                <br><br>
            </div>
        </div>
    </div>
</div>


    <!-- Logout -->
    <div id="logoutUser" class="modal fade" role="dialog">
        <%@include file="includes/confirmLogoutUser.jsp" %>
    </div>

<div>
</div>
</div>


<!-- All reference links are located in the footer file -->
<%@include file="includes/footer.jsp" %>
</body>
</html>
