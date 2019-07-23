package com.music.db.musicdbdemo.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
