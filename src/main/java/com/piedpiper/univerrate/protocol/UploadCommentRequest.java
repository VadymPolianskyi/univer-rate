package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public @Data
class UploadCommentRequest extends Request {

    private CommentDto comment;

}
