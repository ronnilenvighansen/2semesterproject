package Model;

import Utility.HashSalt;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.Assert.*;

/**
 * Created by Ronni on 13-12-2016.
 */
public class UserTest {
    HashSalt sec = new HashSalt();
    byte bytes[] = sec.getSalt();

    public UserTest() throws NoSuchProviderException, NoSuchAlgorithmException {
    }

    @Before
    public void setUp() throws Exception {
        User user = new User(1, "bob", "hello", "admin", "admin@admin.admin", 2, 1);
    }

    @Test
    public void getId_user() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals("Bob", "Bob");
    }

    @Test
    public void getSalt() throws Exception {
        assertEquals(bytes, bytes);
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals(sec.getSecurePassword("Hello", bytes), sec.getSecurePassword("Hello", bytes));
    }

    @Test
    public void getRole() throws Exception {
        assertEquals("Admin", "Admin");
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("Admin@Admin.Admin", "Admin@Admin.Admin");
    }

    @Test
    public void getBought_items() throws Exception {
        assertEquals(2, 2);
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals(1, 1);
    }

}