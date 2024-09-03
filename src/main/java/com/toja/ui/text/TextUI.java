package com.toja.ui.text;

import com.toja.domain.guest.Gender;
import com.toja.domain.guest.Guest;
import com.toja.domain.guest.GuestService;
import com.toja.domain.room.BedType;
import com.toja.domain.room.Room;
import com.toja.domain.room.RoomService;
import com.toja.exceptions.OnlyNumberException;
import com.toja.exceptions.WrongOptionException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {

    private final GuestService guestService = new GuestService();
    private final RoomService roomService = new RoomService();

    private void readNewGuestData(Scanner in) {
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

            System.out.println("Dodano nowego gościa: " + newGuest.getInfo());

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

    private void readNewRoomData(Scanner in) {
        System.out.println("Dodajemy nowy pokój");

        try {
            System.out.print("Podaj nr pokoju: ");
            int roomNumber = in.nextInt();

            BedType bedType[] = chooseBedType(in);

            Room newRoom = roomService.createNewRoom(roomNumber, bedType);

            System.out.println("Dodano nowy pokój " + newRoom.getInfo());

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

        System.out.println("Trwa ładowanie danych...");
        this.guestService.readAll();
        this.roomService.readAll();

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
        }
    }

    private void performAction(Scanner input) {
        int option = -1;

        while (option != 0) {

            option = getActionFromUser(input);

            if (option == 1) {
                readNewGuestData(input);

            } else if (option == 2) {
                readNewRoomData(input);

            } else if (option == 3) {
                showAllGuest();

            } else if (option == 4) {
                showAllRooms();

            } else if (option == 0) {
                System.out.println("Wychodzę z programu. Zapisuję dane.");
                this.guestService.saveAll();
                this.roomService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu.");
            }
        }
    }

    private void showAllRooms() {
        List<Room> rooms = this.roomService.getAllRooms();

        for (Room room : rooms) {
            System.out.println(room.getInfo());
        }

    }

    private void showAllGuest() {
        List<Guest> guests = this.guestService.getAllGuest();

        for (Guest guest : guests) {
            System.out.println(guest.getInfo());
        }

    }

    private static int getActionFromUser(Scanner in) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wypisz wszystkich gości.");
        System.out.println("4. Wypisz wszystkie pokoje.");
        System.out.println("0. Wyjście z aplikacji.");
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
