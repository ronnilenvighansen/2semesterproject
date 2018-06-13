/**
 * Created by Jakob on 24/11-2016.
 */

package Model;

public class Product {

    private String name_product;
    private String color;
    private String grape;
    private String origin_country;
    private String origin_area;
    private String description;
    private int production_year;
    private String production_date;
    private int id_product;
    private int quantity;
    private int location;
    private double price;
    private double volume;
    private String sparkly;
    private String for_sale;
    private String date_added;


    /**Empty Constructor:*/
    public Product() {

    }

    /**Full Constructor:*/
    public Product(String name_product, String color, String grape, String origin_country, String origin_area, String description,
                   int production_year, String production_date, int id_product, int quantity, int location, double price, double volume,
                   String sparkly, String for_sale, String date_added) {
        this.name_product = name_product;
        this.color = color;
        this.grape = grape;
        this.origin_country = origin_country;
        this.origin_area = origin_area;
        this.description = description;
        this.production_year = production_year;
        this.production_date = production_date;
        this.id_product = id_product;
        this.quantity = quantity;
        this.location = location;
        this.price = price;
        this.volume = volume;
        this.sparkly = sparkly;
        this.for_sale = for_sale;
        this.date_added = date_added;
    }

    /**Getters and Setters:*/
    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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


    public String getFor_sale() {
        return for_sale;
    }

    public void setFor_sale(String for_sale) {
        this.for_sale = for_sale;
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

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getOrigin_area() {
        return origin_area;
    }

    public void setOrigin_area(String origin_area) {
        this.origin_area = origin_area;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getSparkly() {
        return sparkly;
    }

    public void setSparkly(String sparkly) {
        this.sparkly = sparkly;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    /** UDkommenteret pga scriptlets*/
    //  tOString method is used to post HTML code in JSP files until JSTL/EL has been fixed

//    public String toString() {
//        return  "name: : "+ name_product + "\n" +
//                "color: " + color + "\n" +
//                "grape: " + grape + "\n" +
//                "origin_country: " + origin_country + "\n" +
//                "origin_area: " + origin_area + "\n" +
//                "description: " + description + "\n" +
//                "production year: " + production_year + "\n" +
//                "production date: " + production_date + "\n" +
//                "ID: " + id_product + "\n" +
//                "quantity: " + quantity + " in stock\n" +
//                "This product is located at warehouse #" + location +
//                "price: " + price + " DKK \n" +
//                "volume: " + volume + "\n" +
//                "for sale? : " + for_sale + "\n" +
//                "sparkly : " + sparkly + "\n" +
//                "date added: " + date_added + "\n";
//    }

    public String toString() {
        return  "<div class=\"row row-control\">\n" +
//                "                <div>\n" +
//                "                    <img class=\"col-md-2\">\n" +
//                "                    <br><br>\n" +
//                "                            <img src=\"/img/test.png\" class=\"img-thumbnail\" alt=\"img\" width=\"80%\" height=\"70%\"/>\n" +
//                "                </div>\n" +
                "\n" +
                "                <div class=\"col-md-4\">\n" +
                "                    <h3>" + name_product +"</h3>\n" +
                "                    <p>Color: "+ color + "</p>\n" +
                "                    <p>Grape: "+ grape + "</p>\n" +
                "                    <p>Sparkly: "+ sparkly + "</p>\n" +
                "                    <p>Production Year: "+ production_year + "</p>\n" +
                "                    <p>Origin Country: "+ origin_country + "</p>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"col-md-3\">\n" +
                "                    <br><br><br>\n" +
                "                    <p>"+ description + "</p>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"col-md-2\">\n" +
                "                    <br><br><br>\n" +
                "                    <input type=\"text\" name=\"FirstName\" placeholder=\"1\" value=\"1\"/>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"col-md-2\">\n" +
                "                    <br><br><br>\n" +
                "                    <a href=\"#\">Add to cart</a>\n" +
                "                </div>\n" +
                "            </div>";
    }

}
