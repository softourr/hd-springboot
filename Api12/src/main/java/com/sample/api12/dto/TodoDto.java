package com.sample.api12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto
{
    private Long tno;
    private String title;
    private String write;
    private boolean complete;
    private LocalDate dueDate;

}
