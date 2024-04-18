package com.EasyPeasy.AiProject.domain.techbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TechbookDTO {
    private Long id;        // 고유 식별자
    private String title;   // 게시물 제목
    private String content; // 게시물 내용
    private String author;  // 게시물 작성한 사용자의 이름이나 아이디
    private String createdAt;   // 게시물이 작성된 일시
}
