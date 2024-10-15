package com.sample.api12.search;

import com.sample.api12.dto.PageRequestDto;
import com.sample.api12.model.TodoEntity;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<TodoEntity> search1(PageRequestDto pageRequestDto);
}
