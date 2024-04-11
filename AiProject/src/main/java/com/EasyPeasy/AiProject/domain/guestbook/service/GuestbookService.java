package com.EasyPeasy.AiProject.domain.guestbook.service;

import com.EasyPeasy.AiProject.domain.guestbook.dto.GuestbookDTO;
import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookEntity;
import com.EasyPeasy.AiProject.domain.guestbook.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GuestbookService {

    @Autowired
    private final GuestbookRepository guestbookRepository;

    public GuestbookService(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }


    /* S: 방명록 등록 */
    public boolean createGuestbookEntry(GuestbookDTO guestbookDTO) {
        try {
            GuestbookEntity guestbookEntity = new GuestbookEntity();

            guestbookEntity.setTitle(guestbookDTO.getTitle());      // 제목
            guestbookEntity.setContent(guestbookDTO.getContent());  // 내용
            guestbookEntity.setCreatedAt(LocalDateTime.now());      // 등록 시간
            guestbookRepository.save(guestbookEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /* E: 방명록 등록 */

    /* S: 방명록 목록 조회*/
    public List<GuestbookEntity> getAllGuestbookEntries() {
        return guestbookRepository.findAll(); // 현재는 GuestbookRepository에서 모든 방문록 항목을 가져오는 메서드를 호출하도록 가정합니다.
    }
    /* E: 방명록 목록 조회*/


    /* S: 방명록 상세 조회*/
    public GuestbookEntity getGuestbookById(Long id) {
        Optional<GuestbookEntity> optionalGuestbook = guestbookRepository.findById(id);
        return optionalGuestbook.orElse(null);
    }

    /* E: 방명록 상세 조회*/

    /* S: 방명록 삭제 */
    public boolean deleteGuestbookById(Long id) {
        try {
            guestbookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /* E: 방명록 삭제 */

    /* S: 방명록 수정*/
    public boolean updateGuestbook(Long id, GuestbookDTO guestbookDTO) {
        try {
            Optional<GuestbookEntity> optionalGuestbook = guestbookRepository.findById(id);
            if (optionalGuestbook.isPresent()) {
                GuestbookEntity guestbookEntity = optionalGuestbook.get();
                guestbookEntity.setTitle(guestbookDTO.getTitle());
                guestbookEntity.setContent(guestbookDTO.getContent());
                guestbookRepository.save(guestbookEntity);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /* E: 방명록 수정*/


}