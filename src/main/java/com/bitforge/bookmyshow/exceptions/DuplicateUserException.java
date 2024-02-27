package com.bitforge.bookmyshow.exceptions;

public class DuplicateUserException extends Exception {
    public DuplicateUserException() {
        super();
    }

    public DuplicateUserException(String message) {
        super(message);
    }
}
