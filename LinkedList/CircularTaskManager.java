package LinkedList;

import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;
    public void addAtBeginning(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
        System.out.println("Task added at beginning.");
    }
    public void addAtEnd(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
        System.out.println("Task added at end.");
    }
    public void addAtPosition(int position, int id, String name, String priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }

        System.out.println("Task added at position " + position);
    }
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        Task temp = head, prev = tail;

        do {
            if (temp.taskId == id) {
                if (temp == head && temp == tail) { // only one task
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                if (currentTask == temp) currentTask = head;

                System.out.println("Task ID " + id + " deleted.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }
    public void viewCurrentAndNext() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        if (currentTask == null) currentTask = head;

        System.out.println("Current Task:");
        System.out.println("ID: " + currentTask.taskId + ", Name: " + currentTask.taskName + ", Priority: " + currentTask.priority + ", Due: " + currentTask.dueDate);

        currentTask = currentTask.next;
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("\n--- All Tasks ---");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                               ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchByPriority(String keyword) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                                   ", Due: " + temp.dueDate + ", Priority: " + temp.priority);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + keyword);
        }
    }
}

public class CircularTaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Tasks by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            int id, position;
            String name, priority, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    dueDate = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, dueDate);
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    dueDate = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, dueDate);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    dueDate = sc.nextLine();
                    scheduler.addAtPosition(position, id, name, priority, dueDate);
                    break;
                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    id = sc.nextInt();
                    scheduler.removeById(id);
                    break;
                case 5:
                    scheduler.viewCurrentAndNext();
                    break;
                case 6:
                    scheduler.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Priority to Search: ");
                    priority = sc.nextLine();
                    scheduler.searchByPriority(priority);
                    break;
                case 8:
                    System.out.println("Exiting Task Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
}
