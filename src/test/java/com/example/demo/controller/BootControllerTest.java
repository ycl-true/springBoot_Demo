package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class BootControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // TEST123
    @Test
    public void getValues7() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/boot/getValues7"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        log.debug("111");
        log.info("222");
        log.error("333");

    }
}