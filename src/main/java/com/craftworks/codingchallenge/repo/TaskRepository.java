package com.craftworks.codingchallenge.repo;

import com.craftworks.codingchallenge.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByOrderByCreatedAtAsc();
    Optional<Task> findFirstByOrderByCreatedAtAsc();

}
