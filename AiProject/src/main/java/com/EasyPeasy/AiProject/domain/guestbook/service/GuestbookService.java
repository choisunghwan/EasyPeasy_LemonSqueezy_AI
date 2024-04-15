package com.EasyPeasy.AiProject.domain.guestbook.service;

import com.EasyPeasy.AiProject.domain.guestbook.dto.GuestbookCommentDTO;
import com.EasyPeasy.AiProject.domain.guestbook.dto.GuestbookDTO;
import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookCommentEntity;
import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookEntity;
import com.EasyPeasy.AiProject.domain.guestbook.repository.GuestbookCommentRepository;
import com.EasyPeasy.AiProject.domain.guestbook.repository.GuestbookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestbookService {

    @Autowired
    private final GuestbookRepository guestbookRepository;    // 방명록 게시물 레포지토리 주입
    private final GuestbookCommentRepository guestbookCommentRepository; // 방명록 댓글 레포지토리 주입

    public GuestbookService(GuestbookRepository guestbookRepository,
                            GuestbookCommentRepository guestbookCommentRepository) {
        this.guestbookRepository = guestbookRepository;
        this.guestbookCommentRepository = guestbookCommentRepository;
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



    /* S: 댓글 등록 */
    public boolean createComment(GuestbookCommentDTO commentCreateDTO) {
        try {
            GuestbookCommentEntity commentEntity = new GuestbookCommentEntity();
            commentEntity.setContent(commentCreateDTO.getContent());
            // 게시물 ID 설정
            GuestbookEntity guestbookEntity = new GuestbookEntity();
            guestbookEntity.setId(commentCreateDTO.getGuestbookId());
            commentEntity.setGuestbook(guestbookEntity);
            commentEntity.setSatisfaction(commentCreateDTO.getSatisfaction());
            // 선택된 체크박스 값 설정
            commentEntity.setSelectedCheckboxes(commentCreateDTO.getSelectedCheckboxes());
            // 댓글 저장
            guestbookCommentRepository.save(commentEntity); // guestbookCommentRepository를 사용하여 저장
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /* E: 댓글 등록 */





    /* S: 댓글 목록 조회 */
    public List<GuestbookCommentDTO> getAllComments() {
        List<GuestbookCommentEntity> comments = guestbookCommentRepository.findAll();
        return comments.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    /* E: 댓글 목록 조회 */



    // 엔티티를 DTO로 변환하는 메서드
    private GuestbookCommentDTO convertEntityToDTO(GuestbookCommentEntity entity) {
        GuestbookCommentDTO dto = new GuestbookCommentDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // DTO를 엔티티로 변환하는 메서드
    private GuestbookCommentEntity convertDTOToEntity(GuestbookCommentDTO dto) {
        GuestbookCommentEntity entity = new GuestbookCommentEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

}