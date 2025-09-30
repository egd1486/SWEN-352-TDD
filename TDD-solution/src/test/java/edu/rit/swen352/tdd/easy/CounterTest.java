package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test suite for the {@link Counter} component.
 */
class CounterTest {
    private Counter CuT;

    @Test
    @DisplayName("Test constructor: 2 args")
     void constructorTest_1() {
        CuT = new Counter(1, 10);
        assertEquals(CuT.lowerBounds, 1, "lowerBounds is not equal");
        assertEquals(CuT.upperBounds, 10, "upperBounds is not equal");
    }

    @Test
    @DisplayName("Test constructor: 1 args")
    void constructorTest_2() {
        CuT = new Counter(1);
        assertEquals(CuT.lowerBounds, 1, "lowerBounds is not equal");
        assertEquals(CuT.upperBounds, Integer.MAX_VALUE, "upperBounds is not equal");
    }

    @Test
    @DisplayName("Test constructor: 0 args")
    void constructorTest_3() {
        CuT = new Counter();
        assertEquals(CuT.lowerBounds, 0, "lowerBounds is not equal");
        assertEquals(CuT.upperBounds, Integer.MAX_VALUE, "upperBounds is not equal");
    }
}
