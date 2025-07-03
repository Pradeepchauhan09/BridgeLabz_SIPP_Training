package LinkedList;

import java.util.*;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;

    Process next;

    public Process(int id, int burst, int priority) {
        this.processId = id;
        this.burstTime = burst;
        this.remainingTime = burst;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int processCount = 0;

    // Add process at the end of the circular list
    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
        System.out.println("Process added: P" + id);
    }

    // Remove process by ID
    public void removeProcess(int id) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;
        do {
            if (current.processId == id) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                processCount--;
                System.out.println("Process P" + id + " completed and removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate round-robin scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;

        System.out.println("\nStarting Round-Robin Scheduling...\n");

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= execTime;
                currentTime += execTime;

                // Update waiting time and turnaround time
                if (current.remainingTime == 0) {
                    current.turnAroundTime = currentTime;
                    current.waitingTime = current.turnAroundTime - current.burstTime;
                    removeProcess(current.processId);
                }
            }
            displayProcesses();
            current = current.next;
        }

        System.out.println("\nAll processes have been completed.");
        displayAverageTimes();
    }

    // Display the circular queue of processes
    public void displayProcesses() {
        if (head == null) return;

        System.out.println("Processes in queue:");
        Process temp = head;
        do {
            System.out.println("P" + temp.processId + " | BT: " + temp.burstTime +
                               " | RT: " + temp.remainingTime +
                               " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Display average waiting and turnaround times
    public void displayAverageTimes() {
        Process temp = head;
        int totalWT = 0, totalTAT = 0, count = 0;

        Set<Integer> seen = new HashSet<>();

        do {
            if (!seen.contains(temp.processId)) {
                totalWT += temp.waitingTime;
                totalTAT += temp.turnAroundTime;
                seen.add(temp.processId);
                count++;
            }
            temp = temp.next;
        } while (temp != head);

        if (count > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWT / count);
            System.out.println("Average Turnaround Time: " + (double) totalTAT / count);
        }
    }
}

public class RoundRobin{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for Process " + i);
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();
            scheduler.addProcess(i, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        scheduler.simulate(tq);
    }
}

