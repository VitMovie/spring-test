package com.example.demo;

import com.example.demo.model.Song;
import com.example.demo.repositories.SongRepository;
import com.example.demo.service.SongService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
class SongServiceTest {

    @Autowired
    private SongService songService;

    @MockBean
    private SongRepository songRepository;

    @Test
    public void testGetSongById() throws Exception {
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid, "hello", "world");

        Optional<Song> result = songService.getSongById(uuid);
        assertThat(result).isEqualTo(song);
    }
}
