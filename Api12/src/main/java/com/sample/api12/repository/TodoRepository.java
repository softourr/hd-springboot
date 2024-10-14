package com.sample.api12.repository;

import com.sample.api12.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository
        extends JpaRepository<TodoEntity, Long> {
    // 인자로 엔티티와 그 기본키타입 지정
}
