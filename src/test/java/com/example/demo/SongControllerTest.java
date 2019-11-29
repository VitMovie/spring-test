package com.example.demo;

import com.example.demo.controller.SongController;
import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    private String baseUrl = "/api/songs/";

    @Test
    public void testCreateSong() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid,"hello", "world");

        this.mockMvc.perform(post(this.baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Obj.writeValueAsString(song)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllSong() throws Exception {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        List<Song> songs = Arrays.asList(
                new Song(uuid1,"hello1", "world1"),
                new Song(uuid2,"hello2", "world2"));
        when(songService.getAllSong()).thenReturn(songs);
        this.mockMvc.perform(get(this.baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\"id\":\"" + uuid1 + "\",\"title\":\"hello1\",\"author\":\"world1\"}," +
                        "{\"id\":\"" + uuid2 + "\",\"title\":\"hello2\",\"author\":\"world2\"}" +
                        "]"));
    }

    @Test
    void testGetSong() throws Exception {
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid,"hello", "world");
        when(songService.getSongById(uuid)).thenReturn(java.util.Optional.of(song));
        this.mockMvc.perform((get(this.baseUrl + uuid)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"" + uuid + "\",\"title\":\"hello\",\"author\":\"world\"},"));
    }

    @Test
    void testUpdateSong() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid,"hello", "world");

        this.mockMvc.perform(put(this.baseUrl + uuid)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Obj.writeValueAsString(song)))
                .andExpect(status().isOk());
    }

}

