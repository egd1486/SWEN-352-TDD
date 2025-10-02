package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MySet} component.
 */
class MySetTest {
    @Test
    @DisplayName("Constructor returns non null object")
    public void constructor_1() {
        assertNotNull(new MySet<Integer>());
    }
}
