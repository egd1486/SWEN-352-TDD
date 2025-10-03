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
    public void moneyConstructorTest(){
        assertNotNull(RuT = new Money(0, 0));
    }

    @Test
    @DisplayName("BankAccount can be constructed")
    public void bankAccountConstructorTest(){
        assertNotNull(CuT = new BankAccount());
    }

    @Test
    @DisplayName("Cents cannot be negative")
    public void centsCannotBeNegativeTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RuT = new Money(0, -1);
        });
        String expectedMessage = "Cents cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
