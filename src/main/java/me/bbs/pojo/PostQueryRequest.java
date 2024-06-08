package me.bbs.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostQueryRequest {
    private String title;
    private String content;
    private Long authorId;
    private Long categoryId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAtStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAtEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAtStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAtEnd;

    private Integer viewsCountMin;
    private Integer viewsCountMax;
    private String status;
}
