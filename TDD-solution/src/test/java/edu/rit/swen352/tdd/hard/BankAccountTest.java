package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link BankAccount} component.
 */
class BankAccountTest {
    private Money RuT;
    private BankAccount CuT;

    @Test
    @DisplayName("Money record can be constructed")
    public void moneyConstructorTest() {
        assertNotNull(RuT = new Money(0, 0));
    }

    @Test
    @DisplayName("BankAccount can be constructed")
    public void bankAccountConstructorTest() {
        assertNotNull(CuT = new BankAccount());
    }

    @Test
    @DisplayName("Cents cannot be negative")
    public void centsCannotBeNegativeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RuT = new Money(0, -1);
        });
        String expectedMessage = "Cents cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Cents cannot be greater than 99")
    public void centsCannotBeGreaterThan99Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RuT = new Money(0, 101);
        });
        String expectedMessage = "Cents cannot be greater than 99";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Dollars cannot be negative")
    public void dollarsCannotBeNegativeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RuT = new Money(-1, 0);
        });
        String expectedMessage = "Dollars cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Adding money")
    public void addMoneyTest(){
        RuT = new Money(0, 0);
        Money testMoney = new Money(10, 50);

        Money FinalMoney = RuT.add(testMoney);

        assertEquals(10, FinalMoney.dollars());
        assertEquals(50, FinalMoney.cents());
    }

    @Test
    @DisplayName("Adding money that converts from cents to dollars")
    public void addMoneyComplexTest() {
        RuT = new Money(2, 75);
        Money testMoney = new Money(0, 53);

        Money FinalMoney = RuT.add(testMoney);

        assertEquals(3, FinalMoney.dollars());
        assertEquals(28, FinalMoney.cents());
    }

    @Test
    @DisplayName("Tests when there is no money")
    public void moneyAtZeroTest() {
        RuT = new Money(0, 0);
        boolean result = RuT.isZero();

        assertTrue(result);
    }
}
