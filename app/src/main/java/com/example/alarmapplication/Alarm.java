package com.example.alarmapplication;

public class Alarm {
    private int hours;
    private int minute;
    private String message;

    public Alarm(int hours, int minute, String message) {
        this.hours = hours;
        this.minute = minute;
        this.message = message;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "hours=" + hours +
                ", minute=" + minute +
                ", message='" + message + '\'' +
                '}';
    }
}
