import java.util.*;

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

class Course {
    String title;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String title) {
        this.title = title;
    }

    void assignProfessor(Professor prof) {
        this.professor = prof;
    }

    void enrollStudent(Student student) {
        students.add(student);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.title);
    }
}
