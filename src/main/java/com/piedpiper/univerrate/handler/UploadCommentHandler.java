package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.service.CommentService;
import com.piedpiper.univerrate.protocol.UploadCommentRequest;
import com.piedpiper.univerrate.protocol.UploadCommentResponse;
import com.piedpiper.univerrate.service.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UploadCommentHandler implements Handler <UploadCommentRequest, UploadCommentResponse> {

    private final CommentService commentService;
    private final Mapper mapper;

    @Autowired
    public UploadCommentHandler(CommentService commentService, Mapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @Override
    public UploadCommentResponse handle(UploadCommentRequest request) {

        commentService.save(mapper.revertComment(request.getComment()));
        log.info("Uploaded new comment from {} to university with id {}",
                request.getComment().getAuthorEmail(), request.getComment().getUniversityId());
        return new UploadCommentResponse();
    }
}
