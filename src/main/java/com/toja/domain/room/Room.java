package com.toja.domain.room;

public class Room {
    private final int number;
    private final BedType[] bedType;

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

        return String.format("Pokój nr %d. %s", this.number, bedInfo);
    }


}
