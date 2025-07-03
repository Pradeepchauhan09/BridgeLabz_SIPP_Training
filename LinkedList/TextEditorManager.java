package LinkedList;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String newText) {
        TextState newState = new TextState(newText);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }
        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        current = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state added.");
    }
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No previous state to undo.");
        }
    }
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No next state to redo.");
        }
    }
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text yet.");
        }
    }
}

public class TextEditorManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting editor...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }
}
