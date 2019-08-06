package com.stackroute.MuzixAssignment.exceptions;

public class TrackNotFoundException extends Exception {

    public TrackNotFoundException()
    {

    }

    //creating custom exception
    public TrackNotFoundException(String message)
    {
        super(message);
    }
}
