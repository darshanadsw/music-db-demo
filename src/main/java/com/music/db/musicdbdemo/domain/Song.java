package com.music.db.musicdbdemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Song extends BaseModel {

    private String name;

    private Integer track;

    @ManyToOne
    private Album album;
}
