/** HUSK: Henvisning til videoerne på Youtube */
package presentation;

import application.ConfirmBox;
import application.Item;
import application.Login;
import data.DatabaseConnection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main extends Application {
    /** Variables for FX */
    Scene scene01, scene02;
    Stage window;
    BorderPane borderpane01, borderpane02;
    TableView<Item> table;
    Button btn02, btn03;
    TextField username;
    Text errorMessage;
    PasswordField password;
    Label label01, label02;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /** Connect to database */
        DatabaseConnection connect = new DatabaseConnection();

        // Fetch data to display later
        connect.connectAndFetchData();
        Connection conn = connect.getConnection();

        // Make a statement (select the data from the table) and save it in a ResultSet to be handled later
        Statement stmt = conn.createStatement();
        String sql = "SELECT id_product, price, volume, quantity, for_sale, sparkly, name_product, color, grape, origin_country, origin_area, production_year, production_date, description, location FROM product";
        ResultSet rs = stmt.executeQuery(sql);

        /** Set window */
        window = primaryStage;


        /** Login page */
        // Input fields
        label01 = new Label("Username");
        username = new TextField();
        username.setMinWidth(100);
        username.setMaxWidth(150);

        label02 = new Label("Password");
        password = new PasswordField();
        password.setMinWidth(100);
        password.setMaxWidth(150);

        errorMessage = new Text();

        // Login button
        btn02 = new Button("Login");
        btn02.setOnAction(event -> {
          Login login = new Login("Admin01", "1234");
          if (username.getText().equals(login.getUsername()) && password.getText().equals(login.getPassword())) { // If login is succesful
              // Clear text fields and go to the next page
              username.clear();
              password.clear();
              window.setScene(scene02);
          }
          else { // Else show error message
              username.clear();
              password.clear();
              errorMessage.setFill(Color.FIREBRICK);
              errorMessage.setText("Wrong username/password");
          }
        });


        // Create new VBox and add all of the buttons and text from above
        VBox layout01 = new VBox(20);
        layout01.getChildren().addAll(label01, username, label02, password, btn02, errorMessage);
        layout01.setPadding(new Insets(20, 10, 50, 10)); // Top, right, bottom, left
        layout01.setAlignment(Pos.CENTER);




        /** Display table page */
        // Table columns
        TableColumn<Item, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setMinWidth(80);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Item, Double> volumeColumn = new TableColumn<>("Volume");
        volumeColumn.setMinWidth(100);
        volumeColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));

        TableColumn<Item, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Item, String> forsaleColumn = new TableColumn<>("For sale");
        forsaleColumn.setMinWidth(100);
        forsaleColumn.setCellValueFactory(new PropertyValueFactory<>("forSale"));

        TableColumn<Item, String> sparklyColumn = new TableColumn<>("Sparkly");
        sparklyColumn.setMinWidth(100);
        sparklyColumn.setCellValueFactory(new PropertyValueFactory<>("sparkly"));

        TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Item, String> colorColumn = new TableColumn<>("Color");
        colorColumn.setMinWidth(150);
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn<Item, String> grapeColumn = new TableColumn<>("Grape");
        grapeColumn.setMinWidth(150);
        grapeColumn.setCellValueFactory(new PropertyValueFactory<>("grape"));

        TableColumn<Item, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setMinWidth(150);
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("originCountry"));

        TableColumn<Item, String> areaColumn = new TableColumn<>("Area");
        areaColumn.setMinWidth(100);
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("originArea"));

        TableColumn<Item, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setMinWidth(100);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("productionYear"));

        TableColumn<Item, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(100);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("productionDate"));

        TableColumn<Item, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(250);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, Integer> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(100);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));




        // Create logout button
        btn03 = new Button("Log out");

        // Set action for logout button
        btn03.setOnAction(event -> {
            ConfirmBox confirm = new ConfirmBox("", "Are you sure?", "Yes", "No");
            if (confirm.display()) {
                window.setScene(scene01);
            }
        });

        // Create new HBox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);


        // Create new tableview add all columns from above
        table = new TableView<>();
        table.setItems(getItem(rs));
        table.getColumns().addAll(idColumn, priceColumn, volumeColumn, quantityColumn, forsaleColumn, sparklyColumn, nameColumn, colorColumn, grapeColumn, countryColumn, areaColumn, yearColumn, dateColumn, descriptionColumn, locationColumn);

        // Create new VBox and add the buttons and table
        VBox layout02 = new VBox(20);
        layout02.getChildren().addAll(table, hbox, btn03);
        layout02.setPadding(new Insets(10, 10, 70, 10));


        // Create new borderpane for the first scene and add the menubar and the layout as top and center
        borderpane01 = new BorderPane();
        borderpane01.setCenter(layout01);
        scene01 = new Scene(borderpane01, 400, 400);

        // Create new borderpane for the second scene and add the menubar and the layout as top and center
        borderpane02 = new BorderPane();
        borderpane02.setCenter(layout02);
        scene02 = new Scene(borderpane02, 980, 640);


        // Start program with the first scene and display what we created
        window.setScene(scene01);
        window.setTitle("Program");
        window.show();

        connect.closeConnection(rs, stmt, conn);

    }


    /** Make the objects to be displayed in a list */
    public ObservableList<Item> getItem(ResultSet rs) throws Exception {
        ObservableList<Item> items = FXCollections.observableArrayList();
        while(rs.next()) {
            // Get data from columns and add them to the observable list
            items.add(new Item(rs.getInt("id_product"), rs.getDouble("price"), rs.getDouble("volume"), rs.getInt("quantity"), rs.getString("for_sale"), rs.getString("sparkly"), rs.getString("name_product"), rs.getString("color"), rs.getString("grape"), rs.getString("origin_country"), rs.getString("origin_area"), rs.getInt("production_year"), rs.getString("production_date"), rs.getString("description"), rs.getInt("location")));
        }
        return items;
    }


    public static void main(String[] args) {
        /** Calls start method */
        launch(args);

    }
}
