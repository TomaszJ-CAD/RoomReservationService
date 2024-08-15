package com.toja;

public class Guest {

    private String firstName;
    private String lastName;
    private int age;


    public Guest(String fistName, String lastName, int age) {
        this.firstName = fistName;
        this.lastName = lastName;
        this.age = age;

        System.out.println("Stworzono gościa: " + this.firstName + " " + this.lastName + ", " + this.age + " lat." );
    }
}
