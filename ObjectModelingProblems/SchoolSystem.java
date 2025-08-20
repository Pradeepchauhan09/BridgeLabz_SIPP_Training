import java.util.*;

class Course {
    String name;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void enroll(Student student) {
        students.add(student);
    }

    void showStudents() {
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        courses.add(course);
        course.enroll(this);
    }

    void showCourses() {
        for (Course c : courses) {
            System.out.println(c.name);
        }
    }
}

class School {
    List<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }
}
