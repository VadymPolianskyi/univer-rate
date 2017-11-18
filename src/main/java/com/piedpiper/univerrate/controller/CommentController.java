package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.First10CommentsHandler;
import com.piedpiper.univerrate.handler.UploadCommentHandler;
import com.piedpiper.univerrate.protocol.First10CommentsRequest;
import com.piedpiper.univerrate.protocol.First10CommentsResponse;
import com.piedpiper.univerrate.protocol.UploadCommentRequest;
import com.piedpiper.univerrate.protocol.UploadCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final UploadCommentHandler uploadCommentHandler;
    private final First10CommentsHandler first10CommentsHandler;

    @Autowired
    public CommentController(UploadCommentHandler uploadCommentHandler, First10CommentsHandler first10CommentsHandler) {
        this.uploadCommentHandler = uploadCommentHandler;
        this.first10CommentsHandler = first10CommentsHandler;
    }

    @PostMapping
    public UploadCommentResponse uploadComment(@RequestBody UploadCommentRequest request) {
        return uploadCommentHandler.handle(request);
    }

    @GetMapping
    public First10CommentsResponse getFirst10() {
        return first10CommentsHandler.handle(new First10CommentsRequest());
    }
}
