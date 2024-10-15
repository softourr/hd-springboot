package com.sample.api12.search;

import com.sample.api12.model.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
    public TodoSearchImpl() {
        super(TodoEntity.class);
    }
    @Override
    public Page<TodoEntity> search1() {
        return null;
    }
}
