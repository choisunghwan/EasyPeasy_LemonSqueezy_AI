package com.EasyPeasy.AiProject.domain.techbook.controller;

import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookEntity;
import com.EasyPeasy.AiProject.domain.techbook.dto.TechbookDTO;
import com.EasyPeasy.AiProject.domain.techbook.entity.TechbookEntity;
import com.EasyPeasy.AiProject.domain.techbook.service.TechbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TechbookController {

    private final TechbookService techbookService;

    @Autowired
    public TechbookController(TechbookService techbookService) {
        this.techbookService = techbookService;
    }


    /* S: 기술 게시판 글쓰기 화면 조회*/
    @GetMapping("/techbook_create_page")
    public String showTechbookCreatePage() {
        return "user/pattern/techbook/techbook-create";
    }
    /* E: 기술 게시판 글쓰기 화면 조회 */


    /* S: 게시물 등록  */
    @PostMapping("/techbook_create")
    public ResponseEntity<String> createTechbook(@RequestBody TechbookDTO techbookDTO) {
        try{
            techbookService.registerTechbook(techbookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 성공적으로 등록되었습니다.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 등록 중 오류가 발생했습니다.");
        }
    }
    /* E: 게시물 등록  */

    /* S: 게시물 상세 조회*/
    @GetMapping("/techbook_detail/{techbookId}")
    public String showtechbookDetail(@PathVariable(name = "techbookId") Long id, Model model) {
        TechbookEntity entry = techbookService.getTechbookById(id);
        model.addAttribute("entry", entry);
        return "user/pattern/techbook/techbook-detail";
    }

    /* E: 게시물 상세 조회*/

    /* S: 게시물 목록 조회 */
    @GetMapping("/techbook_list")
    public String showTechbookListPage(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TechbookEntity> techbookPage = techbookService.getAllTechbookEntries(pageable);
        model.addAttribute("techbookEntries", techbookPage.getContent());  // 모델에 방명록 항목들을 추가합니다. getcontent() 메서드는 페이지의 내용을 가져옵니다.
        model.addAttribute("pageable", techbookPage);   // 모델에 페이지 정보를 추가합니다.
        return "user/pattern/techbook/techbook-list";
    }
    /* S: 게시물 목록 조회 */


    /* S: 게시물 삭제*/
    /* E: 게시물 삭제*/

    /* S: 게시물 수정 화면 조회*/
    /* E: 게시물 수정 화면 조회*/

    /* S: 게시물 수정*/
    /* E: 게시물 수정*/


    /* S: 댓글 등록*/
    /* E: 댓글 등록*/

    /* S: 댓글 목록 조회*/
    /* E: 댓글 목록 조회*/

}
