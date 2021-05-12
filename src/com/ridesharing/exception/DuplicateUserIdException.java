package com.ridesharing.exception;

public class DuplicateUserIdException extends Exception{
    public DuplicateUserIdException(String message) {
        super(message);
    }
}
