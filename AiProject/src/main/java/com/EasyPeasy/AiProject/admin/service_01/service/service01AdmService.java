package com.EasyPeasy.AiProject.admin.service_01.service;

import com.EasyPeasy.AiProject.admin.service_01.dto.service01AdmDTO;
import com.EasyPeasy.AiProject.admin.service_01.entity.service01AdmEntity;
import com.EasyPeasy.AiProject.admin.service_01.repository.service01AdmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service01AdmService {

    @Autowired
    private service01AdmRepository service01AdmRepository;

    /**
     * 서비스를 등록합니다.
     *
     * @param service01AdmDTO 등록할 서비스 정보를 포함한 DTO
     */
    @Transactional
    public void registerService(service01AdmDTO service01AdmDTO) {
        service01AdmEntity service01AdmEntity = new service01AdmEntity(); // 새로운 서비스 엔티티 생성

        service01AdmEntity.setServiceTitle(service01AdmDTO.getService_title()); // 서비스 제목
        service01AdmEntity.setGuideContent(service01AdmDTO.getGuide_content()); // 서비스 가이드 내용
        service01AdmEntity.setServiceTarget(service01AdmDTO.getServiceTarget());// 서비스 대상
        service01AdmEntity.setServiceType(service01AdmDTO.getServiceType());// 서비스 유형
        service01AdmEntity.setSelectionCriteria(service01AdmDTO.getSelectionCriteria());// 선정 기준
        service01AdmEntity.setApplicationMethod(service01AdmDTO.getApplicationMethod());// 신청 방법
        service01AdmRepository.save(service01AdmEntity);
    }
}