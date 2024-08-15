package com.toja;

public class Room {
    private int number;
    private int beds;

    public Room(int number, int beds) {
        this.number = number;
        this.beds = beds;

        System.out.println("Dodano pokój o numerze " + this.number + " z " + this.beds + ". łóżkiem/łóżkami");
    }
}
