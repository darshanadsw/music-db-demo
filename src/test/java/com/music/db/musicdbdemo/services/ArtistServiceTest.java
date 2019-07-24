package com.music.db.musicdbdemo.services;

import com.music.db.musicdbdemo.domain.Artist;
import com.music.db.musicdbdemo.repositories.ArtistRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ArtistServiceTest {

    @MockBean
    private ArtistRepository artistRepository;

    private ArtistService artistService;

    @Before
    public void setUp() throws Exception {
        artistService = new ArtistService(artistRepository);
    }

    @Test
    public void getAll() {

        Artist at1 = new Artist();
        at1.setId(1L);
        at1.setName("Artist One");

        Artist at2 = new Artist();
        at2.setId(2L);
        at2.setName("Artist Two");

        when(artistRepository.findAll()).thenReturn(Arrays.asList(at1,at2));

        List<Artist> artistList = artistService.getAll();

        assertNotNull(artistList);
        assertEquals(2,artistList.size());
    }

    @Test
    public void save() {

        Artist at1 = new Artist();
        at1.setId(1L);
        at1.setName("Artist One");

        when(artistRepository.save(any(Artist.class))).thenReturn(at1);

        artistService.save(at1);

        verify(artistRepository).save(any(Artist.class));
    }

    @Test
    public void deleteById() {
        doNothing().when(artistRepository).deleteById(anyLong());

        artistService.deleteById(1L);

        verify(artistRepository).deleteById(anyLong());
    }

    @Test
    public void update() {
        Artist at1 = new Artist();
        at1.setId(1L);
        at1.setName("Artist One");

        Artist at2 = new Artist();
        at2.setId(1L);
        at2.setName("Artist Two");

        when(artistRepository.findById(anyLong())).thenReturn(Optional.of(at1));

        when(artistRepository.save(at1)).thenReturn(at1);

        artistService.update(at2);

        verify(artistRepository).findById(anyLong());

        verify(artistRepository).save(any(Artist.class));

    }

    @Test
    public void findById() {
        Artist at2 = new Artist();
        at2.setId(1L);
        at2.setName("Artist Two");

        when(artistRepository.findById(anyLong())).thenReturn(Optional.of(at2));

        Artist artist = artistService.findById(1L);

        verify(artistRepository).findById(anyLong());

        assertNotNull(artist);
    }
}