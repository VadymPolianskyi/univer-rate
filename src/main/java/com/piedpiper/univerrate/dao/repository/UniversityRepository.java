package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {

    Page<UniversityEntity> findByAddressIsLike(String like, Pageable pageable);
}
