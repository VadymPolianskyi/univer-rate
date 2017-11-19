package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.First10CommentsHandler;
import com.piedpiper.univerrate.handler.LikeHandler;
import com.piedpiper.univerrate.handler.UploadCommentHandler;
import com.piedpiper.univerrate.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.piedpiper.univerrate.service.Constant.DISLIKE_STRATEGY;
import static com.piedpiper.univerrate.service.Constant.LIKE_STRATEGY;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final UploadCommentHandler uploadCommentHandler;
    private final First10CommentsHandler first10CommentsHandler;
    private final LikeHandler likeHandler;

    @Autowired
    public CommentController(UploadCommentHandler uploadCommentHandler, First10CommentsHandler first10CommentsHandler, LikeHandler likeHandler) {
        this.uploadCommentHandler = uploadCommentHandler;
        this.first10CommentsHandler = first10CommentsHandler;
        this.likeHandler = likeHandler;
    }

    @PostMapping
    public UploadCommentResponse uploadComment(@RequestBody UploadCommentRequest request) {
        return uploadCommentHandler.handle(request);
    }

    @GetMapping
    public First10CommentsResponse getFirst10() {
        return first10CommentsHandler.handle(new First10CommentsRequest());
    }

    @GetMapping("/like/{id}")
    public LikeResponse like(@PathVariable String id) {
        return likeHandler.handle(new LikeRequest(id, LIKE_STRATEGY));
    }

    @GetMapping("/dislike/{id}")
    public LikeResponse dislike(@PathVariable String id) {
        return likeHandler.handle(new LikeRequest(id, DISLIKE_STRATEGY));
    }
}
