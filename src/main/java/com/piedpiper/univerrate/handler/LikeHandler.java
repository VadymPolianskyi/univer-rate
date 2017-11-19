package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import com.piedpiper.univerrate.dao.service.CommentService;
import com.piedpiper.univerrate.protocol.LikeRequest;
import com.piedpiper.univerrate.protocol.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.piedpiper.univerrate.service.Constant.LIKE_STRATEGY;

@Component
public class LikeHandler implements Handler<LikeRequest, LikeResponse> {

    private final CommentService commentService;

    @Autowired
    public LikeHandler(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public LikeResponse handle(LikeRequest request) {

        CommentEntity comment = commentService.getById(request.getId());
        if (request.getStrategy().equals(LIKE_STRATEGY))
            comment.setLike(comment.getLike() + 1);
        else
            comment.setDislike(comment.getDislike() + 1);

        commentService.save(comment);

        return new LikeResponse();
    }
}
