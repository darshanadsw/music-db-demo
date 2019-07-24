package com.music.db.musicdbdemo.controllers;

import com.music.db.musicdbdemo.domain.Artist;
import com.music.db.musicdbdemo.services.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Artist>> listAllArtist(){
        return ResponseEntity.ok(artistService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findArtistById(@PathVariable Long id){
        return ResponseEntity.ok(artistService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Artist> createArtist(@Valid @RequestBody Artist artist){
        artistService.save(artist);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long id){
        artistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/update")
    public ResponseEntity<Artist> updateArtist(@Valid @RequestBody Artist artist){
        artistService.update(artist);
        return ResponseEntity.accepted().body(artist);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private void handleException(Exception e){
        log.error("Error occurred",e);
    }

}
