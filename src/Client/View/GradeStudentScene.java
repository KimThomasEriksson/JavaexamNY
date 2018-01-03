package Client.View;

import Client.Model.Course;
import Client.Model.Curriculum;
import Client.Model.Student;
import Client.Model.Teacher;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradeStudentScene {

    public static void createScene(String courseName, ArrayList<Student> studentList, Teacher teacher, Curriculum curriculum) {
        Stage window = new Stage();
        GridPane gridPane = new GridPane();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Grade Student");
        window.setOnCloseRequest(event -> window.close());
        window.setMinHeight(250);

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        Label gradeHeader = new Label(courseName);
        gridPane.add(gradeHeader, 0, 0, 3, 1);
        gradeHeader.setId("gradeHeader");

        ListView<String> studentListGrade = new ListView<>();
        for(int i =0; i < studentList.size();i++){
            studentListGrade.getItems().add(studentList.get(i).getFirstName() + " " + studentList.get(i).getLastName());
        }
        gridPane.add(studentListGrade, 0,1,3,1);

        ArrayList<Student> chosenStudent = new ArrayList<>();

        studentListGrade.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(newValue);
            for(Student student: studentList){
                if((student.getFirstName()+" "+student.getLastName()).equals(newValue)){
                    chosenStudent.add(student);
                    System.out.println(chosenStudent.get(chosenStudent.size()-1).getFirstName() + " "+ chosenStudent.get(chosenStudent.size()-1).getLastName());
                    break;
                }
            }
        });

        Button passButton = new Button("Pass student");
        passButton.setOnAction(event -> {if(chosenStudent.size() > 0){
            Student lastStudent = chosenStudent.get(chosenStudent.size()-1);
            curriculum.getTeacher().getTeacherToCurriculum().passStudent(lastStudent);
            System.out.println("passed");
            studentList.remove(lastStudent);
            studentListGrade.getItems().remove(lastStudent.getFirstName()+" "+lastStudent.getLastName());}

        });

        Button failButton = new Button("Fail student");
        failButton.setOnAction(event ->  {if(chosenStudent.size() > 0){
            Student lastStudent = chosenStudent.get(chosenStudent.size()-1);
            curriculum.getTeacher().getTeacherToCurriculum().failStudent(lastStudent);
            studentList.remove(lastStudent);
            studentListGrade.getItems().remove(lastStudent.getFirstName()+" "+lastStudent.getLastName());}
        });

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> window.close());



        passButton.setMinWidth(100);
        failButton.setMinWidth(100);
        closeButton.setMinWidth(100);
        gridPane.add(passButton, 0,2,1,1);
        gridPane.add(failButton, 1,2,1,1);
        gridPane.add(closeButton, 2,2,1,1);



        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("Client/View/GradeStudentCSS.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
