package Dao;

import Model.User;
import Utility.MySQLConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements UserDaoInterface {

    private Connection connection;

    /**Constructor*/
    public UserDao() {
        connection = MySQLConn.getConnection();
    }

    // NOTE: Parameters in SQL preparedStatements start with 1, then 2 etc.

    /**Create a user*/
    //Creates a user that does not exist in the database, by passing a User object as a parameter
    public void createUser(String role, String username, String password, String email, int bought_items, int location) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO account(role, username, password, email, bought_items, location) VALUES (?, ?, ?, ?, ?, ?)");
            prepStat.setString(1, role);
            prepStat.setString(2, username);
            prepStat.setString(3, password);
            prepStat.setString(4, email);
            prepStat.setInt(5, bought_items);
            prepStat.setInt(6, location);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
//    /**Create a user*/
//    //Creates a user that does not exist in the database, by passing a User object as a parameter
//    public void createUser(User user) {
//        try {
//            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO account(role, username, password, email, bought_items, location) VALUES (?, ?, ?, ?, ?, ?)");
//            prepStat.setString(1, user.getRole());
//            prepStat.setString(2, user.getUsername());
//            prepStat.setString(3, user.getPassword());
//            prepStat.setString(4, user.getEmail());
//            prepStat.setInt(5, user.getBought_items());
//            prepStat.setInt(6, user.getLocation());
//            prepStat.executeUpdate();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    /**Delete a user*/
    //Deletes a user that exists in the database, by passing the ID of the User object as a parameter
    public void deleteUser(int user_id) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("DELETE FROM account WHERE id_user = ?");
            prepStat.setInt(1, user_id);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Update a user*/
    //Updates fields in a user already in the database, by passing a User object as a parameter
    public void updateUser(User user) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("UPDATE account SET role=?, username=?, password=?, email=?, bought_items=?, location=?" + "WHERE id_user=?");
            prepStat.setString(1, user.getRole());
            prepStat.setString(2, user.getUsername());
            prepStat.setString(3, user.getPassword());
            prepStat.setString(4, user.getEmail());
            prepStat.setInt(5, user.getBought_items());
            prepStat.setInt(6, user.getLocation());
            prepStat.setInt(7, user.getId_user());
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Return a list of all user*/
    // Returns a list of all users existing in the database
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM account");

            // Loops through all entries in the database table and uses resultsets of data retrieved from database and puts it into an User object
            while (resultset.next()) {
                User user = new User();
                user.setId_user(resultset.getInt("id_account"));
                user.setRole(resultset.getString("role"));
                user.setUsername(resultset.getString("username"));
                user.setPassword(resultset.getString("password"));
                user.setEmail(resultset.getString("email"));
                user.setBought_items(resultset.getInt("bought_items"));
                user.setLocation(resultset.getInt("location"));
                userList.add(user);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return userList;
    }

    /**Return user by ID*/
    // Returns a user by passing the ID as a parameter
    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement prepStat = connection.prepareStatement("SELECT * FROM account WHERE id_account=?");
            prepStat.setInt(1, userId);
            ResultSet resultset = prepStat.executeQuery();

            // Uses a resultset of data retrieved from database and puts it into an User object
            if (resultset.next()) {
                user.setId_user(resultset.getInt("id_account"));
                user.setRole(resultset.getString("role"));
                user.setUsername(resultset.getString("username"));
                user.setPassword(resultset.getString("password"));
                user.setEmail(resultset.getString("email"));
                user.setBought_items(resultset.getInt("bought_items"));
                user.setLocation(resultset.getInt("location"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    /**Return boolean to validate User Login*/
    // Returns a boolean used to validate if a user is existing in the database
    public boolean userLogin(String username, String password) {
        boolean login = false;
        String dbUsername;
        String dbPassword;
        String dbRole;
        try {
            PreparedStatement prepStat = connection.prepareStatement("SELECT username, password, role FROM account");
            ResultSet resultset = prepStat.executeQuery();

            // Loops through resultsets created by reading data from tables in the database and compares fields
            while(resultset.next()) {
                dbUsername = resultset.getString("username");
                dbPassword = resultset.getString("password");
                dbRole = resultset.getString("role");

                if (dbUsername.equals(username) && dbPassword.equals(password) && dbRole.equalsIgnoreCase("u")) {
                    login = true;
                    // User is authenticated as a user
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return login;
    }

    /**Return boolean to validate Admin Login*/
    // Returns a boolean used to validate if an admin is existing in the database
    public boolean adminLogin(String username, String password) {
        boolean login = false;
        String dbUsername;
        String dbPassword;
        String dbRole;
        try {
            PreparedStatement prepStat = connection.prepareStatement("SELECT username, password, role FROM account");
            ResultSet resultset = prepStat.executeQuery();

            // Loops through resultsets created by reading data from tables in the database and compares fields
            while(resultset.next()) {
                dbUsername = resultset.getString("username");
                dbPassword = resultset.getString("password");
                dbRole = resultset.getString("role");

                if (dbUsername.equals(username) && dbPassword.equals(password) && dbRole.equalsIgnoreCase("a")) {
                    login = true;
                    // User is authenticated as an Admin
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return login;
    }



}
