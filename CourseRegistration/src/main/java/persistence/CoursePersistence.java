package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Course;
import model.CourseList;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoursePersistence {
    public CourseList readFromOriginalFile(){
        File data = new File("data");
        if(!data.exists())
            data.mkdir();
        File file = new File("data/Course Descriptions.txt");
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileInputStream(file));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        CourseList courseList = new CourseList();
        String regex1 = "([A-Z]{4} \\d\\d\\d\\d?)(.+\\()(\\d(\\.\\d)?)( credits\\))";
        Pattern pattern1 = Pattern.compile("[A-Z]{4} \\d\\d\\d\\d?");
        Matcher matcher = null;
        String courseNumber = null, courseName = null;
        double credits = 0;
        LinkedList<String> pre = null, co = null;
        StringBuilder description = new StringBuilder();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(!line.matches("^\\s*$")) {
                if (line.matches(regex1)) {
                    matcher = pattern1.matcher(line);
                    matcher.find();
                    courseNumber = matcher.group();
                    courseName = line.substring(8, line.indexOf("(")).trim();
                    credits = Double.parseDouble(line.substring(line.indexOf("(") + 1,
                            line.indexOf("credits")).trim());
                } else if (line.startsWith("Prerequisite:")) {
                    pre = new LinkedList<>();
                    matcher = pattern1.matcher(line);
                    while (matcher.find()) {
                        String tempCourse = matcher.group();
                        pre.add(tempCourse);
                    }
                } else if (line.startsWith("Co-requisite:")) {
                    co = new LinkedList<>();
                    matcher = pattern1.matcher(line);
                    while (matcher.find()) {
                        String tempCourse = matcher.group();
                        co.add(tempCourse);
                    }
                } else {
                    description.append(line);
                }
            }else{
                Course course = new Course(courseNumber, courseName, credits, pre, co, description);
                courseList.getCourses().add(course);
                description = new StringBuilder();
            }
        }
        return courseList;
    }

    public void save(CourseList courseList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = gson.toJson(courseList);
        try{
            File file = new File("data/Course Description.json");
            FileUtils.writeStringToFile(file, data, Charset.forName("UTF-8"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
