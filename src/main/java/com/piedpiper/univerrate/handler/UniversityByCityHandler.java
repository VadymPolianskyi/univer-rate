package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.dao.service.UniversityService;
import com.piedpiper.univerrate.protocol.UniversityByCityRequest;
import com.piedpiper.univerrate.protocol.UniversityByCityResponse;
import com.piedpiper.univerrate.protocol.dto.UniversityDto;
import com.piedpiper.univerrate.service.Mapper;
import com.piedpiper.univerrate.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Slf4j
public class UniversityByCityHandler implements Handler<UniversityByCityRequest,UniversityByCityResponse> {

    private final UniversityService universityService;
    private final Mapper mapper;
    private final RateService rateService;

    @Autowired
    public UniversityByCityHandler(UniversityService universityService, Mapper mapper, RateService rateService) {
        this.universityService = universityService;
        this.mapper = mapper;
        this.rateService = rateService;
    }

    @Override
    public UniversityByCityResponse handle(UniversityByCityRequest request) {

        List<UniversityDto> universities = universityService.getByCity(request.getCity(), request.getPageable())
                .stream()
                .peek(university -> university.setRate(rateService.getRate(university)))
                .map(mapper::mapUniversity)
                .collect(toList());

        log.info("Returned list of universities from '{}' city", request.getCity() );
        return new UniversityByCityResponse(universities);
    }
}
