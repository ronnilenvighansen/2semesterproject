package Dao;

import Model.Product;
import Utility.MySQLConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDao implements ProductDaoInterface {

    private Connection connection;

    /**Constructor*/
    public ProductDao() {
        connection = MySQLConn.getConnection();
    }

    // NOTE: Parameters in SQL preparedStatements start with 1, then 2 etc.

    /**Create a product*/
    //Creates a product that does not exist in the database, by passing variables as parameters
    public void createProduct(double price, double volume, int quantity, String for_sale, String sparkly, String name_product, String color, String grape, String origin_country, String origin_area, int production_year, String production_date, String description, int location, String date_added) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO product(price, volume, quantity, for_sale, sparkly, name_product, color, grape, origin_country, origin_area, production_year, production_date, description, location, date_added) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            prepStat.setDouble(1, price);
            prepStat.setDouble(2, volume);
            prepStat.setInt(3, quantity);
            prepStat.setString(4, for_sale);
            prepStat.setString(5, sparkly);
            prepStat.setString(6, name_product);
            prepStat.setString(7, color);
            prepStat.setString(8, grape);
            prepStat.setString(9, origin_country);
            prepStat.setString(10, origin_area);
            prepStat.setInt(11, production_year);
            prepStat.setString(12, production_date);
            prepStat.setString(13, description);
            prepStat.setInt(14, location);
            prepStat.setString(15, date_added);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Udkommenteret og gemt til fremtidig brug */
//    /**Create a product*/
//    //Creates a product that does not exist in the database, by passing a Product object as a parameter
//    public void createProduct(Product product) {
//        try {
//            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO product(price, volume, quantity, for_sale, sparkly, name_product, color, grape, origin_country, origin_area, production_year, production_date, description, location, date_added) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//            prepStat.setDouble(1, product.getPrice());
//            prepStat.setDouble(2, product.getVolume());
//            prepStat.setInt(3, product.getQuantity());
//            prepStat.setString(4, product.getFor_sale());
//            prepStat.setString(5, product.getSparkly());
//            prepStat.setString(6, product.getName_product());
//            prepStat.setString(7, product.getColor());
//            prepStat.setString(8, product.getGrape());
//            prepStat.setString(9, product.getOrigin_country());
//            prepStat.setString(10, product.getOrigin_area());
//            prepStat.setInt(11, product.getProduction_year());
//            prepStat.setString(12, product.getProduction_date());
//            prepStat.setString(13, product.getDescription());
//            prepStat.setInt(14, product.getLocation());
//            prepStat.setString(15, product.getDate_added());
//            prepStat.executeUpdate();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    /**Delete a product*/
    //Deletes a product that exists in the database, by passing the ID of the Product object as a parameter
    public void deleteProduct(int product_id) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("DELETE FROM product WHERE id_product = ?");
            prepStat.setInt(1, product_id);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Update a product*/
    //Updates fields in an product already in the database, by passing a Product object as a parameter
    public void updateProduct(Product product) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("UPDATE product SET price=?, volume=?, quantity=?, for_sale=?, sparkly=?, name_product=?, color=?, grape=?, origin_counrty=?, origin_area=?, production_year=?, prdouction_date=?, description=?, location=?, date_added=?" + "WHERE id_product=?");
            prepStat.setDouble(1, product.getPrice());
            prepStat.setDouble(2, product.getVolume());
            prepStat.setInt(3, product.getQuantity());
            prepStat.setString(4, product.getFor_sale());
            prepStat.setString(5, product.getSparkly());
            prepStat.setString(6, product.getName_product());
            prepStat.setString(7, product.getColor());
            prepStat.setString(8, product.getGrape());
            prepStat.setString(9, product.getOrigin_country());
            prepStat.setString(10, product.getOrigin_area());
            prepStat.setInt(11, product.getProduction_year());
            prepStat.setString(12, product.getProduction_date());
            prepStat.setString(13, product.getDescription());
            prepStat.setInt(14, product.getLocation());
            prepStat.setString(15, product.getDate_added());
            prepStat.setInt(16, product.getId_product());
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Return a list of all products*/
    // Returns a list of all products existing in the database
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM product");
            int count = 0;
            // Loops through all entries in the database table and uses resultsets of data retrieved from database and puts it into an Product object
            while (resultset.next()) {
                Product product = new Product();
                product.setName_product(resultset.getString("name_product"));
                product.setColor(resultset.getString("color"));
                product.setGrape(resultset.getString("grape"));
                product.setOrigin_country(resultset.getString("origin_country"));
                product.setOrigin_area(resultset.getString("origin_area"));
                product.setDescription(resultset.getString("description"));
                product.setProduction_year(resultset.getInt("production_year"));
                product.setProduction_date(resultset.getString("production_date"));
                product.setId_product(resultset.getInt("id_product"));
                product.setQuantity(resultset.getInt("quantity"));
                product.setLocation(resultset.getInt("location"));
                product.setPrice(resultset.getDouble("price"));
                product.setVolume(resultset.getDouble("volume"));
                product.setFor_sale(resultset.getString("for_sale"));
                product.setSparkly(resultset.getString("sparkly"));
                product.setDate_added(resultset.getString("date_added"));
                productList.add(product);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return productList;
    }

    /**Return product by ID*/
    // Returns a product by passing the ID as a parameter
    public Product getProductById(int productId) {
        Product product = new Product();
        try {
            PreparedStatement prepStat = connection.prepareStatement("SELECT * FROM product WHERE id_product=?");
            prepStat.setInt(1, productId);
            ResultSet resultset = prepStat.executeQuery();

            // Uses a resultset of data retrieved from database and puts it into an Product object
            if (resultset.next()) {
                product.setName_product(resultset.getString("name_product"));
                product.setColor(resultset.getString("color"));
                product.setGrape(resultset.getString("grape"));
                product.setGrape(resultset.getString("grape"));
                product.setOrigin_country(resultset.getString("origin_country"));
                product.setOrigin_area(resultset.getString("origin_area"));
                product.setDescription(resultset.getString("description"));
                product.setProduction_year(resultset.getInt("production_year"));
                product.setProduction_date(resultset.getString("production_date"));
                product.setId_product(resultset.getInt("id_product"));
                product.setQuantity(resultset.getInt("quantity"));
                product.setLocation(resultset.getInt("location"));
                product.setPrice(resultset.getDouble("price"));
                product.setVolume(resultset.getDouble("volume"));
                product.setFor_sale(resultset.getString("for_sale"));
                product.setSparkly(resultset.getString("sparkly"));
                product.setDate_added(resultset.getString("date_added"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return product;
    }


}