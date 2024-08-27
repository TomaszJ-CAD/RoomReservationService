package com.toja;


public class App {

    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        textUI.showSystemInfo(hotelName, systemVersion, isDeveloperVersion);
        textUI.showMainMenu();
    }
}