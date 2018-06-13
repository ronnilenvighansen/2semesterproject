package Dao;

import Model.Warehouse;
import Utility.MySQLConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class WarehouseDao implements WarehouseDaoInterface {

    private Connection connection;

    /**Constructor*/
    public WarehouseDao() {
        connection = MySQLConn.getConnection();
    }

    // NOTE: Parameters in SQL preparedStatements start with 1, then 2 etc.

    /**Create a warehouse*/
    //Creates a warehouse that does not exist in the database, by passing a Warehouse object as a parameter
    public void createWarehouse(Warehouse warehouse) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO warehouse(name_warehouse, address, description) VALUES (?, ?, ?)");
            prepStat.setString(1, warehouse.getName());
            prepStat.setString(2, warehouse.getAddress());
            prepStat.setString(3, warehouse.getDescription());
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Create a warehouse*/
    //Creates a warehouse that does not exist in the database, by passing a attributes object as a parameter
    public void createWarehouse(String name_warehouse, String address, String description) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("INSERT INTO warehouse(name_warehouse, address, description) VALUES (?, ?, ?)");
            prepStat.setString(1, name_warehouse);
            prepStat.setString(2, address);
            prepStat.setString(3, description);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Delete a warehouse*/
    //Deletes a warehouse that exists in the database, by passing the ID of the Warehouse object as a parameter
    public void deleteWarehouse(int warehouse_id) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("DELETE FROM warehouse WHERE id_warehouse = ?");
            prepStat.setInt(1, warehouse_id);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Update a warehouse*/
    //Updates fields in a warehouse already in the database, by passing a Warehouse object as a parameter
    public void updateWarehouse(Warehouse warehouse) {
        try {
            PreparedStatement prepStat = connection.prepareStatement("UPDATE warehouse SET name_warehouse=?, address=?, description=?" + "WHERE id_warehouse=?");
            prepStat.setString(1, warehouse.getName());
            prepStat.setString(2, warehouse.getAddress());
            prepStat.setString(3, warehouse.getDescription());
            prepStat.setInt(4, warehouse.getId());
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**Return a list of all warehouses*/
    // Returns a list of all warehouses existing in the database
    public List<Warehouse> getAllWarehouse() {
        List<Warehouse> warehouseList = new ArrayList<Warehouse>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM warehouse");

            // Loops through all entries in the database table and uses resultsets of data retrieved from database and puts it into an Product object
            while (resultset.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setId(resultset.getInt("id_warehouse"));
                warehouse.setName(resultset.getString("username"));
                warehouse.setAddress(resultset.getString("password"));
                warehouse.setDescription(resultset.getString("description"));
                warehouseList.add(warehouse);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return warehouseList;
    }

    /**Return warehouse by ID*/
    // Returns a warehouse by passing the ID as a parameter
    public Warehouse getWarehouseById(int warehouseId) {
        Warehouse warehouse = new Warehouse();
        try {
            PreparedStatement prepStat = connection.prepareStatement("SELECT * FROM warehouse WHERE id_warehouse=?");
            prepStat.setInt(1, warehouseId);
            ResultSet resultset = prepStat.executeQuery();

            // Uses a resultset of data retrieved from database and puts it into an Warehouse object
            if (resultset.next()) {
                warehouse.setId(resultset.getInt("id_warehouse"));
                warehouse.setName(resultset.getString("name_warehouse"));
                warehouse.setAddress(resultset.getString("address"));
                warehouse.setDescription(resultset.getString("description"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return warehouse;
    }
}
