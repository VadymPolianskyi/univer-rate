package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.UniversityDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UniversityByCityResponse extends Response{
    private List<UniversityDto> universities;
}
