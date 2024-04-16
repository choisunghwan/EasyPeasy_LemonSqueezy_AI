package com.EasyPeasy.AiProject.admin.service_01.repository;

import com.EasyPeasy.AiProject.admin.service_01.entity.service01AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface service01AdmRepository extends JpaRepository<service01AdmEntity,Long> {
}
