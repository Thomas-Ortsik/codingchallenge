package com.craftworks.codingchallenge.endpoint;

import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{id}")
    TaskDTO fetchSpecificTask(@PathVariable int id){
        Optional<TaskDTO> oTaskDTO = taskManagerService.getTaskFromUUID(id);
        if (oTaskDTO.isEmpty())
            return null;
        return oTaskDTO.get();
    }

    // hier gabs etwas verwirrung von meiner Seite. Ursprünglich hats ja geheißen FIFO, auf nachfrage war aber dann von ID die Rede.
    // ich lass den endpoint fürs FIFO prinzip mal so stehen, würd mich aber über Feedback freuen.
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
    TaskDTO createTask(@RequestBody TaskDTO newTask){
        return taskManagerService.saveNewTask(newTask);
    }

    @PutMapping
    TaskDTO updateTask(@RequestBody TaskDTO taskToUpdate){
        Optional<TaskDTO> oUpdatedTask = taskManagerService.updateTask(taskToUpdate);
        if (oUpdatedTask.isEmpty()){
            return null;
        }
        else {
            return oUpdatedTask.get();
        }
    }

    @DeleteMapping
    void deleteTask(@RequestBody TaskDTO taskToDelete){
        taskManagerService.deleteTask(taskToDelete);
    }

}
