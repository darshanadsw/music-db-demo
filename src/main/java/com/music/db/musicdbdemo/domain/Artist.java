package com.music.db.musicdbdemo.domain;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Artist extends BaseModel {

    private String name;

    @OneToMany
    private List<Album> albums;

    public Artist(List<Album> albums){
        this.albums = albums;
    }

}
