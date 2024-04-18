package com.EasyPeasy.AiProject.domain.techbook.service;

import com.EasyPeasy.AiProject.domain.techbook.dto.TechbookDTO;
import com.EasyPeasy.AiProject.domain.techbook.entity.TechbookEntity;
import com.EasyPeasy.AiProject.domain.techbook.repository.TechbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TechbookService {
    private final TechbookRepository techbookRepository;

    @Autowired
    public TechbookService(TechbookRepository techbookRepository) {
        this.techbookRepository = techbookRepository;
    }


    /* S: 게시물 등록 */
    public void registerTechbook(TechbookDTO techbookDTO) {
        TechbookEntity techbookEntity = new TechbookEntity();
        techbookEntity.setTitle(techbookDTO.getTitle());
        techbookEntity.setContent(techbookDTO.getContent());
        techbookEntity.setCreatedAt(LocalDateTime.now());

        techbookRepository.save(techbookEntity);
    }
    /* E: 게시물 등록 */


    /* S: 게시물 목록 조회*/
    public List<TechbookDTO> getAllTechbooks() {
        List<TechbookEntity> techbookEntities = techbookRepository.findAll();
        return techbookEntities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TechbookDTO mapToDTO(TechbookEntity techbookEntity) {
        TechbookDTO techbookDTO = new TechbookDTO();
        techbookDTO.setId(techbookEntity.getId());
        techbookDTO.setTitle(techbookEntity.getTitle());
        techbookDTO.setContent(techbookEntity.getContent());
        // 필요한 다른 속성들도 여기에 매핑
        return techbookDTO;
    }
    /* E: 게시물 목록 조회*/

    // 모든 기술 게시물 항목을 페이지로 가져오는 메서드
    public Page<TechbookEntity> getAllTechbookEntries(Pageable pageable) {
        return techbookRepository.findAll(pageable);
    }


    /* S: 게시물 상세 조회*/
    public TechbookEntity getTechbookById(Long id) {
        // TechbookRepository를 사용하여 ID에 해당하는 기술서 게시물 조회
        Optional<TechbookEntity> optionalTechbook = techbookRepository.findById(id);

        // 조회 결과가 존재하면 해당 기술서 게시물을 반환하고, 그렇지 않으면 예외 처리
        return optionalTechbook.orElseThrow(() -> new RuntimeException("기술서 게시물을 찾을 수 없습니다. ID: " + id));
    }

    /* E: 게시물 상세 조회*/



}
