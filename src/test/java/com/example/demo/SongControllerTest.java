package com.example.demo;

import com.example.demo.controller.SongController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@RunWith(SpringRunner.class)
//@WebMvcTest(SongController.class)
//public class SongControllerTest {
//
//    private MockMvc mockMvc;
//    private String baseUrl = "/api/songs";
//
//    @MockBean
//    private SongController songController;
//
//    @Test
//    public void getSongs() throws Exception {
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(baseUrl)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//    }
//
//}
