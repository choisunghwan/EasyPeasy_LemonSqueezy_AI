package com.EasyPeasy.AiProject.admin.service_01.controller;

import com.EasyPeasy.AiProject.admin.service_01.dto.service01AdmDTO;
import com.EasyPeasy.AiProject.admin.service_01.service.service01AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class service01AdmController {

    @Autowired
    private service01AdmService service01AdmService;


    /* S: 관리자 서비스 화면 보여주기 */
    @GetMapping("/service_01_adm")

    public String showService_01_adm() {
        return "admin/pattern/service_01/service_01-create";
    }
    /* E: 관리자 서비스 화면 보여주기 */


    /* S: 서비스 화면 등록 */
    @PostMapping("/register-service")
    public ResponseEntity<String> registerService(@RequestBody service01AdmDTO service01AdmDto) {
        // 서비스 등록 로직 구현
        // serviceRequest를 사용하여 받은 데이터를 처리하고, 서비스를 등록하는 작업을 수행합니다.
        service01AdmService.registerService(service01AdmDto);
        // 성공적으로 등록되었을 경우 응답
        return ResponseEntity.ok("서비스가 성공적으로 등록되었습니다.");
    }
    /* E: 서비스 화면 등록 */
}
