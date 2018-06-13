package data;
import java.sql.*;
/**
 * Created by Julie on 10-11-2016.
 */
public class DatabaseConnection {
        /** JDBC driver name and database URL */
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/Test";

        /**  Database user and password */
        static final String USER = "root";
        static final String PASS = "Spurvevej10";

        /** Connection */
        Connection conn = null;

        /** Register driver, connect and handle potential errors */
        public void connectAndFetchData() {
            try{
                // Register JDBC driver
                Class.forName(JDBC_DRIVER);

                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Handle exceptions
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }
        }

        /** Return the connection we opened in connectAndFetchData*/
        public Connection getConnection() {
        return conn;
    }

        /** Close up the connections and handle potential errors */
        public void closeConnection(ResultSet rs, Statement stmt, Connection conn) {
           try {
              rs.close();
              stmt.close();
              conn.close();
              }
        catch(SQLException se2){}
        try{
            // Connection
            if(conn!=null)
                conn.close();

            // Statement
            if(stmt!=null)
                stmt.close();

        // Exception
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    }
