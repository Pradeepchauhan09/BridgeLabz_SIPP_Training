package LinkedList;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    Set<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new HashSet<>();
        this.next = null;
    }
}

class SocialNetwork {
    private User head = null;

    // Add user
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added: " + name);
    }

    // Find user by ID
    private User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection (both sides)
    public void addFriend(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("A user cannot friend themselves.");
            return;
        }

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (u1.friendIds.contains(id2)) {
            System.out.println("They are already friends.");
            return;
        }

        u1.friendIds.add(id2);
        u2.friendIds.add(id1);
        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    // Remove friend connection (both sides)
    public void removeFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!u1.friendIds.contains(id2)) {
            System.out.println("They are not friends.");
            return;
        }

        u1.friendIds.remove(id2);
        u2.friendIds.remove(id1);
        System.out.println("Friend connection removed between " + u1.name + " and " + u2.name);
    }

    // Display friends of a user
    public void displayFriends(int id) {
        User u = findUser(id);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + u.name + ":");
        for (int friendId : u.friendIds) {
            User friend = findUser(friendId);
            if (friend != null)
                System.out.println(" - " + friend.name + " (ID: " + friend.userId + ")");
        }
        if (u.friendIds.isEmpty()) {
            System.out.println("No friends.");
        }
    }

    // Search by name or ID
    public void searchUser(String keyword) {
        boolean found = false;
        User temp = head;

        while (temp != null) {
            if (String.valueOf(temp.userId).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("User found: " + temp.name + " | ID: " + temp.userId + " | Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No user found with that name or ID.");
    }

    // Find mutual friends
    public void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friendIds);
        mutual.retainAll(u2.friendIds);

        System.out.println("Mutual friends between " + u1.name + " and " + u2.name + ":");
        if (mutual.isEmpty()) {
            System.out.println("None.");
        } else {
            for (int fid : mutual) {
                User friend = findUser(fid);
                if (friend != null)
                    System.out.println(" - " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Count friends per user
    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        System.out.println("\nAll Users:");
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();
        int choice;

        do {
            System.out.println("\n--- Social Media Friend Manager ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Search User by Name or ID");
            System.out.println("5. Display Friends of User");
            System.out.println("6. Show Mutual Friends");
            System.out.println("7. Count Friends per User");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id1, id2, age;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    network.addUser(id1, name, age);
                    break;

                case 2:
                    System.out.print("Enter Your ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend's ID: ");
                    id2 = sc.nextInt();
                    network.addFriend(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter Your ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend's ID: ");
                    id2 = sc.nextInt();
                    network.removeFriend(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter Name or ID to Search: ");
                    name = sc.nextLine();
                    network.searchUser(name);
                    break;

                case 5:
                    System.out.print("Enter Your ID: ");
                    id1 = sc.nextInt();
                    network.displayFriends(id1);
                    break;

                case 6:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();
                    network.mutualFriends(id1, id2);
                    break;

                case 7:
                    network.countAllFriends();
                    break;

                case 8:
                    network.displayAllUsers();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 9);
    }
}
