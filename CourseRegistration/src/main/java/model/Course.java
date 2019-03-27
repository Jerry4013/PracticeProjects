package model;

import java.util.LinkedList;

public class Course {

    private String courseCode;

    private String courseName;

    private double credits;

    private LinkedList<String> prerequisite;

    private LinkedList<String> corequisite;

    private StringBuilder description;


    public Course(){}

    public Course(String courseCode, String courseName,
                  double credits, LinkedList<String> prerequisite,
                  LinkedList<String> corequisite, StringBuilder description) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.prerequisite = prerequisite;
        this.corequisite = corequisite;
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public LinkedList<String> getCorequisite() {
        return corequisite;
    }

    public void setCorequisite(LinkedList<String> corequisite) {
        this.corequisite = corequisite;
    }

    public LinkedList<String> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(LinkedList<String> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", prerequisite=" + prerequisite +
                ", corequisite=" + corequisite +
                ", description=" + description +
                '}';
    }
}
