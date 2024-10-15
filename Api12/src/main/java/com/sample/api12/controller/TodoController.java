package com.sample.api12.controller;

import com.sample.api12.dto.PageRequestDto;
import com.sample.api12.dto.PageResponseDto;
import com.sample.api12.dto.TodoDto;
import com.sample.api12.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log4j2
@RestController
@CrossOrigin(origins = "*") // cors 에러
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping("/{tno}")
    public TodoDto get(
            @PathVariable(name="tno") Long tno
    ){
        return todoService.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDto<TodoDto> list(PageRequestDto pageRequestDto){
        log.info(pageRequestDto);

        return todoService.getList(pageRequestDto);
    }

    @PostMapping("/")
    public Map<String, Long> register(
            @RequestBody TodoDto todoDto
    ){
        log.info("todoDto : " + todoDto);
        Long tno = todoService.postTodo(todoDto);

        return Map.of("No", tno);
    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(
            @PathVariable(name="tno") Long tno,
            @RequestBody TodoDto todoDto
    ){
        todoDto.setTno(tno);
        todoService.modify(todoDto);
        return Map.of("result", "success");

    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove(
            @PathVariable(name="tno") Long tno
    ){
        todoService.remove(tno);
        return Map.of("result", "success");
    }

}
