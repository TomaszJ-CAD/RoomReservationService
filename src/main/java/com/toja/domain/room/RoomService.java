package com.toja.domain.room;

import java.util.List;

public class RoomService {

    private final RoomRepository repository = new RoomRepository();

    public Room createNewRoom(int number, BedType[] bedTypes) {

        return repository.createNewRoom(number, bedTypes);
    }

    public List<Room> getAllRooms() {

        return this.repository.getAll();
    }

    public void saveAll() {
        this.repository.saveAll();
    }

    public void readAll() {
        this.repository.readAll();
    }
}
