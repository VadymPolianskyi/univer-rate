package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.entity.CommentEntity;
import com.piedpiper.univerrate.dao.service.CommentService;
import com.piedpiper.univerrate.dao.service.UniversityService;
import com.piedpiper.univerrate.protocol.UniversityDetailsRequest;
import com.piedpiper.univerrate.protocol.UniversityDetailsResponse;
import com.piedpiper.univerrate.protocol.dto.CommentDto;
import com.piedpiper.univerrate.protocol.dto.UniversityDto;
import com.piedpiper.univerrate.service.Mapper;
import com.piedpiper.univerrate.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UniversityDetailsHandler implements Handler<UniversityDetailsRequest, UniversityDetailsResponse> {

    private final UniversityService universityService;
    private final CommentService commentService;
    private final Mapper mapper;
    private final RateService rateService;

    @Autowired
    public UniversityDetailsHandler(CommentService commentService, UniversityService universityService, Mapper mapper, RateService rateService) {
        this.commentService = commentService;
        this.universityService = universityService;
        this.mapper = mapper;
        this.rateService = rateService;
    }

    @Override
    public UniversityDetailsResponse handle(UniversityDetailsRequest request) {

        UniversityDto university = mapper.mapUniversity(universityService.getById(request.getId()));
        List<CommentEntity> commentEntities = commentService.findByUniversity(university.getId());

        List<CommentDto> comments = commentEntities.stream()
                .map(mapper::mapComment)
                .collect(Collectors.toList());

        double avgRate = rateService.getRate(commentEntities);
        university.setRate(avgRate);

        log.info("Returned details about '{}' with rate {}", university.getName(), avgRate);
        return new UniversityDetailsResponse(university, comments);
    }
}
