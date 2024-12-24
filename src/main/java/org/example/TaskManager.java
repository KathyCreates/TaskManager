package org.example;

import javafx.concurrent.Task;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private static final String FILENAME = "tasks.ser";
    private List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
    }
}
