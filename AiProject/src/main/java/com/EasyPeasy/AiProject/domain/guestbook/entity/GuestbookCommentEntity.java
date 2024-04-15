package com.EasyPeasy.AiProject.domain.guestbook.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "guestbook_comments")
@Getter
@Setter

public class GuestbookCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date createdAt;


    /* 다대일 관계 : 다수의 댓글이 하나의 게시물과 관계를 맺음.*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestbook_id") // 어노테이션- 왜래키 매핑을 설정 (guestbook_id 라는 외래키 사용)
    private GuestbookEntity guestbook;


    @ElementCollection
    @CollectionTable(name = "guestbook_comment_options")
    private Set<String> selectedCheckboxes;

    @Column(nullable = false)
    private String satisfaction; // 만족 여부 (라디오 버튼)


    public GuestbookCommentEntity() {
        this.createdAt = new Date(); // 생성일자를 현재 시간으로 초기화 합니다.
    }

}
