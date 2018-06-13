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
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/JSP/index.jsp">Go back to front page</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Create User -->
    <h3>Add A User</h3>
    <form class="form-signin" method="POST" action="Controller.UserRegulation">
        <p>Username:</p>
        <input type="text" class="form-control" name="username" value="String Required" required="" autofocus=""/>
        <br>
        <p>password:</p>
        <input type="text" class="form-control" name="password" value="String Required" required="" autofocus=""/>
        <br>
        <p>Email::</p>
        <input type="text" class="form-control" name="email" value="String Required" required="" autofocus=""/>
        <br>
        <p>Bought Items:</p>
        <input type="text" class="form-control" name="bought_items" value="String Required" required="" autofocus=""/>
        <br>
        <p>Location:</p>
        <input type="text" class="form-control" name="location_user" value="Integer Required" required="" autofocus=""/>
        <br>
        <input type="hidden" name="role" value="u">
        <button class="btn btn-lg btn-primary btn-block btn-trans" name="submit_btn_user" type="submit">Submit to Database</button>
        <br>
        <br>
    </form>



</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>