package com.toja.domain.room;

public class Room {

    private final int id;
    private final int number;
    private final BedType[] bedType;

    public Room(int id, int number, BedType[] bedType) {
        this.id = id;
        this.number = number;
        this.bedType = bedType;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {

        int numberOfBeds = bedType.length;

        String bedInfo = "Rodzaje łóżek w pokoju:\n ";

        for (int i = 0; i < numberOfBeds; i++) {

            bedInfo = bedInfo + "\t" + this.bedType[i] + "\n";
        }

        return String.format("%d Pokój nr %d. %s", this.id, this.number, bedInfo);
    }


    String toCSV() {
        String[] bedsAsString = new String[this.bedType.length];

        for (int i = 0; i < this.bedType.length; i++) {
            bedsAsString[i] = this.bedType[i].toString();
            
        }
        String bedTypes = String.join("#", bedsAsString);

        return String.format("%d,%d,%s%s",
                this.id,
                this.number,
                bedTypes,
                System.getProperty("line.separator"));
    }
}
