package com.toja.domain.room;

public class RoomRepository {

    public Room createNewRoom(int number, BedType[] bedTypes) {

        Room newRoom = new Room(number, bedTypes);

        return newRoom;
    }
}
