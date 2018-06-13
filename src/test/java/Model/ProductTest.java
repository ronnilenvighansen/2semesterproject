package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ronni on 28-11-2016.
 */
public class ProductTest {
    @Before
    public void setUp() throws Exception {
        Product product = new Product();
        product.setName_product("Cabernet");
        product.setColor("Red");
        product.setGrape("Shiraz");
        product.setOrigin_country("Italy");
        product.setOrigin_area("Venice");
        product.setDescription("Great for beginners");
        product.setProduction_year(1955);
        product.setProduction_date("2016-12-12");
        product.setId_product(1);
        product.setQuantity(2);
        product.setLocation(1);
        product.setPrice(59.95);
        product.setVolume(13.5);
        product.setSparkly("n");
        product.setFor_sale("y");
    }

    @Test
    public void getName_product() throws Exception {
        assertEquals("Cabernet", "Cabernet");
    }

    @Test
    public void getColor() throws Exception {
        assertEquals("Red", "Red");
    }

    @Test
    public void getGrape() throws Exception {
        assertEquals("Shiraz", "Shiraz");
    }

    @Test
    public void getOrigin_country() throws Exception {
        assertEquals("Italy", "Italy");
    }

    @Test
    public void getOrigin_area() throws Exception {
        assertEquals("Venice", "Venice");
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("Great for beginners", "Great for beginners");
    }

    @Test
    public void getProduction_year() throws Exception {
        assertEquals(1955, 1955);
    }

    @Test
    public void getProduction_date() throws Exception {
        assertEquals("2016-12-12", "2016-12-12");
    }

    @Test
    public void getId_product() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void getQuantity() throws Exception {
        assertEquals(10, 10);
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(59.95, 59.95, 0.0);
    }

    @Test
    public void getVolume() throws Exception {
        assertEquals(13.5, 13.5, 0.0);
    }

    @Test
    public void getSparkly() throws Exception {
        assertEquals("n", "n");
    }

    @Test
    public void getFor_sale() throws Exception {
        assertEquals("y", "y");
    }
}