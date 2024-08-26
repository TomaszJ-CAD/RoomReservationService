package com.toja;

public class RoomService {

    private RoomRepository repository = new RoomRepository();

    public Room createNewRoom(int number, BedType[] bedTypes) {

        return repository.createNewRoom(number, bedTypes);
    }

}
