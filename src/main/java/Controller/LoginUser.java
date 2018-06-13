package Controller;

import Dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginUser extends HttpServlet {
    HttpSession session;


    /**Variables */
    private UserDao userDao;
    private String modalLink= "#logoutUser";

    /** Using Servlet constructor to inherit methods from super class:*/
    public LoginUser() {
        super();
        userDao = new UserDao();
    }

    // The doPost method is used when the client post something to the servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");



        /** User login validation */
        // Checks through the DAO with a method if the user exists in the database
        if (userDao.userLogin(username, password) && (username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {
            session = request.getSession();
            session.setAttribute("name", "Logged in as " + username + ". Click to log out");
            session.setAttribute("modalLink", modalLink);
            RequestDispatcher dispatch = request.getRequestDispatcher("JSP/index.jsp");
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

        /** User logout request handling */
        if (request.getParameter("btn-yes") != null && request.getParameter("btn-no") == null) {
            session =  request.getSession();
            session.invalidate();


            RequestDispatcher dispatch = request.getRequestDispatcher("JSP/index.jsp");
            dispatch.forward(request, response);
        }
    }

    // The doGet method is used when the client makes a request to get data from the servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}


