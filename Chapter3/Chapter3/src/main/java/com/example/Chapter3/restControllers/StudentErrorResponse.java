package com.example.Chapter3.restControllers;

public class StudentErrorResponse
{
    private int status;
    private String message;
    private long timestamp;

    public StudentErrorResponse() {}

    public StudentErrorResponse(int status, String message, long timestamp)
    {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public long getTimeStamp() { return timestamp; }

    public void setStatus(int status) { this.status = status; }
    public void setMessage(String message) { this.message = message; }
    public void setTimeStamp(long timestamp) { this.timestamp = timestamp; }
}
