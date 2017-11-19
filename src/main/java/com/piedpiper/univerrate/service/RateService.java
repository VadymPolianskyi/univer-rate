package com.piedpiper.univerrate.service;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import com.piedpiper.univerrate.dao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    private final CommentService commentService;

    @Autowired
    public RateService(CommentService commentService) {
        this.commentService = commentService;
    }

    public double getRate(UniversityEntity universityEntity) {
        return getRate(commentService.findByUniversity(universityEntity.getId()));

    }

    public double getRate(List<CommentEntity> comments) {
        long allRates = 0;

        for (CommentEntity comment : comments)
            allRates += comment.getRate();

        double avgRate = 0;

        if (comments.size() > 0)
            avgRate = (double) (allRates / comments.size());

        return avgRate;
    }
}
