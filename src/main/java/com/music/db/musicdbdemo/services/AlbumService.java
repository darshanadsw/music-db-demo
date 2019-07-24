package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Album;
import com.music.db.musicdbdemo.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService implements EntityService<Album> {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Album> getAll() {
        List<Album> albums = new ArrayList<>();
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public void save(Album o) {
        albumRepository.save(o);
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public void update(Album o) {
        albumRepository.save(o);
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }
}
