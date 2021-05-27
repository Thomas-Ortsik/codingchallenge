package com.craftworks.codingchallenge.domain;



import com.craftworks.codingchallenge.enums.Priority;
import com.craftworks.codingchallenge.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime dueDate;
    private LocalDateTime resolvedAt;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private String createdBy;

    public Task() {
    }

    public Task(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status, String createdBy) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.resolvedAt = resolvedAt;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdBy = createdBy;
    }

    public Task(int id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status, String createdBy) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.resolvedAt = resolvedAt;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(createdAt, task.createdAt) && Objects.equals(updatedAt, task.updatedAt) && Objects.equals(dueDate, task.dueDate) && Objects.equals(resolvedAt, task.resolvedAt) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(priority, task.priority) && Objects.equals(status, task.status) && Objects.equals(createdBy, task.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, dueDate, resolvedAt, title, description, priority, status, createdBy);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", dueDate=" + dueDate +
                ", resolvedAt=" + resolvedAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
