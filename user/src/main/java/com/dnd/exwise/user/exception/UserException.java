package com.dnd.exwise.user.exception;

public class UserException extends RuntimeException {

    public UserException() {
        super("Error in user service");
    }

    public UserException(String mess) {
        super(mess);
    }
}
