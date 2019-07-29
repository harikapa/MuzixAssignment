package com.stackroute.MuzixAssignment.service;

import com.stackroute.MuzixAssignment.domain.Track;
import com.stackroute.MuzixAssignment.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAssignment.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    //public List<Track> getTracksByName(String name);

    public Track updateTrack(Track track, int id) throws TrackNotFoundException;

    public boolean deleteTrack(int id) throws TrackNotFoundException;

    //public List<Track> searchTracks(String searchString);
}
