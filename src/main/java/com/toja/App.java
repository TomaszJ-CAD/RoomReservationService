package com.toja;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        String developerVersion = developerVersion(isDeveloperVersion);

        System.out.print("Witam w systemie rezerwacji dla Hotelu " + hotelName);
        System.out.print("Aktualna wersja systemu: " + systemVersion);
        System.out.print("Wersja deweloperska: " + developerVersion);


        System.out.println("\n===========================\n");
        Scanner input = new Scanner(System.in);

        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("Wybierz opcję: ");

        int option = 0;

        try {
            option = input.nextInt();

        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejściowe! Wybierz liczbę");
            e.printStackTrace();
        }


        if (option == 1) {
            System.out.println("Tworzymy nowego gościa.");

            try {
                System.out.print("Podaj imię gościa: ");
                String guestFirstName = input.next();
                System.out.print("Podaj nazwisko gościa: ");
                String guestLastName = input.next();
                System.out.print("Podaj wiek gościa: ");
                int guestAge = input.nextInt();

                Guest newGuest = new Guest(guestFirstName, guestLastName, guestAge);

                String info = String.format("Stworzono gościa: %s %s, %d lat.", newGuest.firstName, newGuest.lastName, newGuest.age);
                System.out.println(info);

                //System.out.println("Stworzono gościa: " + newGuest.firstName + " " + newGuest.lastName + ", " + newGuest.age + " lat.");

            } catch (Exception e) {
                System.out.println("Wprowadzone dane są niepoprawne!");
                e.printStackTrace();
            }

        } else if (option == 2) {
            System.out.println("Dodajemy nowy pokój");

            try {
                System.out.print("Podaj nr pokoju: ");
                int roomNumber = input.nextInt();
                System.out.print("Podaj ilość łóżek: ");
                int numberOfBeds = input.nextInt();

                Room newRoom = new Room(roomNumber, numberOfBeds);

                String info = String.format("Dodano pokój o numerze %s z %d. łóżkiem/łóżkami.", newRoom.number, newRoom.beds);
                System.out.println(info);

                //System.out.println("Dodano pokój o numerze " + newRoom.number + " z " + newRoom.beds + ". łóżkiem/łóżkami.");

            } catch (Exception e) {
                System.out.println("Wprowadzone dane są niepoprawne!");
                e.printStackTrace();
            }

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3");
        } else {
            System.out.println("Wybrano niepoprawną opcję.");
        }
    }

    public static String developerVersion(boolean isDeveloperVersion) {
        if (isDeveloperVersion == true) {
            return "TAK";
        } else {
            return "NIE";
        }
    }
}