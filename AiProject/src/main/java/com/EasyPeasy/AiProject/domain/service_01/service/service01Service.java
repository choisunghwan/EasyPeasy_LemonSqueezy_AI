package com.EasyPeasy.AiProject.domain.service_01.service;

import com.EasyPeasy.AiProject.admin.service_01.dto.service01AdmDTO;
import com.EasyPeasy.AiProject.admin.service_01.entity.service01AdmEntity;
import com.EasyPeasy.AiProject.admin.service_01.repository.service01AdmRepository;
import com.EasyPeasy.AiProject.domain.service_01.dto.service01ReservationDTO;
import com.EasyPeasy.AiProject.domain.service_01.entity.service01ReservationEntity;
import com.EasyPeasy.AiProject.domain.service_01.repository.service01ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class service01Service {

    @Autowired
    private service01AdmRepository service01AdmRepository;
    @Autowired
    private com.EasyPeasy.AiProject.domain.service_01.repository.service01ReservationRepository service01ReservationRepository;

    /**
     * 특정 ID를 기준으로 서비스를 가져옵니다.
     *
     * @param id 조회할 서비스의 ID
     * @return 조회된 서비스의 DTO
     */
    public service01AdmDTO getServiceById(Long id) {
        service01AdmEntity serviceEntity = service01AdmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 서비스를 찾을 수 없습니다: " + id));

        return entityToDTO(serviceEntity);
    }
    // Entity를 DTO로 변환하는 메서드
    private service01AdmDTO entityToDTO(service01AdmEntity entity) {
        service01AdmDTO dto = new service01AdmDTO();
        dto.setServiceTitle(entity.getServiceTitle());
        dto.setGuideContent(entity.getGuideContent());
        dto.setServiceTarget(entity.getServiceTarget());
        dto.setServiceType(entity.getServiceType());
        dto.setSelectionCriteria(entity.getSelectionCriteria());
        dto.setApplicationMethod(entity.getApplicationMethod());
        // 필요한 경우에 따라 추가적인 변환 작업 수행
        return dto;
    }


    /* S: 서비스 신청 */
    public void makeReservation(service01ReservationDTO reservationDTO) {
        service01ReservationEntity reservationEntity = new service01ReservationEntity();
        reservationEntity.setReservationDate(reservationDTO.getReservationDate());
        reservationEntity.setAttachmentType(reservationDTO.getAttachmentType());
        reservationEntity.setAdditionalMessage(reservationDTO.getAdditionalMessage());
        service01ReservationRepository.save(reservationEntity);
    }
    /* E: 서비스 신청 */



}
