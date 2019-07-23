package com.music.db.musicdbdemo.domain;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected Date createdDate;

    protected Date modifiedDate;

}
