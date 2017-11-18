package com.piedpiper.univerrate.dao.repository;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
}
