package com.toja;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        String developerVersion = developerVersion(isDeveloperVersion);

        System.out.print("Witam w systemie rezerwacji dla Hotelu ");
        System.out.println(hotelName);
        System.out.print("Aktualna wersja systemu: ");
        System.out.println(systemVersion);
        System.out.print("Wersja deweloperska: ");
        System.out.println(developerVersion);

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
            System.out.println("Wybrano opcję 1");
        } else if (option == 2) {
            System.out.println("Wybrano opcję 2");
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