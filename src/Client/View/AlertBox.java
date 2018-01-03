package Client.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void alert(String title, String message){
        Stage window = new Stage();
        VBox vBox = new VBox(20);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setOnCloseRequest(event -> window.close());


        vBox.setPadding(new Insets(10, 10, 10, 10));
        Label alertMessage = new Label(message);
        alertMessage.setId("message");


        //Login
        Button closeButton = new Button("OK");
        closeButton.setOnAction(event -> window.close());


        vBox.getChildren().addAll(alertMessage, closeButton);
        vBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("Client/View/AlertCSS.css");
        window.setScene(scene);
        window.showAndWait();


    }
}
