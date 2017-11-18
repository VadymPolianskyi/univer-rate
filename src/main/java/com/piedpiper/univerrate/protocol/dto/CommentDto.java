package com.piedpiper.univerrate.protocol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class CommentDto {
    private String id;

    @JsonProperty("author_email")
    private String authorEmail;

    @JsonProperty("author_name")
    private String authorName;

    private String content;

    @JsonProperty("university_id")
    private String universityId;

    private int rate;

    private long date;
}
