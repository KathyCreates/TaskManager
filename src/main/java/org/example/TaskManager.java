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

    private void viewTask() {
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

    private void editTask(Scanner scanner) {
        viewTask();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task ID to edit: ");
        int id = scanner.nextInt() - 1;
        scanner.nextLine();

        if (id < 0 || id >= tasks.size()) {
            System.out.println("Invalid task ID");
            return;
        }

        Task task = tasks.get(id);
        System.out.println("Edited task: " + task.getTitle());

        System.out.print("Enter nem title (leave blanck to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) task.setTitle(newTitle);

        System.out.print("Enter new deadline (yyyy-MM-dd, leave blank to keep current): ");
        String newDeadline = scanner.nextLine();
        if (!newDeadline.isEmpty()) task.setDeadline(LocalDate.parse(newDeadline));

        System.out.print("Enter new priority (Low, Medium, High, leave blank to keep current): ");
        String newPriority = scanner.nextLine();
        if (!newPriority.isEmpty()) task.setPriority(newPriority);

        System.out.print("Mark as completed? (yes/no): ");
        String completed = scanner.nextLine();
        if (completed.equalsIgnoreCase("yes")) task.setCompleted(true);

        System.out.println("Task updated successfully.");
    }

    private void deleteTask(Scanner scanner) {
        viewTask();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt() - 1;
        scanner.nextLine();

        if (id < 0 || id >= tasks.size()) {
            System.out.println("Invalid task ID");
            return;
        }

        tasks.remove(id);
        System.out.println("Task deleted successfully.");
    }
}

