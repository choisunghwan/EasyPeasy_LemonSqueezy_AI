package com.EasyPeasy.AiProject.domain.guestbook.repository;

import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestbookCommentRepository extends JpaRepository<GuestbookCommentEntity,Long> {
    List<GuestbookCommentEntity> findByGuestbookId(Long guestbookId);
}
