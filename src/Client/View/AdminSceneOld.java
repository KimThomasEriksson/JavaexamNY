package Client.View;

import Client.Model.Course;
import Client.Model.Curriculum;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminSceneOld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ArrayList<String[]> currentList = new ArrayList<>();
        String[] course1 =  {"Math A", "Mathmatics", "100", "25"};
        currentList.add(course1);
        String[] course2 =  {"Math B", "Mathmatics", "100", "25"};
        currentList.add(course2);
        String[] course3 =  {"Math C", "Mathmatics", "100", "25"};
        currentList.add(course3);
        String[] course4 =  {"Math D", "Mathmatics", "100", "25"};
        currentList.add(course4);
        String[] course5 =  {"Math E", "Mathmatics", "100", "25"};
        currentList.add(course5);
        String[] course6 =  {"Math F", "Mathmatics", "100", "25"};
        currentList.add(course6);

        ArrayList<String[]> studentList = new ArrayList<>();
        String[] student1 =  {"Kim", "Eriksson", "100", "25"};
        String[] student2 =  {"Johanna", "Svensson", "100", "25"};
        String[] student3 =  {"Dan", "Berg", "100", "25"};
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Stage window = primaryStage;

        BorderPane root = new BorderPane();
        window.setMinWidth(800);
        window.setMinHeight(600);

        // Top
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        topBox.setSpacing(10);
        topBox.setId("topBox");

        Label topLabel = new Label("Teacher Login");
        topLabel.setId("topLabel");

        Button logOutButton = new Button("Log Out");
        topBox.getChildren().addAll(topLabel, logOutButton);
        root.setTop(topBox);

        //Center Student

        GridPane teacherCenter = new GridPane();
        teacherCenter.setPadding(new Insets(50, 10, 10, 10));
        teacherCenter.setVgap(8);
        teacherCenter.setHgap(10);
        teacherCenter.setId("studentCenter");

        Label studentLabel = new Label("Teacher Info");
        studentLabel.setId("studentHeader");
        teacherCenter.add(studentLabel, 0, 0, 4, 1);


        Label fNameLabel = new Label("First Name:");
        teacherCenter.add(fNameLabel, 0, 1, 1, 1);
        fNameLabel.setId("nameLabel");

        Label fName = new Label("Peter");
        teacherCenter.add(fName, 1,1,1,1);
        fName.setId("infoLabel");

        Label lNameLabel = new Label("Last Name:");
        teacherCenter.add(lNameLabel, 0, 2, 1, 1);
        lNameLabel.setId("nameLabel");

        Label lName = new Label("Brymer");
        teacherCenter.add(lName, 1,2,1,1);
        lName.setId("infoLabel");

        Label emailLabel = new Label("Email:");
        teacherCenter.add(emailLabel, 2,1,1,1);
        emailLabel.setId("nameLabel");

        Label email = new Label("peter@school.se");
        teacherCenter.add(email, 3,1,1,1);
        email.setId("infoLabel");

        Label totalSalaryLabel = new Label("Salary:");
        teacherCenter.add(totalSalaryLabel, 2, 2,1,1);
        totalSalaryLabel.setId("nameLabel");

        Label salary = new Label("26000");
        teacherCenter.add(salary, 3,2,1,1);
        salary.setId("infoLabel");

        //Center Current

        GridPane currentCenter = new GridPane();
        currentCenter.setPadding(new Insets(50, 10, 10, 10));
        currentCenter.setVgap(8);
        currentCenter.setHgap(10);
        currentCenter.setId("currentCenter");

        Label currentLabel = new Label("Current courses");
        currentLabel.setId("studentHeader");


        currentCenter.add(currentLabel, 0, 0, 1, 1);

        ListView<String> currentCourseList = new ListView<>();
        for(int i =0; i < currentList.size();i++){
            currentCourseList.getItems().add(currentList.get(i)[0]);
        }


        currentCenter.add(currentCourseList, 0, 1, 1,5);


        Label courseNameLabel = new Label("Course Name:");
        currentCenter.add(courseNameLabel, 1,1,1,1);
        courseNameLabel.setId("nameLabel");

        Label courseName = new Label();
        currentCenter.add(courseName, 2,1,1,1);
        courseName.setId("infoLabel");

        Label subjectLabel = new Label("Subject:");
        currentCenter.add(subjectLabel, 1, 2, 1, 1);
        subjectLabel.setId("nameLabel");

        Label subject = new Label();
        currentCenter.add(subject, 2,2,1,1);
        subject.setId("infoLabel");

        Label pointsLabel = new Label("Points:");
        currentCenter.add(pointsLabel, 1,3,1,1);
        pointsLabel.setId("nameLabel");

        Label points = new Label();
        currentCenter.add(points, 2,3,1,1);
        points.setId("infoLabel");

        Label numberOfStudentsLabel = new Label("Number of studens:");
        currentCenter.add(numberOfStudentsLabel, 1,4,1,1);
        numberOfStudentsLabel.setId("nameLabel");

        Label numberOfStudents = new Label();
        currentCenter.add(numberOfStudents, 2,4,1,1);
        numberOfStudents.setId("infoLabel");

        /*.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Course selectedCourse = StudentSceneFunctions.changeSelectedCourse(newValue, student.getFailedCourses());
            courseName.setText(selectedCourse.getName());
            subject.setText(selectedCourse.getSubject());
            points.setText(Integer.toString(selectedCourse.getPoints()));
            for(Curriculum curriculum: school.getCurriculum()){
                if(curriculum.getCourse().equals(selectedCourse)){
                    teacher.setText(curriculum.getTeacher().getFirstName() +" "+ curriculum.getTeacher().getLastName());
                    break;
                }
            }
        });*/

        Button gradeStudentButton = new Button("Grade Student");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        currentCenter.add(gradeStudentButton, 1,5, 1, 1);


        //Left
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(150);
        leftBox.setPadding(new Insets(100, 10, 10, 10));
        leftBox.setSpacing(10);
        leftBox.setId("leftBox");

        Button teacherButton = new Button("Teacher info");
        teacherButton.setOnAction(event -> root.setCenter(teacherCenter));

        Button currentButton = new Button("Current courses");
        currentButton.setOnAction(event -> root.setCenter(currentCenter));


        teacherButton.setMinWidth(leftBox.getPrefWidth());
        currentButton.setMinWidth(leftBox.getPrefWidth());


        leftBox.getChildren().addAll(teacherButton, currentButton);
        root.setLeft(leftBox);

        //Right


        //Bottom




        //Start scene
        root.setCenter(teacherCenter);

        Scene newScene = new Scene(root, 800, 600);
        newScene.getStylesheets().add("Client/View/StudentSceneCSS.css");
        window.setScene(newScene);
        window.show();

    }
}
