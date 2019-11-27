package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Song {

    private final UUID id;
    @NotBlank
    private final String title;
    @NotBlank
    private final String author;

    public Song(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


}
