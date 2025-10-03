package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Counter} component.
 */
class CounterTest {

}



    @Test 
    @DisplayName("Test adding an element to the list")
    void addTest() {
        CuT = new MyList<Object>(); 
        assertEquals(CuT.size(), 0, "List size incorrect");
        CuT.add(1);
        assertEquals(CuT.get(0), 1, "List element incorrect");

        CuT = new MyList<Object>(); 
        assertEquals(CuT.size(), 0, "List size incorrect");
        assertThrows(NullPointerException.class, () -> {
            CuT.add(null);
        });
    }

        public void add(Object ele) {
        assert false: "Not yet implemented";
    }