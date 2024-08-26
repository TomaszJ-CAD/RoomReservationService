package com.toja;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        showSystemInfo(hotelName, systemVersion, isDeveloperVersion);

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

    private static void performAction(Scanner input) {
        int option = getActionFromUser(input);


        if (option == 1) {
            textUI.readNewGuestData(input);

        } else if (option == 2) {
            textUI.readNewRoomData(input);

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3");
        } else {
            throw new WrongOptionException("Wrong option in main menu.");
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

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return actionNumber;
    }


}