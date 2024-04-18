package com.EasyPeasy.AiProject.domain.techbook.repository;

import com.EasyPeasy.AiProject.domain.techbook.entity.TechbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechbookRepository extends JpaRepository<TechbookEntity,Long> {
}
