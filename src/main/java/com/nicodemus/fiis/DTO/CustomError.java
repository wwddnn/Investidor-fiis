package com.nicodemus.fiis.DTO;

import java.time.Instant;

public class CustomError {

    //Attributes
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    //Constructor
    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    //Get method
    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
