package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {

    Page<UniversityEntity> findByAddressIsLike(String like, Pageable pageable);

    Page<UniversityEntity> findTop10ByOrderByRate(Pageable pageable);

    default List<UniversityEntity> findTop10() {
        return this.findTop10ByOrderByRate(new PageRequest(0, 10)).getContent();
    }
}
