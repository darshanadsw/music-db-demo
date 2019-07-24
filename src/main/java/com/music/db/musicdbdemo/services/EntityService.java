package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Artist;

import java.util.List;

public interface EntityService<T> {

    List<T> getAll();

    void save(T o);

    void deleteById(Long id);

    void update(T artist);

    T findById(Long id);

}
