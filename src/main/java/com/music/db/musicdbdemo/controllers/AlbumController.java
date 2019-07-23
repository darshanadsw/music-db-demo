package com.music.db.musicdbdemo.controllers;

import com.music.db.musicdbdemo.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
}
