package com.EasyPeasy.AiProject.domain.service_01.controller;

import com.EasyPeasy.AiProject.admin.service_01.dto.service01AdmDTO;
import com.EasyPeasy.AiProject.domain.service_01.dto.service01ReservationDTO;
import com.EasyPeasy.AiProject.domain.service_01.service.service01Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class service_01_Controller {

    @Autowired
    private service01Service service01Service;


    /* S: 등록된 서비스 조회 */
    @GetMapping("/service_01/{id}")
    public String showService_01Page(@PathVariable("id") Long id, Model model) {
        service01AdmDTO serviceDetail = service01Service.getServiceById(id);
        model.addAttribute("serviceDetail", serviceDetail);
        return "user/pattern/service_01/service_01-detail"; // 특정 서비스 페이지를 표시할 뷰 페이지
    }
    /* E: 등록된 서비스 조회 */


    /* S: 서비스 신청 */
    @PostMapping("/submit-reservation")
    public ResponseEntity<String>reserve(@RequestBody service01ReservationDTO service01ReservationDTO) {
        service01Service.makeReservation(service01ReservationDTO);
        return ResponseEntity.ok("reservation successful");
    }

    /* E: 서비스 신청 */


}
