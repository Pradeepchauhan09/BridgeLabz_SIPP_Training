package LinkedList;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class ListStudent {
    private Student head;
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position <= 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Roll number not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Record deleted.");
        }
    }
    public void searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Found: " + current.name + " | Age: " + current.age + " | Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Roll number not found.");
    }
    public void updateGrade(int rollNumber, String newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Roll number not found.");
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        Student current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name +
                               ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class SinglyListStudent {
    public static void main(String[] args) {
        ListStudent list = new ListStudent();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Records");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int roll, age, pos;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addAtBeginning(roll, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addAtEnd(roll, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addAtPosition(pos, roll, name, age, grade);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                    break;
                case 6:
                    System.out.print("Enter Roll Number to Update: ");
                    roll = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    grade = sc.next();
                    list.updateGrade(roll, grade);
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 8);
    }
}
