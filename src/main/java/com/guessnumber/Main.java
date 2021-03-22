package com.guessnumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator(scanner);
        AppLogic appLogic = new AppLogic(inputValidator);
        appLogic.runApp();
    }
}
