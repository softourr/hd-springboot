package com.sample.api12.service;

import com.sample.api12.dto.TodoDto;
import com.sample.api12.model.TodoEntity;
import com.sample.api12.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoDto get(Long tno) {
        Optional<TodoEntity> result = todoRepository.findById(tno);
        TodoEntity todo = result.orElseThrow();
        return entityToDto(todo);
    }

    @Override
    public Long postTodo(TodoDto dto) {
        TodoEntity todo = dtoToEntity(dto);
        TodoEntity result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modify(TodoDto dto) {
        Optional<TodoEntity> result = todoRepository.findById(dto.getTno());
        TodoEntity todo = result.orElseThrow();

        todo.changeTitle(dto.getTitle());
        todo.changeComplete(dto.isComplete());
        todo.changeDueDate(dto.getDueDate());

    }

    @Override
    public void remove(Long tno) {

    }
}
