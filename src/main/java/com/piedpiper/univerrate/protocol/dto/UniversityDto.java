package com.piedpiper.univerrate.protocol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class UniversityDto {

    private String id;

    private String name;

    @JsonProperty("short_name")
    private String shortName;

    private String ownership;

    @JsonProperty("governing_body")
    private String governingBody;

    private String type;

    private String region;

    private String address;

    private double rate;
}
