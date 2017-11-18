package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.service.CommentService;
import com.piedpiper.univerrate.protocol.First10CommentsRequest;
import com.piedpiper.univerrate.protocol.First10CommentsResponse;
import com.piedpiper.univerrate.protocol.dto.CommentDto;
import com.piedpiper.univerrate.service.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Slf4j
public class First10CommentsHandler implements Handler<First10CommentsRequest, First10CommentsResponse> {

    private final CommentService commentService;
    private final Mapper mapper;

    @Autowired
    public First10CommentsHandler(CommentService commentService, Mapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @Override
    public First10CommentsResponse handle(First10CommentsRequest request) {

        List<CommentDto> theMostPopular = commentService.findTheMostPopular()
                .stream()
                .map(mapper::mapComment)
                .collect(toList());

        log.info("Returned first 10 of the most famous comments.");
        return new First10CommentsResponse(theMostPopular);
    }
}
