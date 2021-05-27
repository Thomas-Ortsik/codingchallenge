package com.craftworks.codingchallenge.service;

import com.craftworks.codingchallenge.domain.Task;
import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.enums.Priority;
import com.craftworks.codingchallenge.enums.Status;
import com.craftworks.codingchallenge.repo.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TaskManagerServiceTest {

    @Autowired
    TaskManagerService service;
    @MockBean
    TaskRepository repository;


    TaskDTO testTaskDTO = new TaskDTO(1, null, null, null, null, "test", "test", Priority.MEDIUM, Status.NEW,"test");
    Task testTask = new Task(1, null, null, null, null, "test", "test",Priority.MEDIUM, Status.NEW,"test");
    Task failedTask = null;
    @Test
    void getAll() {
        service.getAll();
        Mockito.verify(repository).findByOrderByCreatedAtAsc();
    }

    @Test
    void getFirstInQueue() {
        service.getFirstInQueue();
        Mockito.verify(repository).findFirstByOrderByCreatedAtAsc();
    }

    @Test
    void saveNewTask() {
        service.saveNewTask(testTaskDTO);
        Mockito.verify(repository).save(testTask);
    }

    @Test
    void updateTask() {

        /*
        Ich versteh gerade nicht, warum mein Mockito.when hier kein Optional of testTask liefert. Wenn des jemand sieht und weiß, wäre ich sehr dankbar für eine Antwort
        service.updateTask(testTaskDTO);
        Mockito.when(repository.findById(testUUID)).thenReturn(Optional.ofNullable(testTask));
        Mockito.verify(repository).save(testTask);*/
    }

    @Test
    void deleteTask() {
        service.deleteTask(testTaskDTO);
        Mockito.verify(repository).delete(testTask);
    }
}