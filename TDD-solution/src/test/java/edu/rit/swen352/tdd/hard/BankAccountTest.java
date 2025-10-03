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
    public void moneyConstructorTest() {
        assertNotNull(RuT = new Money(0, 0));
    }

    @Test
    public void bankAccountConstructorTest(){
        assertNotNull(CuT = new BankAccount());
    }
}
