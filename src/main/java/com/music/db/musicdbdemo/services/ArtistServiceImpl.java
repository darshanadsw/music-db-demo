package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Artist;
import com.music.db.musicdbdemo.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService{

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public List<Artist> getAllArtist() {
        List artists = new ArrayList();
        artistRepository.findAll().forEach(artists::add);
        return artists;
    }

    @Override
    public void saveArtist(Artist artist) {

    }

    @Override
    public void deleteArtistById(Long id) {

    }
}
