package com.guessnumber;

import lombok.Data;

import java.time.Duration;
import java.time.Instant;

@Data
public class AppLogic {
    private final InputValidator inputValidator;
    private final String INVITATION_MESSAGE = "\n" + generateSeparationLine(64) + "\n" +
            "Welcome to the " + Colors.GREEN + "$$$ GUESS NUMBER GAME $$$" + Colors.RESET + ", guess the number ASAP! \n" +
            generateSeparationLine(64) + "\n";

    public void runApp() {
        Instant startTime = Instant.now();
        System.out.println(INVITATION_MESSAGE);
        System.out.println("Determine the maximum value up to which you wish to guess ↓");
        int maxNumber = inputValidator.getInput();
        int drawnNumber = generateRandomNumber(maxNumber);
        int counter = 1;
        int guessedNumber = 0;

        while (guessedNumber != drawnNumber) {
            System.out.println("\n" + Colors.RESET + "****************");
            System.out.println("Provide a number \n↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ");
            guessedNumber = inputValidator.getInput();
            if (guessedNumber > maxNumber) {
                System.out.println(Colors.RED + "The number is out of specified bound" + Colors.RESET);
            } else {
                if (Math.abs(guessedNumber - drawnNumber) < 10) {
                    if (guessedNumber != drawnNumber) {
                        System.out.print(Colors.RED + "Hot => ");
                    }
                } else {
                    System.out.print(Colors.BLUE + "Cold => ");
                }

                if (guessedNumber > drawnNumber) {
                    System.out.println("too large");
                } else if (guessedNumber < drawnNumber) {
                    System.out.println("too little");
                }
            }
            counter++;
        }
        drawResult(counter, startTime);
    }



    void drawResult(int counter, Instant startTime) {
        System.out.println();
        String counterSuffix = getCounterSuffix(counter);
        String middleMessage = generateMiddleMessage(counter);
        String timeMessage = "and completed the task withing " +
                Duration.between(startTime, Instant.now()).toSeconds() + " seconds!";

        String resultsMessage = String.format(Colors.BLUE + "%s => you hit by %s%s time(s) %s", middleMessage, counter, counterSuffix, timeMessage);
        int resultsMessageLength = resultsMessage.length()-Colors.BLUE.length();
        String line = Colors.RESET + generateSeparationLine(resultsMessageLength);

        System.out.println(line);
        System.out.println(resultsMessage);
        System.out.println(line);
    }


    String generateMiddleMessage(int counter) {
        String middleMessage;
        if (counter <= 3) {
            middleMessage = "!!! Outstanding !!!";
        } else if (counter <= 7) {
            middleMessage = "!!! Great !!!";
        } else if (counter <= 15) {
            middleMessage = "Good!";
        } else {
            middleMessage = "Try again!";
        }
        return middleMessage;
    }



    String generateSeparationLine(int charactersNumber) {
        return "=".repeat(Math.max(0, charactersNumber-1 + 1));
    }

    int generateRandomNumber(int x) {
        return (int) Math.floor(Math.random() * (x - 1));
    }

    String getCounterSuffix(int counter) {
        if (counter > 3 && counter <= 20) {
            return "th";
        } else if (counter % 10 == 1) {
            return "st";
        } else if (counter % 10 == 2) {
            return "nd";
        } else if (counter % 10 == 3) {
            return "rd";
        } else if (counter % 10 > 3) {
            return "th";
        } else {
            return "";
        }
    }
}

