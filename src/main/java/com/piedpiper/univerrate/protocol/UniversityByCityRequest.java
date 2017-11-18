package com.piedpiper.univerrate.protocol;


import org.springframework.data.domain.Pageable;

public class UniversityByCityRequest extends Request{
    private String city;
    private int page;
    private int size;
    private Pageable pageable;
}
