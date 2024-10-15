package com.sample.api12.service;

import com.sample.api12.dto.PageRequestDto;
import com.sample.api12.dto.PageResponseDto;
import com.sample.api12.dto.TodoDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Test
    public void testList(){
        PageRequestDto pageRequestDto =
                PageRequestDto.builder()
                        .page(2)
                        .size(10)
                        .build();
        PageResponseDto<TodoDto> response
                = todoService.getList(pageRequestDto);
        log.info(response);

    }
}
