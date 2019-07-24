package com.music.db.musicdbdemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Album extends BaseModel {

    private String name;

    private Integer yearReleased;

    @OneToMany
    private List<Song> songs;

    public Album(List<Song> songs){
        this.songs = songs;
    }



}
