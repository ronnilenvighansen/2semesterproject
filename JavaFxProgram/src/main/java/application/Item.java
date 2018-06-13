package application;

/**
 * Created by Julie on 04-11-2016.
 */
public class Item{
    private int id, quantity, productionYear, location;
    private double price, volume;
    private String productName, color, grape, originCountry, originArea, productionDate, description, forSale, sparkly;


    public Item() {}

    public Item(int id, double price, double volume, int quantity, String forSale, String sparkly, String productName, String color, String grape, String originCountry, String originArea, int productionYear, String productionDate, String description, int location) {
        this.id = id;
        this.quantity = quantity;
        this.productionYear = productionYear;
        this.location = location;
        this.price = price;
        this.volume = volume;
        this.forSale = forSale;
        this.sparkly = sparkly;
        this.productName = productName;
        this.color = color;
        this.grape = grape;
        this.originCountry = originCountry;
        this.originArea = originArea;
        this.productionDate = productionDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getForSale() {
        return forSale;
    }

    public void setForSale(String forSale) {
        this.forSale = forSale;
    }

    public String getSparkly() {
        return sparkly;
    }

    public void setSparkly(String sparkly) {
        this.sparkly = sparkly;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGrape() {
        return grape;
    }

    public void setGrape(String grape) {
        this.grape = grape;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginArea() {
        return originArea;
    }

    public void setOriginArea(String originArea) {
        this.originArea = originArea;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
