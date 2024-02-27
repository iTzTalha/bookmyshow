package com.bitforge.bookmyshow.exceptions;

public class SeatNotEmptyException extends Exception {
    public SeatNotEmptyException() {
        super();
    }

    public SeatNotEmptyException(String message) {
        super(message);
    }
}
