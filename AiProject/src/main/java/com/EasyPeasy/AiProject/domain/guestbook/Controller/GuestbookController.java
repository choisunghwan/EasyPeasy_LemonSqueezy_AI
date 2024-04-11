package com.EasyPeasy.AiProject.domain.guestbook.Controller;

import com.EasyPeasy.AiProject.domain.guestbook.dto.GuestbookDTO;
import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookEntity;
import com.EasyPeasy.AiProject.domain.guestbook.service.GuestbookService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GuestbookController {
    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;

    }

    /* S: 방명록 리스트*/
    @GetMapping("/guestbook_list")
    public String showGuestBookList(Model model) {
        List<GuestbookEntity> guestbookEntities = guestbookService.getAllGuestbookEntries();
        model.addAttribute("guestbookEntries", guestbookEntities);
        return "user/pattern/guestbook/guestbook-list";
    }
    /* E: 방명록 리스트*/


    /* S: 방명록 글쓰기*/
    @GetMapping("/guestbook_create_page")
    public String showGuestBookCreate() {
        // 게시물 등록을 서비스에 요청하고 결과를 반환
        return "user/pattern/guestbook/guestbook-create";
    }
    /* E: 방명록 글쓰기*/


    /* S: 방명록 글쓰기 기능*/
    @PostMapping("/guestbook_create")
    public ResponseEntity<String> createGuestbook(@RequestBody GuestbookDTO guestbookDTO) {
        boolean result = guestbookService.createGuestbookEntry(guestbookDTO);
        if (result) {
            return ResponseEntity.ok("게시물이 성공적으로 등록되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 등록에 실패했습니다.");
        }
    }
    /* E: 방명록 글쓰기 기능*/


    /* S: 방명록 상세 조회 */
    @GetMapping("/guestbook_detail/{guestbookId}")
    public String showGuestbookDetail(@PathVariable(name = "guestbookId") Long id, Model model) {
        GuestbookEntity entry = guestbookService.getGuestbookById(id);
        model.addAttribute("entry", entry);
        return "user/pattern/guestbook/guestbook-detail";
    }

    /* E: 방명록 상세 조회 */


    /* S: 게시물 삭제 */
    @DeleteMapping("/guestbook_delete/{id}")
    public ResponseEntity<String> deleteGuestbook(@PathVariable Long id) {
        boolean result = guestbookService.deleteGuestbookById(id);
        if (result) {
            return ResponseEntity.ok("게시물이 성공적으로 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 삭제에 실패했습니다.");
        }
    }
    /* E: 게시물 삭제 */

    /* S: 방명록 수정 페이지 조회*/
    @GetMapping("/guestbook_edit/{id}")
    public String showGuestbookEditpage(@PathVariable("id")Long id, Model model) {
        GuestbookEntity entry = guestbookService.getGuestbookById(id);
        model.addAttribute("entry",entry);
        return "user/pattern/guestbook/guestbook-edit";
    }
    /* E: 방명록 수정 페이지 조회*/


    /* S: 방명록 수정*/
    @PutMapping("/update_guestbook/{guestbookId}")
    public ResponseEntity<String> updateGuestbook(@PathVariable(name = "guestbookId") Long id, @RequestBody GuestbookDTO guestbookDTO) {
        boolean isUpdated = guestbookService.updateGuestbook(id, guestbookDTO);
        if (isUpdated) {
            return ResponseEntity.ok().body("게시물이 성공적으로 수정되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("게시물 수정에 실패했습니다. 다시 시도해주세요.");
        }
    }
    /* E: 방명록 수정*/


}
