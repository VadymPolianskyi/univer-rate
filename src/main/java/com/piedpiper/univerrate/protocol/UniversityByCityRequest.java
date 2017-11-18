package com.piedpiper.univerrate.protocol;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@NoArgsConstructor
public class UniversityByCityRequest extends Request{
    private String city;
    private int page;
    private int size;
    private Pageable pageable;
}
