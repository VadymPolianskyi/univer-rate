package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.First10CommentsHandler;
import com.piedpiper.univerrate.handler.LikeHandler;
import com.piedpiper.univerrate.handler.UploadCommentHandler;
import com.piedpiper.univerrate.protocol.*;
import com.piedpiper.univerrate.protocol.dto.CommentDto;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
public class CommentControllerTest extends DefaultControllerTest {

    @MockBean
    private UploadCommentHandler uploadCommentHandler;
    @MockBean
    private First10CommentsHandler first10CommentsHandler;
    @MockBean
    private LikeHandler likeHandler;


    private CommentDto comment = new CommentDto("3fsu204", "author@gmail.com", "Vania", "The best university", "fwo25hw2gbs", 4, 3658252, 2,4);

    private List<CommentDto> comments = Arrays.asList(
            comment,
            new CommentDto("sw989gh", "andriy@gmail.com", "Andriy", "Very bad university", "fwo25hw2gbs", 1, 2636363, 2,4),
            new CommentDto("f9esuf9s8d", "yevhene@gmail.com", "Yevhene", "Very bad university", "fwo25hw2gbs", 1, 2636363, 2,4),
            new CommentDto("sat4hn45h", "jni@gmail.com", "Jni", "Very bad university", "fojgoa09", 3, 2636363, 2,4),
            new CommentDto("dfh43h", "oauth@gmail.com", "Oauth", "Very bad university", "fwo25hw2gbs", 4, 2636363, 2,4),
            new CommentDto("r35grgrgrg", "ihar@gmail.com", "Ihar", "Very my university", "jeshg3003", 5, 2636363, 2,4),
            new CommentDto("k75rjwggf", "andriy@gmail.com", "Andriy", "Very good university", "ioowrt42", 4, 2636363, 2,2),
            new CommentDto("grgrt33g", "andriy@gmail.com", "Andriy", "Very bad university", "vbcfrt2r353", 2, 535839, 4,85),
            new CommentDto("sgfjry45yh", "andriy@gmail.com", "Andriy", "Very bad university", "aaaat4rtg", 4, 958224, 2,5),
            new CommentDto("sw989gh", "andriy@gmail.com", "Andriy", "Very bad university", "fwo25hw2gbs", 5, 2636363, 22,2)
    );

    @Test
    public void tesUploadComment() throws Exception {
        UploadCommentRequest request = new UploadCommentRequest(comment);
        UploadCommentResponse response = new UploadCommentResponse();

        when(uploadCommentHandler.handle(any())).thenReturn(response);

        String requestJson = mapper.writeValueAsString(request);
        String responseJson = mapper.writeValueAsString(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/comment")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("comment-upload",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("comment").description("Comment"),
                                fieldWithPath("comment.id").description("Comment's id"),
                                fieldWithPath("comment.author_email").description("Email of author from google"),
                                fieldWithPath("comment.author_name").description("Name of author from google"),
                                fieldWithPath("comment.content").description("Data of comment"),
                                fieldWithPath("comment.university_id").description("University id"),
                                fieldWithPath("comment.rate").description("Rate for university"),
                                fieldWithPath("comment.date").description("Comment's date")
                        ),
                        responseFields(
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }

    @Test
    public void testFirst10Comments() throws Exception {
        First10CommentsResponse response = new First10CommentsResponse(comments);

        when(first10CommentsHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("comments-last",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("comments").description("List of comment objects"),
                                fieldWithPath("comments[].id").description("Comment's id"),
                                fieldWithPath("comments[].author_email").description("Email of author from google"),
                                fieldWithPath("comments[].author_name").description("Name of author from google"),
                                fieldWithPath("comments[].content").description("Data of comment"),
                                fieldWithPath("comments[].university_id").description("University id"),
                                fieldWithPath("comments[].rate").description("Rate for university"),
                                fieldWithPath("comments[].date").description("Comment's date"),
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }

    @Test
    public void testLike() throws Exception {
        LikeResponse response = new LikeResponse();

        when(likeHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/like/sw989gh")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("like",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }

    @Test
    public void testDislike() throws Exception {
        LikeResponse response = new LikeResponse();

        when(likeHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/dislike/sw989gh")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("dislike",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }
}
