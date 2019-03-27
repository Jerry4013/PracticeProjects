import model.CourseList;
import persistence.CoursePersistence;

public class Driver {
    public static void main(String[] args) {
        CoursePersistence coursePersistence = new CoursePersistence();
        CourseList courseList = coursePersistence.readFromOriginalFile();
        coursePersistence.save(courseList);
    }
}
