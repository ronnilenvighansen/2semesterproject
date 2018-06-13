package Controller;

import Dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginAdmin extends HttpServlet {

    /**Variables */
    private UserDao userDao;

    /** Using Servlet constructor to inherit methods from super class:*/
    public LoginAdmin() {
        super();
        userDao = new UserDao();
    }

    // The doPost method is used when the client post something to the servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /** Admin login validation */
        // Checks through the DAO with a method if the user exists in the database
        if (userDao.adminLogin(username, password) && (username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {
            RequestDispatcher dispatch = request.getRequestDispatcher("JSP/admin.jsp");
            dispatch.forward(request, response);
        }

        // Displays error message in case login failed
        else {
            PrintWriter out = response.getWriter();
            String title = "Wrong username/password";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\" #e62e00\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +

                    "</body></html>");
            // response redirect
        }

        /** Admin logout request handling */
        if (request.getParameter("btn-yes") != null && request.getParameter("btn-no") == null) {
            RequestDispatcher dispatch = request.getRequestDispatcher("JSP/index.jsp");
            dispatch.forward(request, response);
        }
    }


    // The doGet method is used when the client makes a request to get data from the servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}


