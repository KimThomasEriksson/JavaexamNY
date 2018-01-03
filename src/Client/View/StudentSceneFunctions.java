package Client.View;

import Client.Model.Course;

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

}
