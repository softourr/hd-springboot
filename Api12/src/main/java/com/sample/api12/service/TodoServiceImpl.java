package com.sample.api12.service;

import com.sample.api12.dto.PageRequestDto;
import com.sample.api12.dto.PageResponseDto;
import com.sample.api12.dto.TodoDto;
import com.sample.api12.model.TodoEntity;
import com.sample.api12.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDto<TodoDto> getList(PageRequestDto pageRequestDto) {
        Page<TodoEntity> result = todoRepository.search1(pageRequestDto);

        List<TodoDto> dtoList
                = result.get().map(todo -> entityToDto(todo)).collect(Collectors.toList());

        PageResponseDto<TodoDto> responseDto = PageResponseDto.<TodoDto>withAll()
                .dtoList(dtoList)
                .pageRequestDto(pageRequestDto)
                .total(result.getTotalElements())
                .build();

        return responseDto;
    }


}
