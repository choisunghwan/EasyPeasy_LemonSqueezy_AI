package com.EasyPeasy.AiProject.domain.service_01.repository;

import com.EasyPeasy.AiProject.domain.service_01.entity.service01ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface service01ReservationRepository extends JpaRepository<service01ReservationEntity, Long> {
}