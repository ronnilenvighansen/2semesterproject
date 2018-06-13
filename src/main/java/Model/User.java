package Model;

import Utility.HashSalt;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class User {
    HashSalt sec = new HashSalt();
    private int id_user;
    private String username;
    private byte[] salt;
    private String password;
    private String role;
    private String email;
    private int bought_items;
    private int location;

    /**Empty constructor: */
    public User() {

    }

    /**Full Constructor:*/
    public User(int id_user, String username, String password, String role, String email, int bought_items, int location) throws NoSuchAlgorithmException, NoSuchProviderException{
        this.id_user = id_user;
        this.username = username;
        this.salt = sec.getSalt();
        this.password = sec.getSecurePassword(password, salt);
        this.role = role;
        this.email = email;
        this.bought_items = bought_items;
        this.location = location;
    }

    /**Getters and Setters:*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException{
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = sec.getSecurePassword(password, salt);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBought_items() {
        return bought_items;
    }

    public void setBought_items(int bought_items) {
        this.bought_items = bought_items;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String toString(){
        return  "<div class=\"row row-control\">\n" +
                "\n" +
                "                <div class=\"col-md-4\">\n" +
                "                    <h3>" + username +"</h3>\n" +
                "                    <p>Password: "+ password + "</p>\n" +
                "                    <p>Role: "+ role + "</p>\n" +
                "                    <p>Email: "+ email + "</p>\n" +
                "                    <p>Bought Items: "+ bought_items + "</p>\n" +
                "                    <p>user ID: "+ id_user + "</p>\n" +
                "                    <p>Location: "+ location + "</p>\n" +
                "                </div>\n";

    }
}
