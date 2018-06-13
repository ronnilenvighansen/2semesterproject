package Controller;

import Dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class DisplayIndex extends HttpServlet{

    /**Variables */
    private static String LIST_ALL_PRODUCTS = "JSP/index.jsp";
    private ProductDao productDao;
    private String login = "User Login";
    private String modalLink = "#userModal";

    /** Using Servlet constructor to inherit methods from super class:*/
    public DisplayIndex() {
        super();
        productDao = new ProductDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("productList", productDao.getAllProducts());
        session.setAttribute("name", login);
        session.setAttribute("modalLink", modalLink);


        RequestDispatcher view = request.getRequestDispatcher(LIST_ALL_PRODUCTS);
        view.forward(request, response);
    }
}
