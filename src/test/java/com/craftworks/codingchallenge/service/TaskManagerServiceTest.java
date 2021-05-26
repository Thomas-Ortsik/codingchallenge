package com.craftworks.codingchallenge.service;

import com.craftworks.codingchallenge.domain.Task;
import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.repo.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TaskManagerServiceTest {

    @Autowired
    TaskManagerService service;
    @MockBean
    TaskRepository repository;

    TaskDTO testTaskDTO = new TaskDTO();
    Task testTask = new Task();
    @Test
    void getAll() {
        service.getAll();
        Mockito.verify(repository).findByOrderByCreatedatAsc();
    }

    @Test
    void getFirstInQueue() {
        service.getFirstInQueue();
        Mockito.verify(repository).findFirstByOrderByCreatedatAsc();
    }

    @Test
    void saveNewTask() {
        service.saveNewTask(testTaskDTO);
        Mockito.verify(repository).save(testTask);
    }

    @Test
    void updateTask() {
        service.updateTask(testTaskDTO);
        Mockito.verify(repository).save(testTask);
    }

    @Test
    void deleteTask() {
        service.deleteTask(testTaskDTO);
        Mockito.verify(repository).delete(testTask);
    }
}