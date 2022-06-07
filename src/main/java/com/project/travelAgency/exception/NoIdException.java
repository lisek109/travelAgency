package com.project.travelAgency.exception;

public class NoIdException extends Exception {

    public NoIdException(String no_id_found) {

    }

    @Override
    public String toString() {
        return "NoIdException";
    }
}
