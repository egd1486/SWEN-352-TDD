package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
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

    @Test
    @DisplayName("Size returns number of elements in set")
    public void size_2() {
        int expected = 4;
        MySet<Integer> testSet = new MySet<>(1,2,3,4);
        assertEquals(expected, testSet.size());

    }

    @Test
    @DisplayName("Adding many items returns expected size")
    public void size_3() {
        MySet<Integer> testSet = new MySet<>();

        int expectedSize = 30;
        for (int i = 0; i < expectedSize; i++) {
            testSet.add(i);
        }

        assertEquals(expectedSize, testSet.size());
    }

    @Test
    @DisplayName("Contains returns false when not in set")
    public void contains_1() {
        int contains = 1;
        MySet<Integer> testSet = new MySet<>();
        assertFalse(testSet.contains(contains));
    }

    @Test
    @DisplayName("Contains returns true when in set")
    public void contains_2() {
        int contains = 1;
        MySet<Integer> testSet = new MySet<>(contains);
        assertTrue(testSet.contains(contains));
    }

    @Test
    @DisplayName("Add does not add already added elements")
    public void add_1() {
        int contains = 1;
        int expectedSize = 1;
        MySet<Integer> testSet = new MySet<>(contains);
        assertFalse(testSet.add(contains));
        assertEquals(expectedSize, testSet.size());
    }

    @Test
    @DisplayName("Adding new element increases size, stays in set, and returns true")
    public void add_2() {
        int contains = 1;
        int addedValue = 2;
        int expectedSize  = 2;
        MySet<Integer> testSet = new MySet<>(contains);
        assertTrue(testSet.add(addedValue));
        assertEquals(expectedSize, testSet.size());
    }

    @Test
    @DisplayName("Map returns new empty set when mapping an empty set")
    public void map_1() {
        Function<Integer,String> x = new Function<Integer,String>() {
            @Override
            public String apply(Integer t) {
                return t.toString();
            }
        };

        int expectedSize = 0;
        MySet<Integer> testSet = new MySet<>();
        MySet<String> newSet = testSet.map(x);

        assertNotEquals(testSet, newSet);
        assertEquals(expectedSize, newSet.size());
    }
}
