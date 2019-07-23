package com.music.db.musicdbdemo.repositories;

import com.music.db.musicdbdemo.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
