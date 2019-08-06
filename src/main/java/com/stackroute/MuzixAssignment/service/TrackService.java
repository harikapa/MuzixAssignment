package com.stackroute.MuzixAssignment.service;

import com.stackroute.MuzixAssignment.domain.Track;
import com.stackroute.MuzixAssignment.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAssignment.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> getAllTracks();

    List<Track> getTracksByName(String name);

    Track updateTrack(Track track, int id) throws TrackNotFoundException;

    Track deleteTrack(int id) throws TrackNotFoundException;

    List<Track> searchTracks(String searchString);
}
