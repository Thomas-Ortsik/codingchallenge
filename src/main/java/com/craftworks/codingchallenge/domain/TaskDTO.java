package com.craftworks.codingchallenge.domain;

import com.craftworks.codingchallenge.enums.Priority;
import com.craftworks.codingchallenge.enums.Status;

import java.time.LocalDateTime;
import java.util.Objects;


public class TaskDTO {
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

    public TaskDTO() {
    }

    public TaskDTO(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status, String createdBy) {
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

    public TaskDTO(int id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status, String createdBy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(createdAt, taskDTO.createdAt) && Objects.equals(updatedAt, taskDTO.updatedAt) && Objects.equals(dueDate, taskDTO.dueDate) && Objects.equals(resolvedAt, taskDTO.resolvedAt) && Objects.equals(title, taskDTO.title) && Objects.equals(description, taskDTO.description) && Objects.equals(priority, taskDTO.priority) && Objects.equals(status, taskDTO.status) && Objects.equals(createdBy, taskDTO.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, dueDate, resolvedAt, title, description, priority, status, createdBy);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
