package com.trilogyed.rsvp.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.rsvp.controller.RsvpController;
import com.trilogyed.rsvp.model.Rsvp;
import com.trilogyed.rsvp.repository.RsvpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RsvpRepository repo; //RSVPrepository repo = mock(RsvpRepository.class) when you don't want to use a real repository.

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateNewRsvpOnPostRequest() throws Exception {
        Rsvp inputRsvp = new Rsvp();
        inputRsvp.setName("jeff");
        inputRsvp.setTotalAttending(9);

        String inputRsvpJson = mapper.writeValueAsString(inputRsvp);

        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setName("jeff");
        outputRsvp.setTotalAttending(9);
        outputRsvp.setId(1);

       // doReturn(outputRsvp).when(repo).save(inputRsvp);
        doNothing().when(repo).save(inputRsvp);


        String outputRsvpJson = mapper.writeValueAsString(outputRsvp);

        // Act
        mockMvc.perform(post("/rsvps")
                        .content(inputRsvpJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputRsvpJson));
    }

    @Test
    public void shouldReturnRsvpById() throws Exception {

    }

    @Test
    public void shouldBStatusOkForNonExistentRsvpId() throws Exception {
    }

    @Test
    public void shouldReturnAllRsvps() throws Exception {
    }

    @Test
    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
        Rsvp inputRsvp = new Rsvp();
        inputRsvp.setName("jeff");
        inputRsvp.setTotalAttending(9);

        String inputRsvpJson = mapper.writeValueAsString(inputRsvp);

//        doNothing().when(repo).save(inputRsvp);

        mockMvc.perform(put("/rsvps")
                        .content(inputRsvpJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(status().isCreated())
//                .andExpect(content().json(outputRsvpJson));

    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {

        mockMvc.perform(delete("/rsvps/1231")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

}