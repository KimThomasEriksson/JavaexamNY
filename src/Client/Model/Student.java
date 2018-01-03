package Client.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable {

    private int totalPoints;
    private ArrayList<Course> currentCourses;
    private ArrayList<Course> completedCourses;
    private ArrayList<Course> failedCourses;
    private static int idCounter = 0;
    private final int studentid;


    public Student(String firstName, String lastName, String email, String password, int birthyear, ArrayList<Course>currentCourses,ArrayList<Course>completedCourses,ArrayList<Course>failedCourses) {
        super(firstName,lastName,email,password,birthyear);
        this.currentCourses = currentCourses;
        this.completedCourses = completedCourses;
        this.failedCourses = failedCourses;
        this.studentid=idCounter;
        idCounter++;
        calculateTotalPoints();

    }

    public Student(String firstName, String lastName, String email, String password, int birthyear) {
        super(firstName,lastName,email,password,birthyear);
        this.totalPoints = 0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.failedCourses = new ArrayList<>();
        this.studentid=idCounter;
        idCounter++;

    }

    public int getTotalPoints() {
        return totalPoints;
    }


    public void calculateTotalPoints(){
        int result = 0;
        for(Course completed : completedCourses){
            result += completed.getPoints();
        }
        this.totalPoints = result;
    }


//Adds a course to the list if it's not already in the list of courses.
    public boolean addCourse(Course newCourse) {
        for (Course course: currentCourses){
            if(course.getCourseID() == newCourse.getCourseID()){
                return false;
            }
        }
        for (Course course: completedCourses){
            if(course.getCourseID() == newCourse.getCourseID()){
                return false;
            }
        }
        this.currentCourses.add(newCourse);
        return true;
    }

    public boolean completeCourse(Course completedCourse, boolean completed){
        if(currentCourses.contains(completedCourse)){
            if(completed){
                completedCourses.add(completedCourse);
                calculateTotalPoints();
                currentCourses.remove(completedCourse);
                return true;
            }else{
                currentCourses.remove(completedCourse);
                failedCourses.add(completedCourse);
                return true;
            }
        }else{
            return false;
        }

    }

    public int getStudentId() {
        return studentid;
    }

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<Course> getFailedCourses() {
        return failedCourses;
    }




}
