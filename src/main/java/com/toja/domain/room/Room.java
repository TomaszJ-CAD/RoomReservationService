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


    String toCSV() {
        String[] bedsAsString = new String[this.bedType.length];

        for (int i = 0; i < this.bedType.length; i++) {
            bedsAsString[i] = this.bedType[i].toString();
            
        }
        String bedTypes = String.join("#", bedsAsString);

        return String.format("%d,%s%s",
                this.number,
                bedTypes,
                System.getProperty("line.separator"));
    }
}
