package com.music.db.musicdbdemo.controllers;

import com.music.db.musicdbdemo.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    private final SongRepository songRepository;

    @Autowired
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
}
