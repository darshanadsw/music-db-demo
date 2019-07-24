package com.music.db.musicdbdemo.domain;

import lombok.Builder;
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
public class Artist extends BaseModel {

    private String name;

    @OneToMany
    private List<Album> albums;

    public Artist(List<Album> albums){
        this.albums = albums;
    }

}
