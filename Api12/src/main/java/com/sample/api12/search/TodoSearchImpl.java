package com.sample.api12.search;

import com.querydsl.jpa.JPQLQuery;
import com.sample.api12.model.QTodoEntity;
import com.sample.api12.model.TodoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
    public TodoSearchImpl() {
        super(TodoEntity.class);
    }
    @Override
    public Page<TodoEntity> search1() {
        QTodoEntity todoEntity = QTodoEntity.todoEntity;
        JPQLQuery<TodoEntity> query = from(todoEntity);
        query.where(todoEntity.title.contains("1"));

        Pageable pageable = PageRequest
                .of(1, 10,
                        Sort.by("tno").descending());

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        query.orderBy(todoEntity.tno.desc());
        query.fetch();
        query.fetchCount();


        return null;
    }
}
