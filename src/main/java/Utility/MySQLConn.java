package Utility;

import java.sql.*;


public class MySQLConn {

    /** Variables used by DriverManager to establish connection*/
    //  JDBC driver
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //  Database user and password
    private static final String USER = "sql7148879";
    private static final String PASS = "CpBZshChGx";
    private static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net/sql7148879";

    /** Empty Connection */
    private static Connection connection = null;  //Was made static due to issues with constructor in ProductDao class


    /** Register driver, Initialize connect and handle exceptions */
    // Checks if the connection is running, if not then the method will establish a connection to the database recursively
    public static Connection getConnection() {
        // If connection is not empty then return the connection
        if (connection != null) {
            return connection;
        }
        else {
            try {
                // Returns the class object associated with the classes interface
                Class.forName(JDBC_DRIVER);
                // Initialises the connection using DriverManager given the right parameters
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
            // Exception catching and handling:
            catch (SQLException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            // Returns the initiated connection
            return connection;
        }
    }

//    public static Connection getConnectionHeroku() throws ClassNotFoundException, SQLException{
//
//        String databaseName = System.getenv("DATABASE_NAME");
//        String pass = System.getenv("DATABASE_PASSWORD");
//        String serverUrl = System.getenv("DATABASE_URL");
//        String username = System.getenv("DATABASE_USERNAME");
//
//        return getConnectionHeroku(databaseName, pass, serverUrl, username*/);
//    }

//    public static Connection getConnection() throws SQLException{
//
//        String databaseName = "sql7141171";
//        String pass = "gmxzWKpDKk";
//        String serverUrl = "sql7.freemysqlhosting.net";
//        String username = "sql7141171";
//
//        return getConnection(databaseName, pass, serverUrl, username);
//    }
//
//    public static Connection getConnection(String databaseName,String pass,String serverUrl,String username) throws SQLException {
//
//        String connectionUrl = "jdbc:mysql://" + serverUrl + ":3306/" + databaseName;
//
//        Connection conn = DriverManager.getConnection(connectionUrl, username, pass);
//
//        return conn;
//    }
}
