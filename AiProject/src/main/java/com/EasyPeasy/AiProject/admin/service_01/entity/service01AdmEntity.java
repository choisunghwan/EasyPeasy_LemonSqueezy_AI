package com.EasyPeasy.AiProject.admin.service_01.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class service01AdmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceTitle; // 서비스 제목
    private String guideContent; // 가이드 내용

    @Column(name = "service_target")
    private String serviceTarget; // 서비스 대상

    private String serviceType; // 서비스 유형

    private String selectionCriteria; // 선정 기준

    private String applicationMethod; // 신청 방법

}
