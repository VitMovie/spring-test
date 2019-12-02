package com.example.demo.repositories;

import com.example.demo.model.Song;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SongRepository {

    int insertSong(UUID id, Song song);

    default int insertSong(Song song) {
        UUID id = UUID.randomUUID();
        return insertSong(id, song);
    }

    List<Song> selectAllSong();

    Optional<Song> selectSongById(UUID id);

    int deleteSongById(UUID id);

    int updateSongById(UUID id, Song song);

    int count();
}
