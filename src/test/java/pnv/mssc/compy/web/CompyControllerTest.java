package pnv.mssc.compy.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pnv.mssc.compy.services.CompyService;
import pnv.mssc.compy.web.controller.CompyController;
import pnv.mssc.compy.web.model.CompyDto;

import java.util.UUID;


import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(CompyController.class)
public class CompyControllerTest {

    @MockBean
    CompyService compyService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CompyDto validCompy;

    @Before
    public void setUp() {
        validCompy = CompyDto.builder().id(UUID.randomUUID())
                .compyName("Sony")
                .compyStyle("Notebook")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getCompy() throws Exception {
        given(compyService.getCompyById(any(UUID.class))).willReturn(validCompy);

        mockMvc.perform(get("/api/v1/compy/" + validCompy.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validCompy.getId().toString())))
                .andExpect(jsonPath("$.compyName", is("Sony")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        CompyDto compyDto = validCompy;
        compyDto.setId(null);
        CompyDto savedDto = CompyDto.builder().id(UUID.randomUUID()).compyName("New Computer").build();
        String compyDtoJson = objectMapper.writeValueAsString(compyDto);

        given(compyService.savedCompy(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/compy/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(compyDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        CompyDto compyDto = validCompy;
        String compyDtoJson = objectMapper.writeValueAsString(compyDto);

        //when
        mockMvc.perform(put("/api/v1/compy/" + validCompy.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(compyDtoJson))
                .andExpect(status().isNoContent());

        then(compyService).should().updateCompy(any(), any());

    }
}
