package com.sample.api12.service;

import com.sample.api12.dto.TodoDto;
import com.sample.api12.model.TodoEntity;

public interface TodoService {
    public TodoDto get(Long tno);
    public Long postTodo (TodoDto dto);
    public void modify(TodoDto dto);
    public void remove(Long tno);

    // 디폴트는 오버라이드를 하지 않으면 디폴트가 사용됨
    default TodoDto entityToDto(TodoEntity todo){
        TodoDto todoDto = TodoDto.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .write(todo.getWriter())
                .complete(todo.isComplete())
                .dueDate(todo.getDueDate())
                .build();
        return todoDto;
    }
    default TodoEntity dtoToEntity(TodoDto todoDto) {
        TodoEntity todoEntity = TodoEntity.builder()
                .tno(todoDto.getTno())
                .title(todoDto.getTitle())
                .writer(todoDto.getWrite())
                .complete(todoDto.isComplete())
                .dueDate(todoDto.getDueDate())
                .build();
        return todoEntity;
    }
}
