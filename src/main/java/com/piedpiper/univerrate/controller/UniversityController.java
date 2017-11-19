package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.Top10UniversityHandler;
import com.piedpiper.univerrate.handler.UniversityByCityHandler;
import com.piedpiper.univerrate.handler.UniversityDetailsHandler;
import com.piedpiper.univerrate.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    private final UniversityByCityHandler universityByCityHandler;
    private final UniversityDetailsHandler universityDetailsHandler;
    private final Top10UniversityHandler top10UniversityHandler;

    @Autowired
    public UniversityController(UniversityByCityHandler universityByCityHandler, UniversityDetailsHandler universityDetailsHandler, Top10UniversityHandler top10UniversityHandler) {
        this.universityByCityHandler = universityByCityHandler;
        this.universityDetailsHandler = universityDetailsHandler;
        this.top10UniversityHandler = top10UniversityHandler;
    }

    @GetMapping("/in/{city}")
    public UniversityByCityResponse universityByCity(
            @PathVariable String city, @PageableDefault(size = DEFAULT_PAGE_SIZE, page = 0) Pageable pageable) {
        return universityByCityHandler.handle(new UniversityByCityRequest(city, pageable));
    }

    @GetMapping("/details/{id}")
    public UniversityDetailsResponse universityDetails(@PathVariable String id) {
        return universityDetailsHandler.handle(new UniversityDetailsRequest(id));
    }

    @GetMapping("/top")
    public Top10UniversitiesResponse universityDetails() {
        return top10UniversityHandler.handle(new Top10UniversitiesRequest());
    }
}
