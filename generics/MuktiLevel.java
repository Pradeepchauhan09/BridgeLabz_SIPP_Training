import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Evaluation: " + courseType.getEvaluationType();
    }
}

public class MuktiLevel {

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType courseType : courses) {
            System.out.println(courseType.getEvaluationType());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> literature = new Course<>("Literature", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Physics", new ResearchCourse());

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(math.getCourseType());
        courseTypes.add(literature.getCourseType());
        courseTypes.add(physics.getCourseType());

        System.out.println("Courses and their evaluation types:");
        for (CourseType ct : courseTypes) {
            System.out.println(ct.getEvaluationType());
        }
    }
}
