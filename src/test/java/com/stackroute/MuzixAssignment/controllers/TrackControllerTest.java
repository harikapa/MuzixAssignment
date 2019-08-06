package com.stackroute.MuzixAssignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixAssignment.domain.Track;
import com.stackroute.MuzixAssignment.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TrackControllerTest{

    @Autowired
    MockMvc mockMvc;

    @Mock
    TrackService trackService;

    @InjectMocks
    TrackController trackController;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
    }

    @Test
    public void saveTrackTest() throws Exception
    {
        Track track = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        when(trackService.saveTrack(track)).thenReturn(track);
        mockMvc.perform(post("/track")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().isCreated());
        verify(trackService, times(1)).saveTrack(Mockito.any(Track.class));
        verifyNoMoreInteractions(trackService);
    }

    @Test
    public void getAllTracks() throws Exception
    {
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        Track track2 = new Track(2,"ishq","harika","www.testurl","FIXME",1233);
        tracks.add(track1);
        tracks.add(track2);
        when(trackService.getAllTracks()).thenReturn(tracks);
        mockMvc.perform(get("/track")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
        verify(trackService, times(1)).getAllTracks();
        verifyNoMoreInteractions(trackService);
    }

    @Test
    public void getTracksByNameTest() throws Exception
    {
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        tracks.add(track1);
        when(trackService.getTracksByName("premam")).thenReturn(tracks);
        mockMvc.perform(get("/trackByName?name=premam")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
        verify(trackService, times(1)).getTracksByName("premam");
        verifyNoMoreInteractions(trackService);
    }

    @Test
    public void updateTrackTest() throws Exception
    {
        Track track1 = new Track(11,"premam","harika","www.testurl","FIXME",1233);
        Track track2 = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        when(trackService.updateTrack(track1,1)).thenReturn(track2);
        mockMvc.perform(put("/track/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(track1)))
                .andExpect(status().isOk());
        verifyNoMoreInteractions(trackService);
    }


    @Test
    public void deleteTrackTest() throws Exception
    {
        Track track = new Track(1,"premam","harika","www.testurl","FIXME",1233);
        when(trackService.deleteTrack(1)).thenReturn(track);
        mockMvc.perform(delete("/track/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(trackService, times(1)).deleteTrack(1);
        verifyNoMoreInteractions(trackService);
    }

    //Converting object to json
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}