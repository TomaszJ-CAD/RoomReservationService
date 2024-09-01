package com.toja.domain.guest;

import java.util.List;

public class GuestService {

    private final GuestRepository repository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, Gender gender) {


        return repository.createNewGuest(firstName, lastName, age, gender);
    }

    public List<Guest> getAllGuest() {

        return this.repository.getAll();
    }
    public void saveAll() {
        repository.saveAll();
    }
}
