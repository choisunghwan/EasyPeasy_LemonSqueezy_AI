package com.EasyPeasy.AiProject.domain.guestbook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestbookController {


    /* S: 방문록 리스트*/
    @GetMapping("/guestbook_list")
    public String showGuestBookPageList() {
        return "user/pattern/guestbook/guestbook-list";
    }

    @GetMapping("/guestbook_detail")
    public String showGuestBookPageDetail() {
        return "user/pattern/guestbook/guestbook-detail";
    }
}
