import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }
}

class Company {
    List<Department> departments = new ArrayList<>();

    void addDepartment(Department d) {
        departments.add(d);
    }

    void deleteCompany() {
        departments.clear();
        System.out.println("Company deleted with all departments and employees.");
    }
}
