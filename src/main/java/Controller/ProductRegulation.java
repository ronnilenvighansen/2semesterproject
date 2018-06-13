package Controller;

import Dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ProductRegulation extends HttpServlet {

    /**Variables */
    private static String LIST_ALL_PRODUCTS = "JSP/admin.jsp";
    private ProductDao productDao;

    /** Using Servlet constructor to inherit methods from super class:*/
    public ProductRegulation() {
        super();
        productDao = new ProductDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** Product parameters */
        // Getting parameters from HTML form:
        String name_product = request.getParameter("product_name");
        String color = request.getParameter("color");
        String grape = request.getParameter("grape");
        String origin_country = request.getParameter("origin_country");
        String origin_area = request.getParameter("origin_area");
        String description = request.getParameter("description");
        int production_year = Integer.parseInt(request.getParameter("production_year"));
        String production_date = request.getParameter("production_date");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int location_product = Integer.parseInt(request.getParameter("location"));
        double price = Double.parseDouble(request.getParameter("price"));
        double volume = Double.parseDouble(request.getParameter("volume"));
        String sparkly = request.getParameter("sparkly");
        String for_sale = request.getParameter("for_sale");
        String date_added = request.getParameter("date_added");

        /** Create Product */
        // Getting parameter from submit button to run the method in the if statement:
        if(request.getParameter("submit_btn_prod") != null) {
            productDao.createProduct(price, volume, quantity, for_sale, sparkly, name_product, color, grape, origin_country, origin_area, production_year, production_date, description, location_product, date_added);
            RequestDispatcher dispatch = request.getRequestDispatcher("admin.jsp");
            dispatch.forward(request, response);
        }

        /** Update product */
        // Getting Integer from HTML, compares the Integer with all products in for each loop and uses the Integer as parameter in the method that gets a product by ID
        // Use getters to set attributes and post it into a HTML form so it can be edited and then submitted
//        if(request.getParameter("submit_btn_edit") != null) {
//            List<Product> prodlist = new ArrayList<Product>(productDao.getAllProducts());
//            int idFromForm = Integer.parseInt(request.getParameter("idforEdit"));
//            Product product = productDao.getProductById(idFromForm);
//
//            session.setAttribute("product", product);
//
//                    Det her skal slettes, objektet sættes på session!
//                    request.setAttribute("name_productSet", product.getName_product());
//                    request.setAttribute("colorSet", product.getColor());
//                    request.setAttribute("grapeSet", product.getGrape());
//                    request.setAttribute("origin_countrySet", product.getOrigin_country());
//                    request.setAttribute("origin_areaSet", product.getOrigin_area());
//                    request.setAttribute("descriptionSet", product.getDescription());
//                    request.setAttribute("production_yearSet", product.getProduction_year());
//                    request.setAttribute("production_dateSet", product.getProduction_date());
//                    request.setAttribute("quantitySet", product.getQuantity());
//                    request.setAttribute("locationSet", product.getLocation());
//                    request.setAttribute("priceSet", product.getPrice());
//                    request.setAttribute("volumeSet", product.getVolume());
//                    request.setAttribute("sparklySet", product.getSparkly());
//                    request.setAttribute("for_saleSet", product.getFor_sale());
//                    request.setAttribute("date_addedSet", product.getDate_added());
//
//
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** Display a simple list of all products */
        HttpSession session = request.getSession();
        session.setAttribute("productList", productDao.getAllProducts());


        RequestDispatcher view = request.getRequestDispatcher(LIST_ALL_PRODUCTS);
        view.forward(request, response);
    }
}
