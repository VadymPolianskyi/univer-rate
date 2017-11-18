package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {

    List<CommentEntity> findAllByUniversityId(String universityId);
}
