package Client.Model;

import java.io.*;
import java.util.ArrayList;

public class School implements AdminToSchool,Serializable{
    private String Name;
    private String Adress;
    private ArrayList<Curriculum> curriculum;
    private ArrayList<Course> courses;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student>students;
    private ArrayList<Admin>admins;
    private ArrayList<Student> deletedStudents;
    private ArrayList<Teacher> deletedTeachers;
    private ArrayList<Course> deletedCourse;
    private ArrayList<Curriculum> deletedCurricilum;

    public School(String name, String adress) {
        Name = name;
        Adress = adress;
        this.curriculum = new ArrayList<Curriculum>();
        this.courses =new ArrayList<Course>();
        this.teachers =new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();
        this.admins = new ArrayList<>();
        this.deletedCourse = new ArrayList<>();
        this.deletedTeachers = new ArrayList<>();
        this.deletedStudents = new ArrayList<>();
        this.deletedCurricilum = new ArrayList<>();
    }

    public void addTeacher(String firstName,String lastName,String email,String password,int birthyear,int salary,String knownSubject){
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Teacher newTeacher = new Teacher(firstName,lastName,email,password,birthyear,salary,knownSubject);
        this.teachers.add(newTeacher);

    }

    public void addTeacher(String firstName,String lastName,String email,String password,int birthyear,int salary,ArrayList<String> knownSubject){
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Teacher newTeacher = new Teacher(firstName,lastName,email,password,birthyear,salary,knownSubject);
        this.teachers.add(newTeacher);


    }


    public void addStudent(String firstName,String lastName,String email,String password,int birthyear, ArrayList<Course> currentCourses,ArrayList<Course> completedCourses,ArrayList<Course> failedCourses){
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Student newStudent = new Student(firstName, lastName, email, password, birthyear, currentCourses, completedCourses, failedCourses);
        this.students.add(newStudent);


    }


    public void addStudent(String firstName,String lastName,String email,String password,int birthyear){
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Student newStudent= new Student(firstName,lastName,email,password,birthyear);
        this.students.add(newStudent);

    }

    public void addAdmin(String firstName,String lastName,String email,String password,int birthyear){
        for (int i = 0; i < this.admins.size(); i++) {
            if (this.admins.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Admin newAdmin= new Admin(firstName,lastName,email,password,birthyear);
        this.admins.add(newAdmin);

    }



    public void addCource(String name,String subject,int points,int numberOfStudents){
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getName().equals(name)) {
                return;
            }
        }
        Course newCourse= new Course(name,subject,points,numberOfStudents);
        this.courses.add(newCourse);


    }



    public void addCurriclum(Course course){
        for (int i = 0; i <this.curriculum.size(); i++) {
            if(this.curriculum.get(i).getCourse().getName().equals(course.getName())){
                return;
            }
        }
        Curriculum newCurriculum= new Curriculum(course);
        this.curriculum.add(newCurriculum);
    }

    public void addCurriclum(Course course,Teacher teacher) {
        for (int i = 0; i < this.curriculum.size(); i++) {
            if (this.curriculum.get(i).getCourse().getName().equals(course.getName())) {
                return;
            }
        }
        Curriculum newCurriculum= new Curriculum(course,teacher);
        this.curriculum.add(newCurriculum);
        teacher.addInterface(newCurriculum);
    }
    public void addCurriclum(Course course,Teacher teacher,ArrayList<Student> students) {
        for (int i = 0; i < this.curriculum.size(); i++) {
            if (this.curriculum.get(i).getCourse().getName().equals(course.getName())) {
                return;
            }
        }
        Curriculum newCurriculum= new Curriculum(course,teacher,students);
        this.curriculum.add(newCurriculum);
        teacher.addInterface(newCurriculum);
    }

    public String getName() {
        return Name;
    }

    public String getAdress() {
        return Adress;
    }

    public ArrayList<Curriculum> getCurriculum() {
        return curriculum;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void deleteStudent(Student student){
        students.remove(student);
        deletedStudents.add(student);
    }

    public void deleteTeacher(Teacher teacher){
        teachers.remove(teacher);
        deletedTeachers.add(teacher);
    }

    public void deleteCourse(Course course){
        courses.remove(course);
        deletedCourse.add(course);
    }

    public void deleteCurricilum(Curriculum curriculumToRemove){
        curriculum.add(curriculumToRemove);
        deletedCurricilum.add(curriculumToRemove);
    }

    /*
       public void saveStudents(Student students){
          try {
             FileOutputStream fileOut = new FileOutputStream("students.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             for (int i = 0; i<this.students.size(); i++){
                 out.writeObject(this.students.get(i) + "\n");
             }
             out.close();
             fileOut.close();
          } catch (IOException i) {

          }

       }

       public void readStudents(Student students) {
           String line;
           try {
               FileInputStream fileIn = new FileInputStream("students.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               if (!fileIn.ready()) {
                   throw new IOException();
               }
               while ((line = fileIn.readLine()) != null) {
                   this.students.add(line);
               }
               //Student student = (Employee) in.readObject();
               in.close();
               fileIn.close();


           } catch (IOException i) {

           } catch (ClassNotFoundException c) {
           }

       }

    */
    public void functoSaveStudent(ArrayList<Student> student) {


        try {
            FileOutputStream fileOut =
                    new FileOutputStream("someEmployee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

    public void functoLoadStudent(String fileToLoad ,ArrayList listtoloadto){
        ArrayList<Student> test=null;


        //nu är det dags att ta upp object från hårdisk
        try {
            FileInputStream fileIn = new FileInputStream(fileToLoad+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            test = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();
            this.students = test;


        } catch (IOException i) {

        } catch (ClassNotFoundException c) {}


    }





}


//Saving if needed laters.
 /*   public void saveSchool(String fileName, ArrayList<Curriculum> curriculum, ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.curriculum + "\n", this.courses+ "\n", this.teachers+ "\n", this.students+ "\n");
            out.close();
            fileOut.close();
        } catch (IOException i) {
        }
    }

    public void loadSchool(String fileName){
        ArrayList<Curriculum> curriculum=null;
        ArrayList<Course> courses=null;
        ArrayList<Teacher> teachers=null;
        ArrayList<Student> students=null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            curriculum = (ArrayList<Curriculum>) in.readObject();
            courses = (ArrayList<Course>) in.readObject();
            teachers = (ArrayList<Teacher>) in.readObject();
            students = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();
            this.curriculum = students;
            this.courses = courses;
            this.teachers = teachers;
            this.students = students;
        } catch (IOException i) {
        } catch (ClassNotFoundException c) {

        }
    }*/


