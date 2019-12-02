package com.example.demo.repositories;

import com.example.demo.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class SongRepositoryImpl implements SongRepository {

    private static List<Song> DB = new ArrayList<>();

    @Override
    public int insertSong(UUID id, Song song) {
        DB.add(new Song(id, song.getTitle(), song.getAuthor()));
        return 0;
    }

    public int count() {
        return this.DB.size();
    }

    @Override
    public List<Song> selectAllSong() {
        return DB;
    }

    @Override
    public Optional<Song> selectSongById(UUID id) {
        return DB.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteSongById(UUID id) {
        Optional<Song> songMaybe = selectSongById((id));
        if (songMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(songMaybe.get());
        return 1;
    }

    @Override
    public int updateSongById(UUID id, Song newSong) {
        return selectSongById(id)
                .map(s -> {
                    int indexOfSongToUpdate = DB.indexOf(s);
                    if (indexOfSongToUpdate >= 0) {
                        DB.set(indexOfSongToUpdate, new Song(id, newSong.getTitle(), newSong.getAuthor()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
