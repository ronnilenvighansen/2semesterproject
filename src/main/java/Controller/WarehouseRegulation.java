package Controller;

import Dao.WarehouseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class WarehouseRegulation extends HttpServlet {

    /** Variables */
    private static String LIST_ALL_WAREHOUSE = "JSP/addWarehouse.jsp";
    private WarehouseDao warehouseDao;

    /** Using Servlet constructor to inherit methods from super class:*/
    public WarehouseRegulation() {
        super();
        warehouseDao = new WarehouseDao();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** User parameters */
        // Getting parameters from HTML form:
        String name_warehouse = request.getParameter("name_warehouse");
        String address = request.getParameter("address");
        String description = request.getParameter("description");

        /** Create User/Admin */
        // Getting parameter from submit button to run the method in the if statement:
        if (request.getParameter("submit_btn_wrhs") != null) {
            warehouseDao.createWarehouse(name_warehouse, address, description);
            RequestDispatcher dispatch = request.getRequestDispatcher("admin.jsp");
            dispatch.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** Display a simple list of all products */
        HttpSession session = request.getSession();
        session.setAttribute("warehouseList", warehouseDao.getAllWarehouse());


        RequestDispatcher view = request.getRequestDispatcher(LIST_ALL_WAREHOUSE);
        view.forward(request, response);
    }
}
