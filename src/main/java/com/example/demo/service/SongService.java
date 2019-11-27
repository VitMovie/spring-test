package com.example.demo.service;

import com.example.demo.dao.SongDAO;
import com.example.demo.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {

    private final SongDAO songDao;

    @Autowired
    public SongService(@Qualifier("fakeDao") SongDAO songDao) {
        this.songDao = songDao;
    }

    public int addSong(Song song) {
        return songDao.insertSong(song);
    }

    public List<Song> getAllSong() {
        return songDao.selectAllSong();
    }

    public Optional<Song> getSongById(UUID id) {
        return songDao.selectSongById(id);
    }

    public int deleteSong(UUID id) {
        return songDao.deleteSongById(id);
    }

    public int updateSong(UUID id, Song newSong) {
        return songDao.updateSongById(id, newSong);
    }
}
