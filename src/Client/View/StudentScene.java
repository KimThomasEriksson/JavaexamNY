package Client.View;

import Client.Model.Course;
import Client.Model.Curriculum;
import Client.Model.School;
import Client.Model.Student;
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

import java.util.ArrayList;

public class StudentScene {

    public static Scene createScene(Student student, School school) {


        BorderPane root = new BorderPane();

        // Top
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        topBox.setSpacing(10);
        topBox.setId("topBox");

        Label topLabel = new Label("Student Login");
        topLabel.setId("topLabel");

        Button logOutButton = new Button("Log Out");
        topBox.getChildren().addAll(topLabel, logOutButton);
        root.setTop(topBox);

        //Center Student

        GridPane studentCenter = new GridPane();
        studentCenter.setPadding(new Insets(50, 10, 10, 10));
        studentCenter.setVgap(8);
        studentCenter.setHgap(10);
        studentCenter.setId("studentCenter");

        Label studentLabel = new Label("Student Info");
        studentLabel.setId("studentHeader");
        studentCenter.add(studentLabel, 0, 0, 4, 1);


        Label fNameLabel = new Label("First Name:");
        studentCenter.add(fNameLabel, 0, 1, 1, 1);
        fNameLabel.setId("nameLabel");

        Label fName = new Label(student.getFirstName());
        studentCenter.add(fName, 1, 1, 1, 1);
        fName.setId("infoLabel");

        Label lNameLabel = new Label("Last Name:");
        studentCenter.add(lNameLabel, 0, 2, 1, 1);
        lNameLabel.setId("nameLabel");

        Label lName = new Label(student.getLastName());
        studentCenter.add(lName, 1, 2, 1, 1);
        lName.setId("infoLabel");

        Label emailLabel = new Label("Email:");
        studentCenter.add(emailLabel, 2, 1, 1, 1);
        emailLabel.setId("nameLabel");

        Label email = new Label(student.getLastName());
        studentCenter.add(email, 3, 1, 1, 1);
        email.setId("infoLabel");

        Label totalPointsLabel = new Label("Total points:");
        studentCenter.add(totalPointsLabel, 2, 2, 1, 1);
        totalPointsLabel.setId("nameLabel");

        Label totalPoints = new Label(Integer.toString(student.getTotalPoints()));
        studentCenter.add(totalPoints, 3, 2, 1, 1);
        totalPoints.setId("infoLabel");

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
        for (int i = 0; i < student.getCurrentCourses().size(); i++) {
            currentCourseList.getItems().add(student.getCurrentCourses().get(i).getName());
        }


        currentCenter.add(currentCourseList, 0, 1, 1, 5);


        Label courseNameLabel = new Label("Course Name:");
        currentCenter.add(courseNameLabel, 1, 1, 1, 1);
        courseNameLabel.setId("nameLabel");

        Label courseName = new Label();
        currentCenter.add(courseName, 2, 1, 1, 1);
        courseName.setId("infoLabel");

        Label subjectLabel = new Label("Subject:");
        currentCenter.add(subjectLabel, 1, 2, 1, 1);
        subjectLabel.setId("nameLabel");

        Label subject = new Label();
        currentCenter.add(subject, 2, 2, 1, 1);
        subject.setId("infoLabel");

        Label pointsLabel = new Label("Points:");
        currentCenter.add(pointsLabel, 1, 3, 1, 1);
        pointsLabel.setId("nameLabel");

        Label points = new Label();
        currentCenter.add(points, 2, 3, 1, 1);
        points.setId("infoLabel");

        Label teacherLabel = new Label("Teacher:");
        currentCenter.add(teacherLabel, 1, 4, 1, 1);
        teacherLabel.setId("nameLabel");

        Label teacher = new Label();
        currentCenter.add(teacher, 2, 4, 1, 1);
        teacher.setId("infoLabel");


        currentCourseList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Course selectedCourse = StudentSceneFunctions.changeSelectedCourse(newValue, student.getCurrentCourses());
            courseName.setText(selectedCourse.getName());
            subject.setText(selectedCourse.getSubject());
            points.setText(Integer.toString(selectedCourse.getPoints()));
            for(Curriculum curriculum: school.getCurriculum()){
                if(curriculum.getCourse().equals(selectedCourse)){
                    teacher.setText(curriculum.getTeacher().getFirstName() +" "+ curriculum.getTeacher().getLastName());
                    break;
                }
            }

        });

        //Center Completed

        GridPane completedCenter = new GridPane();
        completedCenter.setPadding(new Insets(50, 10, 10, 10));
        completedCenter.setVgap(8);
        completedCenter.setHgap(10);
        completedCenter.setId("completedCenter");

        Label completedLabel = new Label("Completed courses");
        completedLabel.setId("studentHeader");

        completedCenter.add(completedLabel, 0, 0, 1, 1);

        ListView<String> completedCourseList = new ListView<>();
        for (int i = 0; i < student.getCompletedCourses().size(); i++) {
            completedCourseList.getItems().add(student.getCompletedCourses().get(i).getName());
        }

        completedCenter.add(completedCourseList, 0, 1, 1, 5);

        Label compCourseNameLabel = new Label("Course Name:");
        completedCenter.add(compCourseNameLabel, 1, 1, 1, 1);
        compCourseNameLabel.setId("nameLabel");

        Label compCourseName = new Label();
        completedCenter.add(compCourseName, 2, 1, 1, 1);
        compCourseName.setId("infoLabel");

        Label compSubjectLabel = new Label("Subject:");
        completedCenter.add(compSubjectLabel, 1, 2, 1, 1);
        compSubjectLabel.setId("nameLabel");

        Label compSubject = new Label();
        completedCenter.add(compSubject, 2, 2, 1, 1);
        compSubject.setId("infoLabel");

        Label compPointsLabel = new Label("Points:");
        completedCenter.add(compPointsLabel, 1, 3, 1, 1);
        compPointsLabel.setId("nameLabel");

        Label compPoints = new Label();
        completedCenter.add(compPoints, 2, 3, 1, 1);
        compPoints.setId("infoLabel");

        Label compTeacherLabel = new Label("Teacher:");
        completedCenter.add(compTeacherLabel, 1, 4, 1, 1);
        compTeacherLabel.setId("nameLabel");

        Label compTeacher = new Label();
        completedCenter.add(compTeacher, 2, 4, 1, 1);
        compTeacher.setId("infoLabel");


        completedCourseList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
        Course selectedCourse = StudentSceneFunctions.changeSelectedCourse(newValue, student.getCompletedCourses());
            courseName.setText(selectedCourse.getName());
            subject.setText(selectedCourse.getSubject());
            points.setText(Integer.toString(selectedCourse.getPoints()));
            for(Curriculum curriculum: school.getCurriculum()){
                if(curriculum.getCourse().equals(selectedCourse)){
                    teacher.setText(curriculum.getTeacher().getFirstName() +" "+ curriculum.getTeacher().getLastName());
                    break;
                }
        }
        });

        //Center Failed

        GridPane failedCenter = new GridPane();
        failedCenter.setPadding(new Insets(50, 10, 10, 10));
        failedCenter.setVgap(8);
        failedCenter.setHgap(10);
        failedCenter.setId("failedCenter");

        Label failedLabel = new Label("Failed Courses");
        failedLabel.setId("studentHeader");

        failedCenter.add(failedLabel, 0, 0, 1, 1);

        ListView<String> failedCourseList = new ListView<>();
        for (int i = 0; i < student.getFailedCourses().size(); i++) {
            failedCourseList.getItems().add(student.getFailedCourses().get(i).getName());
        }

        failedCenter.add(failedCourseList, 0, 1, 1, 5);

        Label failedCourseNameLabel = new Label("Course Name:");
        failedCenter.add(failedCourseNameLabel, 1, 1, 1, 1);
        failedCourseNameLabel.setId("nameLabel");

        Label failedCourseName = new Label();
        failedCenter.add(failedCourseName, 2, 1, 1, 1);
        failedCourseName.setId("infoLabel");

        Label failedSubjectLabel = new Label("Subject:");
        failedCenter.add(failedSubjectLabel, 1, 2, 1, 1);
        failedSubjectLabel.setId("nameLabel");

        Label failedSubject = new Label();
        failedCenter.add(failedSubject, 2, 2, 1, 1);
        failedSubject.setId("infoLabel");

        Label failedPointsLabel = new Label("Points:");
        failedCenter.add(failedPointsLabel, 1, 3, 1, 1);
        failedPointsLabel.setId("nameLabel");

        Label failedPoints = new Label();
        failedCenter.add(failedPoints, 2, 3, 1, 1);
        failedPoints.setId("infoLabel");

        Label failedTeacherLabel = new Label("Teacher:");
        failedCenter.add(failedTeacherLabel, 1, 4, 1, 1);
        failedTeacherLabel.setId("nameLabel");

        Label failedTeacher = new Label();
        failedCenter.add(failedTeacher, 2, 4, 1, 1);
        failedTeacher.setId("infoLabel");


        failedCourseList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
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
        });

        //Center New Course

        GridPane newCourseCenter = new GridPane();
        newCourseCenter.setPadding(new Insets(50, 10, 10, 10));
        newCourseCenter.setVgap(8);
        newCourseCenter.setHgap(10);
        newCourseCenter.setId("newCourseCenter");

        Label newCoursesLabel = new Label("Courses");
        newCoursesLabel.setId("studentHeader");

        newCourseCenter.add(newCoursesLabel, 0, 0, 1, 1);

        ArrayList<Course> listOfCourses = new ArrayList<>();
        for(int i=0; i<school.getCurriculum().size(); i++){
            if(!(student.getCurrentCourses().contains(school.getCurriculum().get(i).getCourse()) || student.getCompletedCourses().contains(school.getCurriculum().get(i).getCourse()))){
                listOfCourses.add(school.getCurriculum().get(i).getCourse());
            }
        }

        ListView<String> newCourseList = new ListView<>();
        for (int i = 0; i < listOfCourses.size(); i++) {
            newCourseList.getItems().add(listOfCourses.get(i).getName());
        }

        newCourseCenter.add(newCourseList, 0, 1, 1, 5);

        Label newCourseNameLabel = new Label("Course Name:");
        newCourseCenter.add(newCourseNameLabel, 1, 1, 1, 1);
        newCourseNameLabel.setId("nameLabel");

        Label newCourseName = new Label();
        newCourseCenter.add(newCourseName, 2, 1, 1, 1);
        newCourseName.setId("infoLabel");

        Label newSubjectLabel = new Label("Subject:");
        newCourseCenter.add(newSubjectLabel, 1, 2, 1, 1);
        newSubjectLabel.setId("nameLabel");

        Label newSubject = new Label();
        newCourseCenter.add(newSubject, 2, 2, 1, 1);
        newSubject.setId("infoLabel");

        Label newPointsLabel = new Label("Points:");
        newCourseCenter.add(newPointsLabel, 1, 3, 1, 1);
        newPointsLabel.setId("nameLabel");

        Label newPoints = new Label();
        newCourseCenter.add(newPoints, 2, 3, 1, 1);
        newPoints.setId("infoLabel");

        Label newTeacherLabel = new Label("Teacher:");
        newCourseCenter.add(newTeacherLabel, 1, 4, 1, 1);
        newTeacherLabel.setId("nameLabel");

        Label newTeacher = new Label();
        newCourseCenter.add(newTeacher, 2, 4, 1, 1);
        newTeacher.setId("infoLabel");


        ArrayList<Course> chosenCourse = new ArrayList<>();
        newCourseList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Course selectedCourse = StudentSceneFunctions.changeSelectedCourse(newValue, listOfCourses);
            newCourseName.setText(selectedCourse.getName());
            newSubject.setText(selectedCourse.getSubject());
            newPoints.setText(Integer.toString(selectedCourse.getPoints()));
            for(Curriculum curriculum: school.getCurriculum()){
                if(curriculum.getCourse().equals(selectedCourse)){
                    newTeacher.setText(curriculum.getTeacher().getFirstName() +" "+ curriculum.getTeacher().getLastName());
                    break;
                }
            chosenCourse.add(selectedCourse);
            }

            Button selectCourseButton = new Button("Apply to course");
            selectCourseButton.setOnAction(event -> {
                if(chosenCourse.size()>0){
                    for(Curriculum curriculum: school.getCurriculum()){
                        if(curriculum.getCourse() == selectedCourse){
                            curriculum.addStudent(student);
                            newCourseList.getItems().remove(selectedCourse.getName());
                            currentCourseList.getItems().add(selectedCourse.getName());
                            break;
                        }
                    }

                }
            });

            newCourseCenter.add(selectCourseButton, 1, 5, 1, 1);
        });


        //Left
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(150);
        leftBox.setPadding(new Insets(100, 10, 10, 10));
        leftBox.setSpacing(10);
        leftBox.setId("leftBox");

        Button studentButton = new Button("Student info");
        studentButton.setOnAction(event -> root.setCenter(studentCenter));

        Button currentButton = new Button("Current courses");
        currentButton.setOnAction(event -> root.setCenter(currentCenter));

        Button completedButton = new Button("Finished courses");
        completedButton.setOnAction(event -> root.setCenter(completedCenter));

        Button failedButton = new Button("Failed courses");
        failedButton.setOnAction(event -> root.setCenter(failedCenter));

        Button signUpButton = new Button("Sign up for course");
        signUpButton.setOnAction(event -> root.setCenter(newCourseCenter));

        studentButton.setMinWidth(leftBox.getPrefWidth());
        currentButton.setMinWidth(leftBox.getPrefWidth());
        completedButton.setMinWidth(leftBox.getPrefWidth());
        failedButton.setMinWidth(leftBox.getPrefWidth());
        signUpButton.setMinWidth(leftBox.getPrefWidth());

        leftBox.getChildren().addAll(studentButton, currentButton, completedButton, failedButton, signUpButton);
        root.setLeft(leftBox);

        //Right


        //Bottom


        //Start scene
        root.setCenter(studentCenter);

        Scene newScene = new Scene(root, 800, 600);
        newScene.getStylesheets().add("Client/View/StudentSceneCSS.css");
        return newScene;
    }
}
