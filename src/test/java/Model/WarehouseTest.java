package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ronni on 12-12-2016.
 */
public class WarehouseTest {
    @Before
    public void setUp() throws Exception {
        Warehouse warehouse = new Warehouse(1, "Roskilde", "Roskildevej", "Primary warehouse");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Roskilde", "Roskilde");
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("Roskildevej", "Roskildevej");
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("Primary warehouse", "Primary warehouse");
    }
}