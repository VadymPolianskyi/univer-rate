package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.CommentDto;
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
class UniversityDetailsResponse extends Response{
    private UniversityDto university;
    private List<CommentDto> comments;
    private double rate;

}
