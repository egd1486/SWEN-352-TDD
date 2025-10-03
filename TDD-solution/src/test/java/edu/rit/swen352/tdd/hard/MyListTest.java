package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyList} component.
 */
class MyListTest {
    private MyList<Object> CuT; 
    
    @Test 
    @DisplayName("Test constructor") 
    void constructorTest() { 
        CuT = new MyList<Object>(1, "2", 3.4); 
        assertNotNull(CuT, "List not created"); 
    }
}
