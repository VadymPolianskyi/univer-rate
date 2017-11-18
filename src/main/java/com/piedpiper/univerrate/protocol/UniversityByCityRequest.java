package com.piedpiper.univerrate.protocol;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public @Data
class UniversityByCityRequest extends Request{
    private String city;
    private int page;
    private int size;
    private Pageable pageable;
}
