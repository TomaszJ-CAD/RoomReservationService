package com.toja;

public class GuestService {

    GuestRepository repository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, Gender gender) {


        return repository.createNewGuest(firstName, lastName, age, gender);
    }
}
