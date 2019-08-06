package com.stackroute.MuzixAssignment.exceptions;


public class TrackAlreadyExistsException extends Exception{

    public TrackAlreadyExistsException()
    {
    }

    //creating custom exception
    public TrackAlreadyExistsException(String message)
    {
        super(message);
    }

}
