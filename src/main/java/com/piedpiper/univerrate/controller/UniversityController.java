package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.UniversityByCityHandler;
import com.piedpiper.univerrate.handler.UniversityDetailsHandler;
import com.piedpiper.univerrate.protocol.UniversityByCityRequest;
import com.piedpiper.univerrate.protocol.UniversityByCityResponse;
import com.piedpiper.univerrate.protocol.UniversityDetailsRequest;
import com.piedpiper.univerrate.protocol.UniversityDetailsResponse;
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

    @Autowired
    public UniversityController(UniversityByCityHandler universityByCityHandler, UniversityDetailsHandler universityDetailsHandler) {
        this.universityByCityHandler = universityByCityHandler;
        this.universityDetailsHandler = universityDetailsHandler;
    }

    @GetMapping("/in/{city}")
    public UniversityByCityResponse universityByCity(
            @PathVariable String city, @PageableDefault(size = DEFAULT_PAGE_SIZE, page = 1) Pageable pageable) {
        return universityByCityHandler.handle(new UniversityByCityRequest(city, pageable));
    }

    @GetMapping("/details/{id}")
    public UniversityDetailsResponse universityDetails(@PathVariable String id) {
        return universityDetailsHandler.handle(new UniversityDetailsRequest(id));
    }
}
