package Server.Model;

import java.io.Serializable;

public class Course implements Serializable {
    private static int numberOfCourses = 0;
    private int courseID;
    private String name;
    private String subject;
    private int points;
    private int numberOfStudents;

    public Course(String name, String subject, int points, int numberOfStudents){
        this.name = name;
        this.subject = subject;
        this.points = points;
        this.numberOfStudents = numberOfStudents;
        this.courseID = numberOfCourses;
        this.numberOfCourses++;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getPoints() {
        return points;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}