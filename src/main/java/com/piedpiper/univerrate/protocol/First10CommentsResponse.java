package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public @Data
class First10CommentsResponse extends Response{
    private List<CommentDto> comments;
}
