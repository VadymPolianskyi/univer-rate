package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {

    Page<UniversityEntity> findByAddressIsLike(String like, Pageable pageable);

    @Query("SELECT u FROM UniversityEntity u ORDER BY u.rate DESC")
    Page<UniversityEntity> findTop10(Pageable pageable);

    default List<UniversityEntity> findTop10() {
        return findTop10(new PageRequest(0, 10)).getContent();
    }
}
