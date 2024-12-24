package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private String title;
    private LocalDate deadline;
    private String priority;
    private boolean isCompleted;

    public Task(String title, LocalDate deadline, String priority, boolean isCompleted) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
