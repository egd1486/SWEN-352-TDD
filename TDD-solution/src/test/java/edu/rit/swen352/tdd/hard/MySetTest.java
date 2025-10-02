package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

/**
 * Test suite for the {@link MySet} component.
 */
class MySetTest {
    @Test
    @DisplayName("Constructor returns non null object")
    public void constructor_1() {
        assertNotNull(new MySet<Integer>());
    }

    @ParameterizedTest
    @MethodSource("integerArguments")
    @DisplayName("Constructor accepts varargs")
    public void constructor_2(int[] values) {
        // arguments are a compile time error so don't need assertion checking
        assertNotNull(new MySet<>(values));
    }
    static Stream<int[]> integerArguments() {
        return Stream.of(new int[]{1,2,3,4},
                         new int[]{0,-1,2,3},
                         new int[]{4,1,7,9,0});
    }

    @Test
    @DisplayName("Empty set returns size 0")
    public void size_1() {
        int expected = 0;
        assertEquals(expected, new MySet<Integer>().size());
    }
}
