package Dao;

import Model.Product;

import java.util.List;

/**
 * Created by Ronni on 12-12-2016.
 */
public interface ProductDaoInterface {
    public void createProduct(double price, double volume, int quantity, String for_sale, String sparkly, String name_product, String color, String grape, String origin_country, String origin_area, int production_year, String production_date, String description, int location, String date_added);
    public void deleteProduct(int product_id);
    public void updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int productId);
}
