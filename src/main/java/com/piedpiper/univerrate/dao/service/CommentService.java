package com.piedpiper.univerrate.dao.service;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import com.piedpiper.univerrate.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public CommentEntity save(CommentEntity commentEntity) {
        return repository.save(commentEntity);
    }

    public List<CommentEntity> findByUniversity(String universityId) {
        List<CommentEntity> comments = repository.findAllByUniversityId(universityId);
        comments.sort(Comparator.comparingDouble(CommentEntity::getDate));
        return comments;
    }

    public List<CommentEntity> findTheMostPopular() {
        return repository.findTop10ByOrderByDate();
    }
}
