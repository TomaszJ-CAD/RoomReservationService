package com.toja;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        showSystemInfo(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);

        int option = getActionFromUser(input);


        if (option == 1) {
            Guest newGuest = createNewGuest(input);

        } else if (option == 2) {
            Room newRoom = createNewRoom(input);

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

    //TODO
//    public static String genderForPrint(Gender gender) {
//        if (gender == Gender.MALE) {
//            return "męska";
//        } else  {
//            return "żeńska";
//        }
//    }

    private static void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {


        String developerVersion = developerVersion(isDeveloperVersion);

        System.out.println("Witam w systemie rezerwacji dla Hotelu " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja deweloperska: " + developerVersion);

        System.out.println("\n===========================\n");
    }

    private static int getActionFromUser(Scanner in) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("Wybierz opcję: ");

        int actionNumber = 0;

        try {
            actionNumber = in.nextInt();

        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejściowe! Wybierz liczbę");
            e.printStackTrace();
        }
        return actionNumber;
    }

    private static Guest createNewGuest(Scanner in) {
        System.out.println("Tworzymy nowego gościa.");

        try {
            System.out.print("Podaj imię gościa: ");
            String guestFirstName = in.next();
            System.out.print("Podaj nazwisko gościa: ");
            String guestLastName = in.next();
            System.out.print("Podaj wiek gościa: ");
            int guestAge = in.nextInt();

            Gender guestGender = chooseGenderType(in);

            Guest newGuest = new Guest(guestFirstName, guestLastName, guestAge, guestGender);



            System.out.println(newGuest.getInfo());

            //System.out.println("Stworzono gościa: " + newGuest.firstName + " " + newGuest.lastName + ", " + newGuest.age + " lat.");
            return newGuest;
        } catch (Exception e) {
            System.out.println("Wprowadzone dane są niepoprawne!");
            e.printStackTrace();

            return null;
        }

    }

    private static Room createNewRoom(Scanner in) {
        System.out.println("Dodajemy nowy pokój");

        try {
            System.out.print("Podaj nr pokoju: ");
            int roomNumber = in.nextInt();

            BedType bedType[] = chooseBedType(in);

            Room newRoom = new Room(roomNumber, bedType);


            System.out.println(newRoom.getInfo());

            //System.out.println("Dodano pokój o numerze " + newRoom.number + " z " + newRoom.beds + ". łóżkiem/łóżkami.");

            return newRoom;
        } catch (Exception e) {
            System.out.println("Wprowadzone dane są niepoprawne!");
            e.printStackTrace();

            return null;
        }
    }

    private static BedType[] chooseBedType(Scanner in) {
        System.out.println("Ile łóżek w pokoju?");
        int bedNumber = in.nextInt();

        BedType[] bedTypes = new BedType[bedNumber];

        for(int i = 0; i < bedNumber; i++) {

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
            System.out.println("Nieprawidłowy typ łóżka, wybrano wartość domyślną.");
        }
        bedTypes[i] = bed;
    }
        return bedTypes;
    }

    private static Gender chooseGenderType(Scanner in) {
        System.out.println("Podaj płeć gościa: ");
        System.out.println("\t1. mężczyzna");
        System.out.println("\t2. kobieta");
        int guestGenderType = in.nextInt();
        Gender guestGender = null;

        if (guestGenderType == 1) {
            guestGender = Gender.MALE;
        } else if (guestGenderType == 2) {
            guestGender = Gender.FEMALE;
        } else {
            System.out.println("Nieprawidłowy wybór!");
        }
        return guestGender;
    }
}