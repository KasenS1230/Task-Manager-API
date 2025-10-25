package com.kasen.demo.repository;

import com.kasen.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends JpaRepository<Task, Long> {


}
