package com.craftworks.codingchallenge.service;

import com.craftworks.codingchallenge.domain.Task;
import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.repo.TaskRepository;
import com.craftworks.codingchallenge.translator.TaskTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskManagerService {
    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final TaskTranslator translator;


    public TaskManagerService(TaskRepository taskRepository, TaskTranslator translator) {
        this.taskRepository = taskRepository;
        this.translator = translator;
    }


    public List<TaskDTO> getAll(){
        return taskRepository.findByOrderByCreatedAtAsc().stream().map(translator::toTaskDTO).collect(Collectors.toList());
    }

    public Optional<TaskDTO> getFirstInQueue(){
        Optional<Task> oFirstTask = taskRepository.findFirstByOrderByCreatedAtAsc();

        if (oFirstTask.isEmpty())
            return Optional.empty();

        Task firstTask = oFirstTask.get();
        TaskDTO firstTaskDTO = translator.toTaskDTO(firstTask);
        return Optional.of(firstTaskDTO);
    }

    public Optional<TaskDTO> getTaskFromUUID(int id){
        Task requestedTask = taskRepository.getById(id);

        if (requestedTask == null)
            return Optional.empty();

        TaskDTO requestedTaskDTO = translator.toTaskDTO(requestedTask);
        return Optional.of(requestedTaskDTO);
    }

    // ich gehe hier davon aus, dass wir eine Task mit aktuellem "created/updatedAt" bekommen
    public TaskDTO saveNewTask(TaskDTO newTaskDTO){
        Task newTask = translator.toTask(newTaskDTO);
        taskRepository.save(newTask);
        newTaskDTO = translator.toTaskDTO(newTask);
        return newTaskDTO;
    }

    // siehe oben, in dem fall halt nur updatedAt.
    // W??re hier eine Kontrolle ob eine Task mit j??ngerem updatedAt field bereits gespeichert ist, sinnvoll?
    public Optional<TaskDTO>  updateTask(TaskDTO updatedTaskDTO){
        Task updatedTask = translator.toTask(updatedTaskDTO);
        Optional<Task> oTask = taskRepository.findById(updatedTask.getId());

        if (oTask.isEmpty())
            return Optional.empty();

        taskRepository.save(updatedTask);
        updatedTaskDTO = translator.toTaskDTO(updatedTask);
        return Optional.of(updatedTaskDTO);
    }

    public void deleteTask(TaskDTO taskToDeleteDTO){
        Task taskToDelete = translator.toTask(taskToDeleteDTO);
        taskRepository.delete(taskToDelete);
    }


}
