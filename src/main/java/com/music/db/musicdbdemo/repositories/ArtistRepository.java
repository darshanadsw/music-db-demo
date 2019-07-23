package com.music.db.musicdbdemo.repositories;

import com.music.db.musicdbdemo.domain.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist,Long> {
}
