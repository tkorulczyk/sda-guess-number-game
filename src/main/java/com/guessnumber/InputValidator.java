package com.guessnumber;

import lombok.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class InputValidator {
    private final Scanner scanner;

    int getInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextInt();
                System.out.println("Please enter a number");
            }
        }
    }
}
