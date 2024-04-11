package com.EasyPeasy.AiProject.domain.guestbook.repository;


import com.EasyPeasy.AiProject.domain.guestbook.entity.GuestbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long> {
    
}
