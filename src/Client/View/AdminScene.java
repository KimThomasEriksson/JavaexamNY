package Client.View;

import Client.Model.*;
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

public class AdminScene {

    public static Scene createAdminScene(Admin admin, School school){


        BorderPane root = new BorderPane();

        // Top
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        topBox.setSpacing(10);
        topBox.setId("topBox");

        Label topLabel = new Label("Admin Login");
        topLabel.setId("topLabel");

        Button logOutButton = new Button("Log Out");
        topBox.getChildren().addAll(topLabel, logOutButton);
        root.setTop(topBox);


        //Students center
        GridPane studentCenter = new GridPane();
        studentCenter.setPrefWidth(150);
        studentCenter.setPadding(new Insets(50, 10, 10, 10));
        studentCenter.setVgap(8);
        studentCenter.setHgap(10);
        studentCenter.setId("currentCenter");

        Label studentTop = new Label("Students");
        studentTop.setId("studentHeader");


        studentCenter.add(studentTop, 0, 0, 1, 1);

        ListView<String> allStudentList = new ListView<>();
        for(int i =0; i < school.getStudents().size();i++){
            allStudentList.getItems().add(school.getStudents().get(i).getFirstName() + " " + school.getStudents().get(i).getLastName());
        }

        studentCenter.add(allStudentList, 0, 1, 1,7);


        Label studentNameLabel = new Label("Name:");
        studentCenter.add(studentNameLabel, 1,1,1,1);
        studentNameLabel.setId("nameLabel");

        Label studentName = new Label();
        studentCenter.add(studentName, 2,1,1,1);
        studentName.setId("infoLabel");

        Label studentEmailLabel = new Label("Email:");
        studentCenter.add(studentEmailLabel, 1, 2, 1, 1);
        studentEmailLabel.setId("nameLabel");

        Label studentEmail = new Label();
        studentCenter.add(studentEmail, 2,2,1,1);
        studentEmail.setId("infoLabel");

        Label studentTotalPoints = new Label("Total Points:");
        studentCenter.add(studentTotalPoints, 1,3,1,1);
        studentTotalPoints.setId("nameLabel");

        Label studentPoints = new Label();
        studentCenter.add(studentPoints, 2,3,1,1);
        studentPoints.setId("infoLabel");

        ArrayList<Student> selectedStudents = new ArrayList<>();
        allStudentList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Student selectedStudent = StudentSceneFunctions.changeSelectedStudent(newValue, school.getStudents());
            studentName.setText(selectedStudent.getFirstName() + " " + selectedStudent.getLastName());
            studentEmail.setText(selectedStudent.getEmail());
            studentPoints.setText(Integer.toString(selectedStudent.getTotalPoints()));
            selectedStudents.add(selectedStudent);

        });

        Button addStudentButton = new Button("Add Student");
        addStudentButton.setOnAction(event -> CreateStudentScene.createStudent(school));

        studentCenter.add(addStudentButton, 1,5, 1, 1);

        Button removeStudentButton = new Button("Remove Selected Student");
        removeStudentButton.setOnAction(event ->{
            school.deleteStudent(selectedStudents.get(selectedStudents.size()-1));
            allStudentList.getItems().remove(selectedStudents.get(selectedStudents.size()-1).getFirstName()+" "+selectedStudents.get(selectedStudents.size()-1).getLastName());
        });

        studentCenter.add(removeStudentButton, 1,6, 1, 1);

        addStudentButton.setMinWidth(studentCenter.getPrefWidth());
        removeStudentButton.setMinWidth(studentCenter.getPrefWidth());

        //Center Teacher

        GridPane teacherCenter = new GridPane();
        teacherCenter.setPrefWidth(150);
        teacherCenter.setPadding(new Insets(50, 10, 10, 10));
        teacherCenter.setVgap(8);
        teacherCenter.setHgap(10);
        teacherCenter.setId("studentCenter");

        Label teacherTop = new Label("Teachers");
        teacherTop.setId("studentHeader");
        teacherCenter.add(teacherTop, 0, 0, 4, 1);

        ListView<String> allTeacherList = new ListView<>();
        for(int i =0; i < school.getTeachers().size();i++){
            allTeacherList.getItems().add(school.getTeachers().get(i).getFirstName() + " " + school.getTeachers().get(i).getLastName());
        }

        teacherCenter.add(allTeacherList, 0, 1, 1,9);


        Label teacherNameLabel = new Label("Name:");
        teacherCenter.add(teacherNameLabel, 1,1,1,1);
        teacherNameLabel.setId("nameLabel");

        Label teacherName = new Label();
        teacherCenter.add(teacherName, 2,1,1,1);
        teacherName.setId("infoLabel");

        Label teacherEmailLabel = new Label("Email:");
        teacherCenter.add(teacherEmailLabel, 1, 2, 1, 1);
        teacherEmailLabel.setId("nameLabel");

        Label teacherEmail = new Label();
        teacherCenter.add(teacherEmail, 2,2,1,1);
        teacherEmail.setId("infoLabel");

        Label teacherSalaryLabel = new Label("Salary:");
        teacherCenter.add(teacherSalaryLabel, 1,3,1,1);
        teacherSalaryLabel.setId("nameLabel");

        Label teacherSalary = new Label();
        teacherCenter.add(teacherSalary, 2,3,1,1);
        teacherSalary.setId("infoLabel");


        allTeacherList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Teacher selectedTeacher = StudentSceneFunctions.changeSelectedTeacher(newValue, school.getTeachers());
            teacherName.setText(selectedTeacher.getFirstName() + " " + selectedTeacher.getLastName());
            teacherEmail.setText(selectedTeacher.getEmail());
            teacherSalary.setText(Integer.toString(selectedTeacher.getSalary()));
        });

        Button addTeacherButton = new Button("Add Teacher");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        teacherCenter.add(addTeacherButton, 1,5, 1, 1);

        Button removeTeacherButton = new Button("Remove Teacher");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        teacherCenter.add(removeTeacherButton, 1,6, 1, 1);

        Button lowerSalaryButton = new Button("Decrease Salary");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        teacherCenter.add(lowerSalaryButton, 1,7, 1, 1);

        Button increaseSalary = new Button("Increase Salary");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        teacherCenter.add(increaseSalary, 1,8, 1, 1);

        addTeacherButton.setMinWidth(teacherCenter.getPrefWidth());
        removeTeacherButton.setMinWidth(teacherCenter.getPrefWidth());
        lowerSalaryButton.setMinWidth(teacherCenter.getPrefWidth());
        increaseSalary.setMinWidth(teacherCenter.getPrefWidth());

        //Center Courses

        GridPane coursesCenter = new GridPane();
        coursesCenter.setPadding(new Insets(50, 10, 10, 10));
        coursesCenter.setVgap(8);
        coursesCenter.setHgap(10);
        coursesCenter.setId("currentCenter");
        coursesCenter.setPrefWidth(150);

        Label currentLabel = new Label("Courses");
        currentLabel.setId("studentHeader");


        coursesCenter.add(currentLabel, 0, 0, 1, 1);

        ListView<String> allCourseList = new ListView<>();
        for(int i =0; i < school.getCourses().size();i++){
            allCourseList.getItems().add(school.getCourses().get(i).getName());
        }


        coursesCenter.add(allCourseList, 0, 1, 1,7);


        Label courseNameLabel = new Label("Course Name:");
        coursesCenter.add(courseNameLabel, 1,1,1,1);
        courseNameLabel.setId("nameLabel");

        Label courseName = new Label();
        coursesCenter.add(courseName, 2,1,1,1);
        courseName.setId("infoLabel");

        Label subjectLabel = new Label("Subject:");
        coursesCenter.add(subjectLabel, 1, 2, 1, 1);
        subjectLabel.setId("nameLabel");

        Label subject = new Label();
        coursesCenter.add(subject, 2,2,1,1);
        subject.setId("infoLabel");

        Label pointsLabel = new Label("Points:");
        coursesCenter.add(pointsLabel, 1,3,1,1);
        pointsLabel.setId("nameLabel");

        Label points = new Label();
        coursesCenter.add(points, 2,3,1,1);
        points.setId("infoLabel");

        Label numberOfStudentsLabel = new Label("Number of studens:");
        coursesCenter.add(numberOfStudentsLabel, 1,4,1,1);
        numberOfStudentsLabel.setId("nameLabel");

        Label numberOfStudents = new Label();
        coursesCenter.add(numberOfStudents, 2,4,1,1);
        numberOfStudents.setId("infoLabel");

        allCourseList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Course selectedCourse = StudentSceneFunctions.changeSelectedCourse(newValue, school.getCourses());
            courseName.setText(selectedCourse.getName());
            subject.setText(selectedCourse.getSubject());
            points.setText(Integer.toString(selectedCourse.getPoints()));
            numberOfStudents.setText(Integer.toString(selectedCourse.getNumberOfStudents()));
        });

        Button addCourseButton = new Button("Add Course");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        coursesCenter.add(addCourseButton, 1,5, 1, 1);

        Button removeCourseButton = new Button("Remove Course");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        coursesCenter.add(removeCourseButton, 1,6, 1, 1);

        addCourseButton.setMinWidth(coursesCenter.getPrefWidth());
        removeCourseButton.setMinWidth(coursesCenter.getPrefWidth());


        //Curriculum Center
        GridPane curriculumCenter = new GridPane();
        curriculumCenter.setPadding(new Insets(50, 10, 10, 10));
        curriculumCenter.setVgap(8);
        curriculumCenter.setHgap(10);
        curriculumCenter.setId("currentCenter");
        curriculumCenter.setPrefWidth(150);

        Label curriculumTop = new Label("Curriculum");
        curriculumTop.setId("studentHeader");


        curriculumCenter.add(curriculumTop, 0, 0, 1, 1);

        ListView<String> allCurriculumList = new ListView<>();
        for(int i =0; i < school.getCurriculum().size();i++){
            allCurriculumList.getItems().add(school.getCurriculum().get(i).toString());
        }


        curriculumCenter.add(allCurriculumList, 0, 1, 1,8);


        Label curriculumCourseLabel = new Label("Course Name:");
        curriculumCenter.add(curriculumCourseLabel, 1,1,1,1);
        curriculumCourseLabel.setId("nameLabel");

        Label curricilumCourseName = new Label();
        curriculumCenter.add(curricilumCourseName, 2,1,1,1);
        curricilumCourseName.setId("infoLabel");

        Label curricilumSubjectLabel = new Label("Subject:");
        curriculumCenter.add(curricilumSubjectLabel, 1, 2, 1, 1);
        curricilumSubjectLabel.setId("nameLabel");

        Label curricilumSubject = new Label();
        curriculumCenter.add(curricilumSubject, 2,2,1,1);
        curricilumSubject.setId("infoLabel");

        Label curricilumPointsLabel = new Label("Points:");
        curriculumCenter.add(curricilumPointsLabel, 1,3,1,1);
        curricilumPointsLabel.setId("nameLabel");

        Label curricilumPoints = new Label();
        curriculumCenter.add(curricilumPoints, 2,3,1,1);
        curricilumPoints.setId("infoLabel");

        Label curricilumNumberOfStudentsLabel = new Label("Number of studens:");
        curriculumCenter.add(curricilumNumberOfStudentsLabel, 1,4,1,1);
        curricilumNumberOfStudentsLabel.setId("nameLabel");

        Label curricilumNumberOfStudents = new Label();
        curriculumCenter.add(curricilumNumberOfStudents, 2,4,1,1);
        curricilumNumberOfStudents.setId("infoLabel");

        Label curricilumTeacherLabel = new Label("Teacher:");
        curriculumCenter.add(curricilumTeacherLabel, 1,5,1,1);
        curricilumTeacherLabel.setId("nameLabel");

        Label curricilumTeacher = new Label();
        curriculumCenter.add(curricilumTeacher, 2,5,1,1);
        curricilumTeacher.setId("infoLabel");

        ArrayList<Curriculum> allSelectedCurricilums = new ArrayList<>();
        allCurriculumList.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Curriculum selectedCurriculum = StudentSceneFunctions.changeSelectedCurriculum(newValue, school.getCurriculum());
            curricilumCourseName.setText(selectedCurriculum.getCourse().getName());
            curricilumSubject.setText(selectedCurriculum.getCourse().getSubject());
            curricilumPoints.setText(Integer.toString(selectedCurriculum.getCourse().getPoints()));
            curricilumNumberOfStudents.setText(Integer.toString(selectedCurriculum.getCourse().getNumberOfStudents()));
            curricilumTeacher.setText(selectedCurriculum.getTeacher().getFirstName() + " " + selectedCurriculum.getTeacher().getLastName());
            allSelectedCurricilums.add(selectedCurriculum);
        });

        Button removeCurriculumButton = new Button("Remove Curriculum");
        //+gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        curriculumCenter.add(removeCurriculumButton, 1,6, 1, 1);

        Button addCurriculum = new Button("Add Curriculum");
        //gradeStudentButton.setOnAction(event -> GradeStudentScene.createScene((buttonChoiceGrade.get(buttonChoiceGrade.size()-1)), studentList));

        curriculumCenter.add(addCurriculum, 1,7, 1, 1);

        removeCurriculumButton.setMinWidth(curriculumCenter.getPrefWidth());
        addCurriculum.setMinWidth(curriculumCenter.getPrefWidth());

        //Left
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(150);
        leftBox.setPadding(new Insets(100, 10, 10, 10));
        leftBox.setSpacing(10);
        leftBox.setId("leftBox");

        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(event -> root.setCenter(studentCenter));

        Button teacherButton = new Button("Teachers");
        teacherButton.setOnAction(event -> root.setCenter(teacherCenter));

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(event -> root.setCenter(coursesCenter));

        Button curriculumButton = new Button("Curriculum");
        curriculumButton.setOnAction(event -> root.setCenter(curriculumCenter));

        studentsButton.setMinWidth(leftBox.getPrefWidth());
        teacherButton.setMinWidth(leftBox.getPrefWidth());
        coursesButton.setMinWidth(leftBox.getPrefWidth());
        curriculumButton.setMinWidth(leftBox.getPrefWidth());


        leftBox.getChildren().addAll(studentsButton, teacherButton, coursesButton, curriculumButton);
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
