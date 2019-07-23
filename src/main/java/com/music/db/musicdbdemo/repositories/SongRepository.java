package com.music.db.musicdbdemo.repositories;

import com.music.db.musicdbdemo.domain.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Long> {
}
