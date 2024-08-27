package com.toja.domain.guest;

public class Guest {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;

    public Guest(String fistName, String lastName, int age, Gender gender) {
        this.firstName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    // dzięki temu nie potrzebujemy getterów i setterów
    public String getInfo() {

        return String.format("Stworzono gościa: %s %s, %d lat, płeć %s.", this.firstName, this.lastName, this.age, this.gender);
    }

}
