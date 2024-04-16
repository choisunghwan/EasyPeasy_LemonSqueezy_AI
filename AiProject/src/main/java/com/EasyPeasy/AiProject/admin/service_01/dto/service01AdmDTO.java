package com.EasyPeasy.AiProject.admin.service_01.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class service01AdmDTO {

    private String service_title; // 서비스 제목
    private String guide_content; // 가이드 내용
    private String serviceTarget; // 서비스 대상
    private String serviceType; // 서비스 유형
    private String selectionCriteria; // 신청 기준
    private String applicationMethod; // 신청 방법
}
