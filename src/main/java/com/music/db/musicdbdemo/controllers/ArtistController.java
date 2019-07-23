package com.music.db.musicdbdemo.controllers;

import com.music.db.musicdbdemo.domain.Artist;
import com.music.db.musicdbdemo.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Artist>> listAllArtist(){
        List artists = new ArrayList();
        artistRepository.findAll().forEach(artists::add);
        return ResponseEntity.ok().body(artists);
    }

    @PostMapping("/save")
    public ResponseEntity<Artist> createArtist(@Valid @RequestBody Artist artist){
        artistRepository.save(artist);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long id){
        artistRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/update")
    public ResponseEntity<Artist> updateArtist(@Valid @RequestBody Artist artist){
        artistRepository.save(artist);
        return ResponseEntity.accepted().body(artist);
    }

}
