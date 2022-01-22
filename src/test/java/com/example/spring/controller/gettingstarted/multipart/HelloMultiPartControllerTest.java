package com.example.spring.controller.gettingstarted.multipart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloMultiPartControllerTest
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Value("classpath:filePart.txt")
    private Resource fileResource;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void post() throws Exception
    {
        Hello hello = new Hello("Hello, Spring!");
        String jsonStr = this.objectMapper.writeValueAsString(hello);

        MockMultipartFile part01 = new MockMultipartFile("part01", null, MediaType.TEXT_PLAIN_VALUE, "This is part 01.".getBytes());
        MockMultipartFile part02 = new MockMultipartFile("part02", null, MediaType.APPLICATION_JSON_VALUE, jsonStr.getBytes());
        MockMultipartFile part03 = new MockMultipartFile("part03", null, MediaType.APPLICATION_OCTET_STREAM_VALUE, fileResource.getInputStream());

        mockMvc.perform(multipart("/hello").file(part01).file(part02).file(part03)).andDo(print()).andExpect(status().isNoContent());
    }
}
