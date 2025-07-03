package LinkedList;
import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at beginning.");
    }
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
        System.out.println("Item added at end.");
    }
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
        System.out.println("Item added at position " + pos);
    }
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    public void search(String keyword) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.id).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("Found -> ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No item matched.");
    }
    public void totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }
    public void sort(String field, boolean ascending) {
        head = mergeSort(head, field, ascending);
        System.out.println("Inventory sorted by " + field + " (" + (ascending ? "ASC" : "DESC") + ")");
    }

    private Item mergeSort(Item head, String field, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, field, ascending);
        Item right = mergeSort(nextOfMiddle, field, ascending);

        return sortedMerge(left, right, field, ascending);
    }

    private Item sortedMerge(Item a, Item b, String field, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        boolean compare;
        if (field.equalsIgnoreCase("name")) {
            compare = ascending ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            compare = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (compare) {
            result = a;
            result.next = sortedMerge(a.next, b, field, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, field, ascending);
        }

        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("\n--- Inventory Items ---");
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID or Name");
            System.out.println("7. Display Total Inventory Value");
            System.out.println("8. Sort Inventory");
            System.out.println("9. Display All Items");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, qty, pos;
            double price;
            String name, field;
            boolean asc;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Item ID, Name, Quantity, Price: ");
                    id = sc.nextInt();
                    name = sc.next();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    if (choice == 1)
                        inventory.addAtBeginning(name, id, qty, price);
                    else if (choice == 2)
                        inventory.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        inventory.addAtPosition(pos, name, id, qty, price);
                    }
                    break;
                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    id = sc.nextInt();
                    inventory.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID and New Quantity: ");
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;
                case 6:
                    System.out.print("Enter ID or Name to Search: ");
                    String keyword = sc.next();
                    inventory.search(keyword);
                    break;
                case 7:
                    inventory.totalValue();
                    break;
                case 8:
                    System.out.print("Sort by (name/price): ");
                    field = sc.next();
                    System.out.print("Ascending? (true/false): ");
                    asc = sc.nextBoolean();
                    inventory.sort(field, asc);
                    break;
                case 9:
                    inventory.displayAll();
                    break;
                case 10:
                    System.out.println("Exiting Inventory System...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 10);

    }
}
