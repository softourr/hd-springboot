package com.sample.api12.repository;

import com.sample.api12.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository
        extends JpaRepository<TodoEntity, Long> {
}
