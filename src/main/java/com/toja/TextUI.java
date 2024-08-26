package com.toja;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {

    GuestService guestService = new GuestService();
    RoomService roomService = new RoomService();

    public void readNewGuestData(Scanner in) {
        System.out.println("Tworzymy nowego gościa.");

        try {
            System.out.print("Podaj imię gościa: ");
            String guestFirstName = in.next();
            System.out.print("Podaj nazwisko gościa: ");
            String guestLastName = in.next();

            System.out.print("Podaj wiek gościa: ");
            int guestAge = in.nextInt();

            Gender guestGender = chooseGenderType(in);

            Guest newGuest = guestService.createNewGuest(guestFirstName, guestLastName, guestAge, guestGender);

            System.out.println(newGuest.getInfo());

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");

        }
    }
    private static Gender chooseGenderType(Scanner in) {
        System.out.println("Podaj płeć gościa: ");
        System.out.println("\t1. mężczyzna");
        System.out.println("\t2. kobieta");
        int guestGenderType = in.nextInt();
        Gender guestGender = Gender.MALE;

        if (guestGenderType == 1) {
            guestGender = Gender.MALE;
        } else if (guestGenderType == 2) {
            guestGender = Gender.FEMALE;
        } else {
            throw new WrongOptionException("Wrong option in gender selection.");
        }
        return guestGender;
    }

    Room readNewRoomData(Scanner in) {
        System.out.println("Dodajemy nowy pokój");

        try {
            System.out.print("Podaj nr pokoju: ");
            int roomNumber = in.nextInt();

            BedType bedType[] = chooseBedType(in);

            Room newRoom = roomService.createNewRoom(roomNumber, bedType);

            System.out.println(newRoom.getInfo());
            return newRoom;

        } catch (InputMismatchException e) {

            throw new OnlyNumberException("Use only numbers when creating new room");
        }
    }

    private static BedType[] chooseBedType(Scanner in) {

        System.out.println("Ile łóżek w pokoju?");
        int bedNumber = in.nextInt();

        BedType[] bedTypes = new BedType[bedNumber];

        for (int i = 0; i < bedNumber; i++) {

            System.out.println("Wybierz typ łóżka: ");
            System.out.println("\t1. pojedyncze");
            System.out.println("\t2. podwójne");
            System.out.println("\t3. królewskie");
            BedType bed = BedType.SINGLE; // wartość domyślna

            System.out.println("Wybierz opcję: ");
            int typeOfBeds = in.nextInt();

            if (typeOfBeds == 1) {
                bed = BedType.SINGLE;
            } else if (typeOfBeds == 2) {
                bed = BedType.DOUBLE;
            } else if (typeOfBeds == 3) {
                bed = BedType.KING_SIZE;
            } else {
                throw new WrongOptionException("Wrong option in selection bed type.");
            }
            bedTypes[i] = bed;
        }
        return bedTypes;
    }
}
