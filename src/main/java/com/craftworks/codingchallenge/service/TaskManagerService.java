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
        return taskRepository.findByOrderByCreatedatAsc().stream().map(translator::toTaskDTO).collect(Collectors.toList());
    }

    public Optional<TaskDTO> getFirstInQueue(){
        Optional<Task> oFirstTask = taskRepository.findFirstByOrderByCreatedatAsc();
        if (oFirstTask.isEmpty()){
            return Optional.empty();
        }
        else {
            Task firstTask = oFirstTask.get();
            TaskDTO firstTaskDTO = translator.toTaskDTO(firstTask);
            return Optional.of(firstTaskDTO);
        }
    }

    public TaskDTO saveNewTask(TaskDTO newTaskDTO){
        Task newTask = translator.toTask(newTaskDTO);
        taskRepository.save(newTask);
        newTaskDTO = translator.toTaskDTO(newTask);
        return newTaskDTO;
    }

    public Optional<TaskDTO>  updateTask(TaskDTO updatedTaskDTO){
        Task updatedTask = translator.toTask(updatedTaskDTO);
        Optional<Task> oTask = taskRepository.findById(updatedTask.getId());
        if (oTask.isEmpty()){
            return Optional.empty();
        }
        else {
            taskRepository.save(updatedTask);
            updatedTaskDTO = translator.toTaskDTO(updatedTask);
            return Optional.of(updatedTaskDTO);
        }
    }

    public void deleteTask(TaskDTO taskToDeleteDTO){
        Task taskToDelete = translator.toTask(taskToDeleteDTO);
        taskRepository.delete(taskToDelete);
    }


}
