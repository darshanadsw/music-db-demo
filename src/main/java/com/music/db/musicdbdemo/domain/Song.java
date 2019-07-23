package com.music.db.musicdbdemo.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Song extends BaseModel {

    private String name;

    private Integer track;

    @ManyToOne
    private Album album;
}
