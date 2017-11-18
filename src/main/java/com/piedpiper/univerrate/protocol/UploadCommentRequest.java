package com.piedpiper.univerrate.protocol;

import com.piedpiper.univerrate.protocol.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class UploadCommentRequest extends Request {

    private CommentDto comment;

}
