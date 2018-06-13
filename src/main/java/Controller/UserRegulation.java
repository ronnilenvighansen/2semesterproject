package Controller;

import Dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class UserRegulation extends HttpServlet {

    /** Variables */
    private static String LIST_ALL_USERS = "JSP/addAdmin.jsp";
    private UserDao userDao;

    /** Using Servlet constructor to inherit methods from super class:*/
    public UserRegulation() {
        super();
        userDao = new UserDao();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** User parameters */
        // Getting parameters from HTML form:
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        int bought_items = Integer.parseInt(request.getParameter("bought_items"));
        int location_user = Integer.parseInt(request.getParameter("location_user"));

        /** Create User/Admin */
        // Getting parameter from submit button to run the method in the if statement:
        if (request.getParameter("submit_btn_user") != null) {
            userDao.createUser(role, username, password, email, bought_items, location_user);
            RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
            dispatch.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /** Display a simple list of all products */
        HttpSession session = request.getSession();
        session.setAttribute("userList", userDao.getAllUsers());


        RequestDispatcher view = request.getRequestDispatcher(LIST_ALL_USERS);
        view.forward(request, response);
    }
}
