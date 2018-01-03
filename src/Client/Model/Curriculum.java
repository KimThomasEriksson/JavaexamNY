package Client.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Curriculum implements TeacherToCurriculum,Serializable{
    private static int numberOfCurricilum = 0;
    private int curricilumID;
    private Course course;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Student> gradedStudents;

    public Curriculum(Course course, Teacher teacher, ArrayList<Student> student){
        this.course = course;
        this.teacher = teacher;
        this.students = student;
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;
        gradedStudents = new ArrayList<>();
    }

    public Curriculum(Course course, Teacher teacher){
        this.course = course;
        this.teacher = teacher;
        students = new ArrayList<>();
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;
        gradedStudents = new ArrayList<>();

    }

    public Curriculum(Course course){
        this.course = course;
        students = new ArrayList<>();
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;
        gradedStudents = new ArrayList<>();

    }

    public boolean addTeacher(Teacher newTeacher){
        if(teacher == null){
            this.teacher = newTeacher;
            newTeacher.addInterface(this);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeTeacher(Teacher teacherToRemove){
        if(teacher != null && teacher.getEmployeeid() == teacherToRemove.getEmployeeid()){
            this.teacher = null;
            return true;
        }else{
            return false;
        }
    }

    public boolean addStudent(Student studentToAdd){
        if(!(students.size()==this.course.getNumberOfStudents() || students.contains(studentToAdd))){
            students.add(studentToAdd);
            studentToAdd.addCourse(this.course);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void passStudent(Student studentToPass){
        gradedStudents.add(studentToPass);
        students.remove(studentToPass);
        studentToPass.completeCourse(this.course, true);
    }
    @Override
    public void failStudent(Student studentToPass){
        gradedStudents.add(studentToPass);
        students.remove(studentToPass);
        studentToPass.completeCourse(this.course, false);
    }

    public Course getCourse() {
        return course;
    }

    public int getCurricilumID() {
        return curricilumID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}