package com.EasyPeasy.AiProject.domain.service_01.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class service01ReservationDTO {

    private Date reservationDate; // 신청 일자
    private String attachmentType; // 라디오 박스 선택 값
    private String additionalMessage; // 남길 말

}
