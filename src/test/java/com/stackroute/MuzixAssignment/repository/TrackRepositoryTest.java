package com.stackroute.MuzixAssignment.repository;

import com.stackroute.MuzixAssignment.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;

    private Track track;

    //triggers before every test
    @Before
    public void setUp()
    {
        track = new Track(1,"premam","harika","www.testurl","FIXME",1233);
    }

    //triggers after every test
    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(this.track.getId()).get();
        Assert.assertEquals(1,fetchTrack.getId());
    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(fetchTrack,testTrack);
    }

    @Test
    public void getAllTracks()
    {
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        Track track2 = new Track(2,"ishq","harika","www.testurl","FIXME",1233);
        tracks.add(track1);
        tracks.add(track2);
        List<Track> trackList = trackRepository.findAll();
        Assert.assertEquals(tracks,trackList);
    }
}