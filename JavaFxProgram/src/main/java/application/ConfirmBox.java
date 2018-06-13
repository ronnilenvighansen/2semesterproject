package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Julie on 03-11-2016.
 */
public class ConfirmBox {
    static boolean answer;
    static String title;
    static String message;
    static String btn01;
    static String btn02;

    public ConfirmBox(){}
    public ConfirmBox(String title, String message, String btn01, String btn02) {
        this.title = title;
        this.message = message;
        this.btn01 = btn01;
        this.btn02 = btn02;
    }
    public static boolean display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // You have to close the box before you can do anything to the window behind it
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(message);

        Button btnYes = new Button(btn01);
        Button btnNo = new Button(btn02);

        btnYes.setOnAction(event -> {
            answer = true;
            window.close();
        });
        btnNo.setOnAction(event -> {
            answer = false;
            window.close();
        });

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(btnYes, btnNo);
        hbox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, hbox);
        layout.setAlignment(Pos.CENTER);




        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // Puts events from other windows on hold until current window is handled

        return answer;
    }
}
