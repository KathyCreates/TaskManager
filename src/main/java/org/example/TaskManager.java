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
}

