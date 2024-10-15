package com.sample.api12.search;

import com.querydsl.jpa.JPQLQuery;
import com.sample.api12.dto.PageRequestDto;
import com.sample.api12.model.QTodoEntity;
import com.sample.api12.model.TodoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
    public TodoSearchImpl() {
        super(TodoEntity.class);
    }
    @Override
    public Page<TodoEntity> search1(PageRequestDto pageRequestDto) {
        QTodoEntity todoEntity = QTodoEntity.todoEntity;
        JPQLQuery<TodoEntity> query = from(todoEntity);
        // query.where(todoEntity.title.contains("1test"));

        Pageable pageable = PageRequest
                .of(pageRequestDto.getPage()-1, pageRequestDto.getSize(),
                        Sort.by("tno").descending());

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        query.orderBy(todoEntity.tno.desc());
        List<TodoEntity> list = query.fetch();
        long total = query.fetchCount();

        return new PageImpl<>(list, pageable, total);
    }
}
