package com.toja.domain.guest;

public class Guest {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;

    public Guest(int id, String fistName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    // dzięki temu nie potrzebujemy getterów i setterów
    public String getInfo() {

        return String.format("%d %s %s, %d lat, płeć %s.", this.id, this.firstName, this.lastName, this.age, this.gender);
    }

    String toCSV() {
        return String.format("%s,%s,%s,%d,%s%s",
                this.id,
                this.firstName,
                this.lastName,
                this.age,
                this.gender,
                System.getProperty("line.separator"));
    }

}
