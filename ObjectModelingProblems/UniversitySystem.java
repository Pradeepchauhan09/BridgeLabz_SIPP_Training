import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class University {
    List<Department> departments = new ArrayList<>();

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void deleteUniversity() {
        departments.clear();
        System.out.println("University and its departments deleted.");
    }
}
