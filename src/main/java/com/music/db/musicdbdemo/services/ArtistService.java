package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Artist;
import com.music.db.musicdbdemo.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements EntityService<Artist> {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artists::add);

        return artists;
    }

    @Override
    public void save(Artist o) {
        artistRepository.save(o);
    }

    @Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public void update(Artist o) {
        artistRepository.findById(o.getId()).ifPresent(artist -> {
            artist.setAlbums(o.getAlbums());
            artist.setName(o.getName());
            artistRepository.save(artist);
        });
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }
}
