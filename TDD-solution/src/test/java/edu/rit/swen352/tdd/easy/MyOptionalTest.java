package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

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
    @DisplayName(".get() throws NoSuchElement when null")
    public void get_2() {
        assertThrows(NoSuchElementException.class, () -> {
            MyOptional.empty().get();
        });
    }

    @Test
    @DisplayName("Assert of() returns non-empty optional")
    public void of_1() {
        assertNotNull(MyOptional.of(1).get());
    }

    @Test
    @DisplayName("Assert of() throws NullPointerException if null")
    public void of_2() {
        assertThrows(NullPointerException.class,() -> {
            MyOptional.of(null);
        } );
    }

    @Test
    @DisplayName("Assert of() creates optional with given value")
    public void of_3() {
        int value = 2;
        MyOptional<Integer> optional = MyOptional.of(value);
        assertEquals(value, optional.get());
    }

    @Test
    @DisplayName("Assert .ofNullable() doesn't return Null")
    public void ofNullable_1() {
        assertNotNull(MyOptional.ofNullable(null));
    }

    @Test
    @DisplayName("Assert .ofNullable() stores value given")
    public void ofNullable_2() {
        int value = 2;
        MyOptional<Integer> nullable = MyOptional.ofNullable(value);
        assertEquals(value, nullable.get());
    }
}
