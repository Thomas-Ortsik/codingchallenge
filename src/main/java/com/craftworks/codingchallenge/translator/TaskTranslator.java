package com.craftworks.codingchallenge.translator;

import com.craftworks.codingchallenge.domain.Task;
import com.craftworks.codingchallenge.domain.TaskDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskTranslator {
    public Task toTask(TaskDTO taskDTO){
        return new Task(
                taskDTO.getId(),
                taskDTO.getCreatedAt(),
                taskDTO.getUpdatedAt(),
                taskDTO.getDueDate(),
                taskDTO.getResolvedAt(),
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.getPriority(),
                taskDTO.getStatus(),
                taskDTO.getCreatedBy()
        );
    }
    public TaskDTO toTaskDTO(Task task){
        return new TaskDTO(
                task.getId(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getDueDate(),
                task.getResolvedAt(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCreatedBy()
        );
    }
}
