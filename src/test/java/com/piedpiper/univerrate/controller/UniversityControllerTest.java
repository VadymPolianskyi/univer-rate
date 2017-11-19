package com.piedpiper.univerrate.controller;

import com.piedpiper.univerrate.handler.Top10UniversityHandler;
import com.piedpiper.univerrate.handler.UniversityByCityHandler;
import com.piedpiper.univerrate.handler.UniversityDetailsHandler;
import com.piedpiper.univerrate.protocol.*;
import com.piedpiper.univerrate.protocol.dto.CommentDto;
import com.piedpiper.univerrate.protocol.dto.UniversityDto;
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
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UniversityController.class)
public class UniversityControllerTest extends DefaultControllerTest {
    @MockBean
    private UniversityByCityHandler universityByCityHandler;
    @MockBean
    private UniversityDetailsHandler universityDetailsHandler;
    @MockBean
    private Top10UniversityHandler top10UniversityHandler;

    UniversityDto university = new UniversityDto("fwo25hw2gbs", "Vinnutsia National Technical University", "VNTU", "smth", "Goverment", "The best", "Vinnytsia", "st som 23", 5.0);


    private List<UniversityDto> universities = Arrays.asList(
            university,
            new UniversityDto("oawogsj225", "Kyiv Politechnic Institute", "KPI", "smth", "Goverment", "Not bad", "Kyiv", "st som 23", 3.2)
    );

    private List<CommentDto> comments = Arrays.asList(
            new CommentDto("3fsu204", "author@gmail.com", "Vania", "The best university", "fwo25hw2gbs", 4, 3658252, 4,75),
            new CommentDto("sw989gh", "andriy@gmail.com", "Andriy", "Very bad university", "fwo25hw2gbs", 1, 2636363, 22, 53)
    );


    @Test
    public void testUniversityByCityHandler() throws Exception {
        UniversityByCityResponse response = new UniversityByCityResponse(universities);

        when(universityByCityHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/university/in/%D0%9A%D0%98%D0%87%D0%92?page=1&size=2")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("universities",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("universities").description("List of universities"),
                                fieldWithPath("universities[].id").description("Id for requests"),
                                fieldWithPath("universities[].name").description("Full name of university"),
                                fieldWithPath("universities[].short_name").description("Short abbreviate of university"),
                                fieldWithPath("universities[].ownership").description("Ownership of university"),
                                fieldWithPath("universities[].governing_body").description("Governing body of university"),
                                fieldWithPath("universities[].type").description("University type(can be college, university, institute)"),
                                fieldWithPath("universities[].region").description("Short region of university"),
                                fieldWithPath("universities[].address").description("Full region of university"),
                                fieldWithPath("universities[].rate").description("Rate for university"),
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }

    @Test
    public void testUniversityDetails() throws Exception {
        UniversityDetailsResponse response = new UniversityDetailsResponse(university, comments);

        when(universityDetailsHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/university/details/fwo25hw2gbs")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("details",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("university").description("University object"),
                                fieldWithPath("university.id").description("Id for requests"),
                                fieldWithPath("university.name").description("Full name of university"),
                                fieldWithPath("university.short_name").description("Short abbreviate of university"),
                                fieldWithPath("university.ownership").description("Ownership of university"),
                                fieldWithPath("university.governing_body").description("Governing body of university"),
                                fieldWithPath("university.type").description("University type(can be college, university, institute)"),
                                fieldWithPath("university.region").description("Short region of university"),
                                fieldWithPath("university.address").description("Full region of university"),
                                fieldWithPath("university.rate").description("Avg of all rates from comments"),
                                fieldWithPath("comments").description("List of comments to this university"),
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
    public void testUniversityTop() throws Exception {
        Top10UniversitiesResponse response = new Top10UniversitiesResponse(universities);

        when(top10UniversityHandler.handle(any())).thenReturn(response);

        String responseJson = mapper.writeValueAsString(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/university/top")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson))
                .andDo(document("top",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("universities").description("List of universities"),
                                fieldWithPath("universities[].id").description("Id for requests"),
                                fieldWithPath("universities[].name").description("Full name of university"),
                                fieldWithPath("universities[].short_name").description("Short abbreviate of university"),
                                fieldWithPath("universities[].ownership").description("Ownership of university"),
                                fieldWithPath("universities[].governing_body").description("Governing body of university"),
                                fieldWithPath("universities[].type").description("University type(can be college, university, institute)"),
                                fieldWithPath("universities[].region").description("Short region of university"),
                                fieldWithPath("universities[].address").description("Full region of university"),
                                fieldWithPath("universities[].rate").description("Rate for university"),
                                fieldWithPath("code").description("Http code of response"),
                                fieldWithPath("message").description("Http message of response")
                        )));
    }
}
