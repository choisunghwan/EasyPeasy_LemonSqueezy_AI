package com.EasyPeasy.AiProject.domain.guestbook.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter

public class GuestbookCommentDTO {

    private Long guestbookId;
    private String content; // 댓글 내용
    private Date createdAt; // 댓글 생성 일시
    private Set<String> selectedCheckboxes; // 선택된 옵션들
    private String satisfaction; // 만족 여부 (라디오 버튼)

}
