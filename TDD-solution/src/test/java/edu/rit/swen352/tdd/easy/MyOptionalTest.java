package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

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
    @DisplayName("Assert .get() returns not Null on non null optional")
    public void get_1() {
        assertNotNull(MyOptional.of(2).get());
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

    @Test
    @DisplayName("Assert isPresent() returns false when empty")
    public void isPresent_1() {
        assertFalse(MyOptional.empty().isPresent());
    }

    @Test
    @DisplayName("Assert isPresent() returns true when nonempty")
    public void isPresent_2() {
        assertTrue(MyOptional.ofNullable(2).isPresent());
    }

    @Test
    @DisplayName(".ifPresent() doesn't run consumer if empty")
    public void ifPresent_1() {

        /*
         * Need a way to assure that the consumer
         * has made a side effect
         * 
         * Could just throw an exception, but would rather just do
         * straight side effects in the spirit of a consumer
         */
        final List<Object> list = new ArrayList<>();
        Consumer<Object> consumer = new Consumer<>() {
            @Override
            public void accept(Object t) {
                list.add(t);
            }
        };

        MyOptional.empty().ifPresent(consumer);

        assertTrue(list.isEmpty());

    }
}
