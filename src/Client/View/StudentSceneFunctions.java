package Client.View;

import Client.Model.Course;
import Client.Model.Curriculum;
import Client.Model.Student;
import Client.Model.Teacher;

import java.util.ArrayList;

public class StudentSceneFunctions {

    public static Course changeSelectedCourse(String newValue, ArrayList<Course> courseList) {
        int index = 0;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getName().equals(newValue)) {
                index = i;
                break;
            }

        }
        return courseList.get(index);
    }

    public static Student changeSelectedStudent(String newValue, ArrayList<Student> studentList) {
        int index = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if ((studentList.get(i).getFirstName()+" "+studentList.get(i).getLastName()).equals(newValue)) {
                index = i;
                break;
            }

        }
        return studentList.get(index);
    }

    public static Teacher changeSelectedTeacher(String newValue, ArrayList<Teacher> teacherList) {
        int index = 0;
        for (int i = 0; i < teacherList.size(); i++) {
            if ((teacherList.get(i).getFirstName()+" "+teacherList.get(i).getLastName()).equals(newValue)) {
                index = i;
                break;
            }

        }
        return teacherList.get(index);
    }

    public static Curriculum changeSelectedCurriculum(String newValue, ArrayList<Curriculum> curriculumList) {
        ArrayList<String> tempList = new ArrayList<>();
        String id;
        int index = 0;

        for(String selectID : newValue.split(":")){
            tempList.add(selectID);
        }
        id = tempList.get(0);

        for (int i = 0; i < curriculumList.size(); i++) {
            if ((Integer.toString(curriculumList.get(i).getCurricilumID())).equals(id)){
                index = i;
                break;
            }

        }
        return curriculumList.get(index);
    }

}
