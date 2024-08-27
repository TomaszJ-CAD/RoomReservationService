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

    public void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {


        String developerVersion = developerVersion(isDeveloperVersion);

        System.out.println("Witam w systemie rezerwacji dla Hotelu " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja deweloperska: " + developerVersion);

        System.out.println("\n===========================\n");
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

    public void showMainMenu() {
        Scanner input = new Scanner(System.in);

        try {
            performAction(input);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Wystąpił niespodziewany błąd");
            System.out.println("Nieznany kod błędu");
            System.out.println("Komunikat błędu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Wychodzę z aplikacji");
        }
    }

    private void performAction(Scanner input) {
        int option = getActionFromUser(input);


        if (option == 1) {
            readNewGuestData(input);

        } else if (option == 2) {
            readNewRoomData(input);

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3");
        } else {
            throw new WrongOptionException("Wrong option in main menu.");
        }
    }

    private static int getActionFromUser(Scanner in) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.println("Wybierz opcję: ");

        int actionNumber = 0;

        try {
            actionNumber = in.nextInt();

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return actionNumber;
    }
}
