package com.toja;

import java.util.Arrays;

public class Room {
    private int number;
    private BedType[] bedType;

    public Room(int number, BedType[] bedType) {
        this.number = number;
        this.bedType = bedType;
    }

    public String getInfo() {

        int numberOfBeds = bedType.length;

        System.out.println("Rodzaje łóżek w pokoju: ");
        for (int i = 0; i < numberOfBeds; i++) {

            System.out.println(bedType[i] + " ");
        }
        System.out.println();
        return String.format("Dodano pokój o numerze %s.", this.number);
    }


}
