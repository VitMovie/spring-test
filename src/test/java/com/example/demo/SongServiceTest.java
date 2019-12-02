package com.example.demo;

import com.example.demo.model.Song;
import com.example.demo.repositories.SongRepository;
import com.example.demo.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongServiceTest {

    @Autowired
    private SongRepository songRepository;

    @Test
    public void testGetAllSongs() {
        Song song = new Song(UUID.randomUUID(), "title", "author");
        songRepository.insertSong(song);
        SongService songService = new SongService(songRepository);

        List<Song> songs = songService.getAllSong();
        Song actualSong = songs.get(songs.size()-1);

        assertEquals(song.getTitle(), actualSong.getTitle());
        assertEquals(song.getAuthor(), actualSong.getAuthor());
    }

    @Test
    public void testAddSong() {
        Song song = new Song(UUID.randomUUID(), "title", "author");
        songRepository.insertSong(song);
        SongService songService = new SongService(songRepository);

        assertEquals(1, songService.count());
    }

    @Test
    public void testSearchSongById() {
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid, "title", "author");
        songRepository.insertSong(song);
        SongService songService = new SongService(songRepository);

        Optional<Song> searchSong = songService.getSongById(uuid);
        if(searchSong.isPresent()) {
            assertEquals(uuid, searchSong.get().getId());
        }
        else assertEquals(true,false);
    }

}

//import com.example.demo.model.Song;
//import com.example.demo.repositories.SongRepository;
//import com.example.demo.service.SongService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SongServiceTest {
//
//
//    @Mock
//    private SongRepository songRepository;
//
//    @InjectMocks
//    private SongService songService;
//
//    @Test
//    public void testAllSongs() {
//        Song song = new Song(UUID.randomUUID(), "title", "author");
//
//        List<Song> mockSongs = Arrays.asList(song);
//
//
//        when(songRepository.selectAllSong()).thenReturn(mockSongs);
//
//
//        List<Song> result = songService.getAllSong();
//
//        assertTrue(result.size() == 1);
//    }
//}