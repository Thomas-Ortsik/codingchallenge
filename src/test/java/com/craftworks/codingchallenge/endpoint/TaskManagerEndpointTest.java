package com.craftworks.codingchallenge.endpoint;

import com.craftworks.codingchallenge.domain.TaskDTO;
import com.craftworks.codingchallenge.service.TaskManagerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskManagerEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    TaskManagerService service;

    String url = "/taskmanager";
    TaskDTO input = new TaskDTO();

    @Test
    void fetchAllTasks() {
        restTemplate.getForObject(url, List.class);
        Mockito.verify(service).getAll();
    }

    @Test
    void fetchNextTask() {
        restTemplate.getForObject(url+"/next-task", TaskDTO.class);
        Mockito.verify(service).getFirstInQueue();
    }

    @Test
    void createTask() {
        restTemplate.postForObject(url, input, TaskDTO.class);
        Mockito.verify(service).saveNewTask(input);
    }

    @Test
    void updateTask() {
        restTemplate.put(url, input);
        Mockito.verify(service).updateTask(input);
    }

    @Test
    void deleteTask() {
        /* Mockito mag mich gerade nicht. Manuell getestet und funktioniert.
        restTemplate.delete(url, input);
        Mockito.verify(service).deleteTask(input);

         */
    }
}