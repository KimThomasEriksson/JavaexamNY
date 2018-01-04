package Client.View;

import Client.Model.School;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateStudentScene {

    public static void createStudent(School school){
        Stage window = new Stage();
        GridPane gridPane = new GridPane();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create Student Accout");
        window.setOnCloseRequest(event -> window.close());

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label createStudentTop = new Label("Create Student Account");
        gridPane.add(createStudentTop, 0,0,2,1);
        createStudentTop.setId("topLabel");

        Label firstNameLabel = new Label("First name:");
        gridPane.add(firstNameLabel, 0, 1, 1, 1);
        firstNameLabel.setId("nameLabel");

        TextField firstName = new TextField();
        gridPane.add(firstName, 1, 1, 1, 1);
        firstName.setId("textField");

        Label lastNameLabel = new Label("Last name:");
        gridPane.add(lastNameLabel, 0, 2, 1, 1);
        lastNameLabel.setId("nameLabel");

        TextField lastName = new TextField();
        gridPane.add(lastName, 1, 2, 1, 1);
        lastName.setId("textField");

        Label emailLabel = new Label("Email:");
        gridPane.add(emailLabel, 0, 3, 1, 1);
        emailLabel.setId("nameLabel");

        TextField email = new TextField();
        gridPane.add(email, 1, 3, 1, 1);
        email.setId("textField");

        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 4, 1, 1);
        passwordLabel.setId("nameLabel");

        TextField password = new TextField();
        gridPane.add(password, 1, 4, 1, 1);
        password.setId("textField");

        Label birthYearLabel = new Label("Birthyear:");
        gridPane.add(birthYearLabel, 0, 5, 1, 1);
        birthYearLabel.setId("nameLabel");

        TextField birthYear = new TextField();
        gridPane.add(birthYear, 1, 5, 1, 1);
        birthYear.setId("textField");

        Button createStudentButton = new Button("Create Student");
        gridPane.add(createStudentButton, 0,6,1,1);
        createStudentButton.setOnAction(event -> {
            if (firstName.getText().length() != 0 && lastName.getText().length() != 0 && email.getText().length() != 0 && password.getText().length() != 0 && birthYear.getText().length() != 0) {
                try{
                    int birth = Integer.parseInt(birthYear.getText());
                    school.addStudent(firstName.getText(), lastName.getText(), email.getText(), password.getText(), birth);
                    window.close();
                }catch (NumberFormatException e){
                    AlertBox.alert("Error", "Birthyear must be 4 digits");
                }

            };
        });

        Button closeButton = new Button("Close");
        gridPane.add(closeButton,1, 6,1,1);
        closeButton.setOnAction(event -> window.close());


        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("Client/View/CreateCSS.css");
        window.setScene(scene);
        window.showAndWait();


    }
}
