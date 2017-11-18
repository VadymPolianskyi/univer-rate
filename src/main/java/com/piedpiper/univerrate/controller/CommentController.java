package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.UploadCommentHandler;
import com.piedpiper.univerrate.protocol.UploadCommentRequest;
import com.piedpiper.univerrate.protocol.UploadCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final UploadCommentHandler uploadCommentHandler;

    @Autowired
    public CommentController(UploadCommentHandler uploadCommentHandler) {
        this.uploadCommentHandler = uploadCommentHandler;
    }

    @PostMapping
    public UploadCommentResponse uploadComment(@RequestBody UploadCommentRequest request) {
        return uploadCommentHandler.handle(request);
    }

}
