package com.EasyPeasy.AiProject.domain.techbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TechbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // 게시물의 고유 식별자
    private String title; // 게시물 제목
    private String content; // 게시물의 내용
    private String author; // 게시물을 작성한 사용자의 이름이나 아이디 입니다.
    private LocalDateTime createdAt;  // 게시물이 작성된 일시 입니다.




}
