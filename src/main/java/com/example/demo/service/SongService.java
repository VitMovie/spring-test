package com.example.demo.service;

import com.example.demo.repositories.SongRepository;
import com.example.demo.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(@Qualifier("fake") SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    public int addSong(Song song) {
        return songRepository.insertSong(song);
    }

    public List<Song> getAllSong() {
        return songRepository.selectAllSong();
    }

    public Optional<Song> getSongById(UUID id) {
        return songRepository.selectSongById(id);
    }

    public int deleteSong(UUID id) {
        return songRepository.deleteSongById(id);
    }

    public int updateSong(UUID id, Song newSong) {
        return songRepository.updateSongById(id, newSong);
    }

    public int count() {
        return this.songRepository.count();
    }
}
