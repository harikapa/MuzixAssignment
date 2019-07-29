package com.stackroute.MuzixAssignment.exceptions;

public class TrackNotFoundException extends Exception {

    private String message;

    public TrackNotFoundException()
    {

    }

    //creating custom exception
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message = message;
    }
}
