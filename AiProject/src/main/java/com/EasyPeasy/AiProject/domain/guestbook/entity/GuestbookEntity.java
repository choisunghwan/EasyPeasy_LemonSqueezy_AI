package com.EasyPeasy.AiProject.domain.guestbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "guestbook")

public class GuestbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 엔티티의 고유한 식별자
    private String status; // 게시물의 상태를 나타냅니다.
    private String title; // 게시물의 제목입니다.
    private String content; // 게시물의 내용입니다.

    private LocalDateTime createdAt; // 게시물 등록 시간

    private String applicationPeriod; // 게시물의 신청 기간입니다.
    @ElementCollection
    private Set<String> tags; // 게시물의 태그를 나타내는 컬렉션입니다.

}
