package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.UniversityByCityHandler;
import com.piedpiper.univerrate.protocol.UniversityByCityRequest;
import com.piedpiper.univerrate.protocol.UniversityByCityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    private final UniversityByCityHandler universityByCityHandler;

    @Autowired
    public UniversityController(UniversityByCityHandler universityByCityHandler) {
        this.universityByCityHandler = universityByCityHandler;
    }

    @GetMapping("/in/{city}")
    public UniversityByCityResponse universityByCity(@PathVariable String city, Pageable pageable) {
        return universityByCityHandler.handle(new UniversityByCityRequest(city, pageable));
    }
}
