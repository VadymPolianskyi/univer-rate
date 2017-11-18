package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {

    List<UniversityEntity> findAllByAddressLike(String like);
}
