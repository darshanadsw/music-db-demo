package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Song;
import com.music.db.musicdbdemo.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements EntityService<Song> {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public List<Song> getAll() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    @Override
    public void save(Song o) {
        songRepository.save(o);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void update(Song o) {
        songRepository.save(o);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
