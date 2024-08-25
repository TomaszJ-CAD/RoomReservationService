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

        String bedInfo = "Rodzaje łóżek w pokoju:\n ";

        for (int i = 0; i < numberOfBeds; i++) {

            bedInfo = bedInfo + "\t" + this.bedType[i] + "\n";
        }

        return String.format("Dodano pokój o numerze %d. %s", this.number, bedInfo);
    }


}
