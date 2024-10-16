package com.sample.api12.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Getter
@Builder // 빌더패턴이뭔데
@AllArgsConstructor
@NoArgsConstructor
@Entity // 데이터베이스의 테이블에 매핑
@ToString
@Table(name="tbl_todo") // 매핑될 테이블
public class TodoEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;
    private String title;
    private String writer;
    private boolean complete;
    private LocalDate dueDate;
    // 제목을 변경하는 메소드
    public void changeTitle(String title) {
        this.title = title;
    }

    // 완료 상태를 변경하는 메소드
    public void changeComplete(boolean complete) {
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}
