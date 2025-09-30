package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyOptional} component.
 */
class MyOptionalTest {
    @Test
    @DisplayName("Assert .empty() doesn't return Null")
    public void empty_1() {
        assertNotNull(MyOptional.empty());
    }

    @Test
    @DisplayName("Assert .get() returns null on empty optional")
    public void get_1() {
        assertNull(MyOptional.empty().get());
    }

    @Test
    @DisplayName("Assert of() returns non-empty optional")
    public void of_1() {
        assertNotNull(MyOptional.of(1).get());
    }
}
