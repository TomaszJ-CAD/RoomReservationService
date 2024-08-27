package com.toja.domain.room;

public class RoomService {

    private final RoomRepository repository = new RoomRepository();

    public Room createNewRoom(int number, BedType[] bedTypes) {

        return repository.createNewRoom(number, bedTypes);
    }

}
