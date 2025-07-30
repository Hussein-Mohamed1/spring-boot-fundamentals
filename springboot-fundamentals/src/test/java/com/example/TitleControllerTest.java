package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TitleController.class)
public class TitleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppProperties appProperties;

    @Test
    public void testGetTitle() throws Exception {
        when(appProperties.getTitle()).thenReturn("Test Application Title");
        
        mockMvc.perform(get("/title"))
                .andExpect(status().isOk())
                .andExpect(content().string("Test Application Title"));
    }
} 