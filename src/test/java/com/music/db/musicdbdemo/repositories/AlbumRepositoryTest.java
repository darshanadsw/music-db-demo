package com.music.db.musicdbdemo.repositories;

import com.music.db.musicdbdemo.domain.Artist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ArtistRepository artistRepository;

    Artist at1;

    @Before
    public void setUp() throws Exception {

        at1 = new Artist();
        at1.setName("Artist One");

        Artist at2 = new Artist();
        at2.setName("Artist Two");

        em.persist(at1);
        em.persist(at2);
    }

    @Test
    public void testArtistGetAll(){
        Iterable<Artist> artists = artistRepository.findAll();
        assertNotNull(artists);
        List<Artist> list = new ArrayList<>();
        artists.forEach(list::add);
        assertEquals(5,list.size());
    }

    @Test
    public void testArtistSave(){
        Artist at3 = new Artist();
        at3.setName("Artist Three");

        artistRepository.save(at3);

        assertNotNull(at3.getId());
    }

    @Test
    public void testArtistDelete(){
        artistRepository.deleteById(at1.getId());

        assertFalse(artistRepository.findById(at1.getId()).isPresent());
    }
}