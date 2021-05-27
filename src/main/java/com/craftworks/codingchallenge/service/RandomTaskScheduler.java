package com.craftworks.codingchallenge.service;

import com.craftworks.codingchallenge.domain.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableScheduling
public class RandomTaskScheduler {

    @Autowired
    private TaskManagerService taskManagerService;

    public RandomTaskScheduler(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @Scheduled(fixedDelayString = "#{new Double((T(java.lang.Math).random() + 1) * 5000).intValue()}")
    public void addTask(){
        LocalDateTime currentTime = LocalDateTime.now();
        TaskDTO newTaskDTO = new TaskDTO(
                currentTime,
                currentTime,
                null,
                null,
                "Automated Task",
                "Task created by Random Scheduler",
                null,
                null,
                "RandomTaskScheduler"
        );
        taskManagerService.saveNewTask(newTaskDTO);
    }
}
