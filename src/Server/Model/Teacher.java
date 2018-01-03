package Server.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends User implements Serializable {

    private static int idCounter = 0;
    private int numberOfTeachers=0;
    private final int employeeid;
    private ArrayList<String> knownSubjects;
    private int salary;
    private TeacherToCurriculum teacherToCurriculum;


    public Teacher(String firstName, String lastName, String email, String password, int birthyear,int salary, ArrayList<String> knownSubjects) {
        super(firstName, lastName, email, password, birthyear);
        this.knownSubjects = knownSubjects;
        raiseSalary(salary);
        this.employeeid = idCounter;
        idCounter++;
        numberOfTeachers++;
    }

//alternativ constructor if you only know one subject in string form
    public Teacher(String firstName, String lastName, String email, String password, int birthyear, int salary, String knownSubject) {
        super(firstName, lastName, email, password, birthyear);
        this.knownSubjects = new ArrayList<String>();
        raiseSalary(salary);
        addSubject(knownSubject);
        this.employeeid = idCounter;
        numberOfTeachers++;
        idCounter++;

    }

//Increase the salary

    public void raiseSalary(int increment) {
        if (this.salary+increment>0){
           this.salary += increment;
        }
    }

//Decrease the salary

    public void decreaseSalary(int decrement){
        if(this.salary-decrement>0){
            this.salary-=decrement;
        }
    }

//Add subject if its not already added

    public void addSubject(String Subject) {
        for (int i = 0; i <this.knownSubjects.size(); i++) {
            if(this.knownSubjects.get(i).equals(Subject)){return;}
        }
        this.knownSubjects.add(Subject);
    }

//Removes subject from the list

    public void removeSubject(String Subject){
        for (int i = 0; i <this.knownSubjects.size(); i++) {
            if(this.knownSubjects.get(i).equals(Subject)){
                this.knownSubjects.remove(i);
            }
        }
    }

    public void addInterface(Curriculum curriculum){
        this.teacherToCurriculum = curriculum;
    }
//Get number of teachers
    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }
//Set number of teachers
    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }
//Get employer id
    public int getEmployeeid() {
        return employeeid;
    }
//get the list of known subjects
    public ArrayList<String> getKnownSubjects() {
        return knownSubjects;
    }

    public String getStringOfSubjects(){
       String subjects="";
        for (int i = 0; i <this.knownSubjects.size(); i++){
            subjects+=this.knownSubjects.get(i);
            if(i != this.knownSubjects.size()-1){
            subjects+=", ";}
        }
        return subjects;

    }


    public int getSalary() {
        return salary;
    }

    public TeacherToCurriculum getTeacherToCurriculum() {
        return teacherToCurriculum;
    }
}
