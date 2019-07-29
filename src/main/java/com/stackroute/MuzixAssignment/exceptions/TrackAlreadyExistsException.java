package com.stackroute.MuzixAssignment.exceptions;


public class TrackAlreadyExistsException extends Exception{

    private String message;

    public TrackAlreadyExistsException()
    {
    }

    //creating custom exception
    public TrackAlreadyExistsException(String message)
    {
        super(message);
        this.message = message;
    }

}
