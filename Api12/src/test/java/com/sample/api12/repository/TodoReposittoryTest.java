package com.sample.api12.repository;

import com.sample.api12.model.TodoEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoReposittoryTest {
    @Autowired
    private TodoRepository todoRepository;

//    @Test
//    public void testInsert(){
//        TodoEntity todo = TodoEntity.builder()
//                .title("title")
//                .writer("writer...")
//                .dueDate(LocalDate.of(2024,10,14))
//                .build();
//
//        TodoEntity result = todoRepository.save(todo);
//        Log.info(result);
//    }
    @Test
    public void testRead(){
        Long tno = 1L;
        Optional<TodoEntity> result = todoRepository.findById(tno);
        TodoEntity todo = result.orElseThrow();
        log.info(todo);
    }
    @Test
    public void testUpdate(){
        Long tno = 1L;
        Optional<TodoEntity> result = todoRepository.findById(tno);
        TodoEntity todo = result.orElseThrow();

        todo.changeTitle("update title");
        todo.changeComplete(true);

        todoRepository.save(todo);
    }


}
