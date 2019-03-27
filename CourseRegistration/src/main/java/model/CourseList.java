package model;

import java.util.ArrayList;

public class CourseList {

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courses=" + courses +
                '}';
    }
}
