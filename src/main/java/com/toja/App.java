package com.toja;


import com.toja.ui.text.TextUI;

public class App {

    private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Zacisze";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        textUI.showSystemInfo(hotelName, systemVersion, isDeveloperVersion);
        textUI.showMainMenu();
    }
}