package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private static final String FILENAME = "tasks.ser";
    private List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter deadline (yyyy-MM-dd): ");
        LocalDate deadline = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        tasks.add(new Task(title, deadline, priority, false));
        System.out.println("Task added successfully.");
    }

    private void viewTask(Scanner scanner) {
        if(tasks.isEmpty()) {
            System.out.println("There are no tasks to view");
            return;
        }

        tasks.sort(Comparator.comparing(Task::getDeadline).thenComparing(Task::getPriority));

        System.out.printf("\n%-5s %-20s %-15s %-10s %-10s\n", "ID", "Title", "Deadline", "Priority", "Status");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%-5d %-20s %-15s %-10s %-10s\n",
                    i + 1, task.getTitle(), task.getDeadline(), task.getPriority(), task.isCompleted() ? "Completed" : "Pending");
        }
    }
}

