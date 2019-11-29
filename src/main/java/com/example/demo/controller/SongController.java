package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/songs")
@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public void addSong(@Valid @NotNull @RequestBody Song song) {
        songService.addSong(song);
    }

    @GetMapping
    public List<Song> getAllSong() {
        return songService.getAllSong();
    }

    @GetMapping(path = "/{id}")
    public Song getSongById(@PathVariable("id") UUID id) {
        return songService.getSongById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSongById(@PathVariable("id") UUID id) {
        songService.deleteSong(id);
    }

    @PutMapping(path = "{id}")
    public void updateSong(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Song newSong) {
        songService.updateSong(id, newSong);
    }
}
