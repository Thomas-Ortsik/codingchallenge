package com.craftworks.codingchallenge.endpoint;

import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taskmanager")
public class TaskManagerEndpoint {

    @Autowired
    private TaskManagerService taskManagerService;

    public TaskManagerEndpoint(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @GetMapping
    List<TaskDTO> fetchAllTasks(){
        return taskManagerService.getAll();
    }

    @GetMapping("/next-task")
    TaskDTO fetchNextTask(){
        Optional<TaskDTO> oTaskDTO = taskManagerService.getFirstInQueue();
        if (oTaskDTO.isEmpty()){
            return null;
        }
        else {
            return oTaskDTO.get();
        }
    }

    @PostMapping
    TaskDTO createTask(TaskDTO newTask){
        return taskManagerService.saveNewTask(newTask);
    }

    @PutMapping
    TaskDTO updateTask(TaskDTO taskToUpdate){
        Optional<TaskDTO> oUpdatedTask = taskManagerService.updateTask(taskToUpdate);
        if (oUpdatedTask.isEmpty()){
            return null;
        }
        else {
            return oUpdatedTask.get();
        }
    }

    @DeleteMapping
    void deleteTask(TaskDTO taskToDelete){
        taskManagerService.deleteTask(taskToDelete);
    }

}
