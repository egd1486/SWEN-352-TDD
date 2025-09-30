package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test suite for the {@link SimpleBankAccount} component.
 */
class SimpleBankAccountTest {
    private SimpleBankAccount CuT;

    @BeforeEach
    public void setUp(){
        CuT = new SimpleBankAccount();
    }

    @AfterEach
    public void tearDown(){
        CuT = null;
    }

    @Test
    public void constructorTest(){
        assertNotNull(CuT);
    }

}
