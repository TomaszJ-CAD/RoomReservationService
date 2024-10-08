package com.toja.domain.room;

import com.toja.domain.guest.Guest;
import com.toja.exceptions.PersistenceToFileException;
import com.toja.util.Properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private final List<Room> rooms = new ArrayList<>();

    public Room createNewRoom(int number, BedType[] bedTypes) {

        Room newRoom = new Room(findNewId(), number, bedTypes);
        rooms.add(newRoom);

        return newRoom;
    }

    public Room addRoomFromFile(int id, int number, BedType[] bedTypes) {

        Room newRoom = new Room(id, number, bedTypes);
        rooms.add(newRoom);

        return newRoom;
    }

    List<Room> getAll() {

        return this.rooms;
    }

    public void saveAll() {
        String name = "rooms.csv";

        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        StringBuilder sb = new StringBuilder("");

        for (Room room : this.rooms) {
            sb.append(room.toCSV());
        }
        try {
            Files.writeString(file, sb.toString(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new PersistenceToFileException(file.toString(), "write", "room data");

        }
    }

    public void readAll() {
        String name = "rooms.csv";

        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        if (!Files.exists(file)) {
            return;
        }

        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] roomsAsString = data.split(System.getProperty("line.separator"));

            for (String roomAsString : roomsAsString) {
                String[] roomData = roomAsString.split(",");
                int id = Integer.parseInt(roomData[0]);
                int number = Integer.parseInt(roomData[1]);
                String bedTypesData = roomData[2];
                String[] bedsTypesAsString = bedTypesData.split("#");

                BedType[] bedTypes = new BedType[bedsTypesAsString.length];

                for (int i = 0; i < bedTypes.length; i++) {
                    bedTypes[i] = BedType.valueOf(bedsTypesAsString[i]);

                }
                addRoomFromFile(id, number, bedTypes);
            }

        } catch (IOException e) {
            throw new PersistenceToFileException(file.toString(), "read", "room data");

        }
    }

    private int findNewId() {
        int max = 0;
        for (Room room : this.rooms) {
            if (room.getId() > max) {
                max = room.getId();
            }
        }
        return max + 1;
    }
}

