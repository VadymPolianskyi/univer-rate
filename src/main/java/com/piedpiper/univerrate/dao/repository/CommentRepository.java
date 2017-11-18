package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {

    List<CommentEntity> findAllByUniversityId(String universityId);
    Page<CommentEntity> findAllAndOrderByDate(Pageable pageable);

    default List<CommentEntity> findFirst10() {
        return this.findAllAndOrderByDate(new PageRequest(0, 10)).getContent();
    }
}
