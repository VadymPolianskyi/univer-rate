package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.UniversityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public @Data
class UniversityByCityResponse extends Response{
    private List<UniversityDto> universities;
}
