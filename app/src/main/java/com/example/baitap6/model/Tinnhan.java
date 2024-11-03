package com.example.baitap6.model;

import java.io.Serializable;

public class Tinnhan implements Serializable {
    private String time,number,body;

    public Tinnhan(String time, String number, String body) {
        this.time = time;
        this.number = number;
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
