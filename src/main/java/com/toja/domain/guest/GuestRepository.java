package com.toja.domain.guest;


import com.toja.util.Properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {

    private final List<Guest> guests = new ArrayList<>();

    public Guest createNewGuest(String firstName, String lastName, int age, Gender gender) {

        Guest newGuest = new Guest(firstName, lastName, age, gender);
        guests.add(newGuest);

        return newGuest;
    }

    public List<Guest> getAll() {

        return this.guests;
    }

    public void saveAll() {
        String name = "guests.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        StringBuilder sb = new StringBuilder("");
        for (Guest guest : this.guests) {
            sb.append(guest.toCSV());
        }

        try {
            Files.writeString(file, sb.toString(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readAll() {
        String name = "guests.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] guestsAsString = data.split(System.getProperty("line.separator"));

            for (String guestAsString : guestsAsString) {
                String[] guestData = guestAsString.split(",");

                int age = Integer.parseInt(guestData[2]);
                Gender gender = Gender.valueOf(guestData[3]);
                createNewGuest(guestData[0], guestData[1], age, gender);
            }

        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi");
            e.printStackTrace();
        }
    }
}
