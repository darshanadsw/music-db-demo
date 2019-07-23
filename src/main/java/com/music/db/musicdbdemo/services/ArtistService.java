package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getAllArtist();

    void saveArtist(Artist artist);

    void deleteArtistById(Long id);

}
