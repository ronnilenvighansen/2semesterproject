package Dao;

import Model.Warehouse;

import java.util.List;

/**
 * Created by Ronni on 12-12-2016.
 */
public interface WarehouseDaoInterface {
    public void createWarehouse(Warehouse warehouse);
    public void createWarehouse(String name_warehouse, String address, String description);
    public void deleteWarehouse(int warehouse_id);
    public void updateWarehouse(Warehouse warehouse);
    public List<Warehouse> getAllWarehouse();
    public Warehouse getWarehouseById(int warehouseId);
}
