package com.demo.model;

public class Room {
    private int id;
    private String name;
    private int priceperday;
    private int pricepermonth;

    public Room() {
    }

    public Room(String name, int priceperday, int pricepermonth) {
        this.name = name;
        this.priceperday = priceperday;
        this.pricepermonth = pricepermonth;
    }

    public Room(int id, String name, int priceperday, int pricepermonth) {
        this.id = id;
        this.name = name;
        this.priceperday = priceperday;
        this.pricepermonth = pricepermonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceperday() {
        return priceperday;
    }

    public void setPriceperday(int priceperday) {
        this.priceperday = priceperday;
    }

    public int getPricepermonth() {
        return pricepermonth;
    }

    public void setPricepermonth(int pricepermonth) {
        this.pricepermonth = pricepermonth;
    }
}
