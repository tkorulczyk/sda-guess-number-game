package com.guessnumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class AppLogicTest {
    private static AppLogic appLogic;

    @BeforeAll
    static void setUp() {
        appLogic = new AppLogic(new InputValidator(new Scanner(System.in)));
    }

    /* =============================================================== */
    /* Separation Line Tests */
    @Test
    void thatSeparationLineEqualsTenEqualSigns() {
        String line = appLogic.generateSeparationLine(10);
        Assertions.assertEquals(line,"==========");
    }

    @Test
    void thatSeparationLineNotEqualsEmptyString() {
        String line = appLogic.generateSeparationLine(10);
        Assertions.assertNotEquals(line,"");
    }

    /* =============================================================== */
    /* Middle Line Tests */
    /* Test "!!! Outstanding !!!" */
    @Test
    void thatMiddleLineEqualsOutstandingWhenCounterIsThree() {
        String message = appLogic.generateMiddleMessage(3);
        Assertions.assertEquals(message, "!!! Outstanding !!!");
    }

    @Test
    void thatMiddleLineEqualsOutstandingWhenCounterIsTwo() {
        String message = appLogic.generateMiddleMessage(2);
        Assertions.assertEquals(message, "!!! Outstanding !!!");
    }

    /* Corner case */
    @Test
    void thatMiddleLineNotEqualsOutstandingWhenCounterIsFive() {
        String message = appLogic.generateMiddleMessage(5);
        Assertions.assertNotEquals(message, "!!! Outstanding !!!");
    }

    /* Test "!!! Great !!!" */
    @Test
    void thatMiddleLineEqualsGreatWhenCounterIsThree() {
        String message = appLogic.generateMiddleMessage(7);
        Assertions.assertEquals(message, "!!! Great !!!");
    }

    @Test
    void thatMiddleLineNotEqualsGreatWhenCounterIsEight() {
        String message = appLogic.generateMiddleMessage(8);
        Assertions.assertNotEquals(message, "!!! Great !!!");
    }

    /* Corner case */
    @Test
    void thatMiddleLineNotEqualsGreatWhenCounterIsFifteen() {
        String message = appLogic.generateMiddleMessage(15);
        Assertions.assertNotEquals(message, "!!! Great !!!");
    }

    /* Test "Good!" */
    @Test
    void thatMiddleLineEqualsGoodWhenCounterIsFifteen() {
        String message = appLogic.generateMiddleMessage(15);
        Assertions.assertEquals(message, "Good!");
    }


    /* Corner case */
    @Test
    void thatMiddleLineNotEqualsGoodWhenCounterIsSixteen() {
        String message = appLogic.generateMiddleMessage(16);
        Assertions.assertNotEquals(message, "Good!");
    }

    /* "Try again!" */
    @Test
    void thatMiddleLineEqualsTryAgainWhenCounterIsTwenty() {
        String message = appLogic.generateMiddleMessage(20);
        Assertions.assertEquals(message, "Try again!");
    }

    @Test
    void thatMiddleLineEqualsTryAgainWhenCounterIsOneHundred() {
        String message = appLogic.generateMiddleMessage(100);
        Assertions.assertEquals(message, "Try again!");
    }


    /* Corner case */
    @Test
    void thatMiddleLineEqualsTryAgainWhenCounterIsMaxIntValue() {
        String message = appLogic.generateMiddleMessage(Integer.MAX_VALUE);
        Assertions.assertEquals(message, "Try again!");
    }


    /* =============================================================== */
    /* Get Counter Suffix Tests */
    @Test
    void thatCounterSuffixIsForOne() {
        String suffix = appLogic.getCounterSuffix(1);
        Assertions.assertEquals(suffix,"st");
    }

    @Test
    void thatCounterSuffixIsForTwo() {
        String suffix = appLogic.getCounterSuffix(2);
        Assertions.assertEquals(suffix,"nd");
    }

    @Test
    void thatCounterSuffixIsForThree() {
        String suffix = appLogic.getCounterSuffix(3);
        Assertions.assertEquals(suffix,"rd");
    }

    @Test
    void thatCounterSuffixIsForFour() {
        String suffix = appLogic.getCounterSuffix(4);
        Assertions.assertEquals(suffix,"th");
    }

    @Test
    void thatCounterSuffixIsForEight() {
        String suffix = appLogic.getCounterSuffix(8);
        Assertions.assertEquals(suffix,"th");
    }

    @Test
    void thatCounterSuffixIsForTen() {
        String suffix = appLogic.getCounterSuffix(10);
        Assertions.assertEquals(suffix,"th");
    }

    @Test
    void thatCounterSuffixIsForTwenty() {
        String suffix = appLogic.getCounterSuffix(20);
        Assertions.assertEquals(suffix,"th");
    }

    @Test
    void thatCounterSuffixIsForTwentyOne() {
        String suffix = appLogic.getCounterSuffix(21);
        Assertions.assertEquals(suffix,"st");
    }

    @Test
    void thatCounterSuffixIsForTwenyTwo() {
        String suffix = appLogic.getCounterSuffix(22);
        Assertions.assertEquals(suffix,"nd");
    }

    @Test
    void thatCounterSuffixIsForTwentyThree() {
        String suffix = appLogic.getCounterSuffix(33);
        Assertions.assertEquals(suffix,"rd");
    }
    @Test
    void thatCounterSuffixIsForTwentyFour() {
        String suffix = appLogic.getCounterSuffix(34);
        Assertions.assertEquals(suffix,"th");
    }

    /* Negative Tests */
    @Test
    void thatCounterSuffixIsNotForTwo() {
        String suffix = appLogic.getCounterSuffix(1);
        Assertions.assertNotEquals(suffix,"nd");
    }

    @Test
    void thatCounterSuffixIsNotForFour() {
        String suffix = appLogic.getCounterSuffix(2);
        Assertions.assertNotEquals(suffix,"th");
    }

    @Test
    void thatCounterSuffixIsNotForOne() {
        String suffix = appLogic.getCounterSuffix(3);
        Assertions.assertNotEquals(suffix,"st");
    }

}