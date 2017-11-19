package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import com.piedpiper.univerrate.dao.service.CommentService;
import com.piedpiper.univerrate.dao.service.UniversityService;
import com.piedpiper.univerrate.protocol.UploadCommentRequest;
import com.piedpiper.univerrate.protocol.UploadCommentResponse;
import com.piedpiper.univerrate.service.Mapper;
import com.piedpiper.univerrate.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UploadCommentHandler implements Handler <UploadCommentRequest, UploadCommentResponse> {

    private final CommentService commentService;
    private final UniversityService universityService;
    private final RateService rateService;
    private final Mapper mapper;

    @Autowired
    public UploadCommentHandler(CommentService commentService, UniversityService universityService, RateService rateService, Mapper mapper) {
        this.commentService = commentService;
        this.universityService = universityService;
        this.rateService = rateService;
        this.mapper = mapper;
    }

    @Override
    public UploadCommentResponse handle(UploadCommentRequest request) {

        request.getComment().setDate(System.currentTimeMillis());

        commentService.save(mapper.revertComment(request.getComment()));

        //change universe rating
        UniversityEntity university = universityService.getById(request.getComment().getUniversityId());
        university.setRate(rateService.getRate(university));
        universityService.save(university);


        log.info("Uploaded new comment from {} to university {}",
                request.getComment().getAuthorEmail(), university.getName());
        return new UploadCommentResponse();
    }
}
