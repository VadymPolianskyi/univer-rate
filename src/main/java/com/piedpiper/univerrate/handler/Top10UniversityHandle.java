package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.service.UniversityService;
import com.piedpiper.univerrate.protocol.Top10UniversitiesRequest;
import com.piedpiper.univerrate.protocol.Top10UniversitiesResponse;
import com.piedpiper.univerrate.protocol.dto.UniversityDto;
import com.piedpiper.univerrate.service.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Top10UniversityHandle implements Handler<Top10UniversitiesRequest, Top10UniversitiesResponse> {

    private final UniversityService universityService;
    private final Mapper mapper;

    @Autowired
    public Top10UniversityHandle(UniversityService universityService, Mapper mapper) {
        this.universityService = universityService;
        this.mapper = mapper;
    }

    @Override
    public Top10UniversitiesResponse handle(Top10UniversitiesRequest request) {

        List<UniversityDto> universities = universityService.getTop10()
                .stream()
                .map(mapper::mapUniversity)
                .collect(Collectors.toList());

        log.info("Returned top 10 of universities.");
        return new Top10UniversitiesResponse(universities);
    }
}
