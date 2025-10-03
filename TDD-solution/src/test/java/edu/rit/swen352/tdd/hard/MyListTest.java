package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.List;

/**
 * Test suite for the {@link MyList} component.
 */
class MyListTest {
    private MyList<Object> CuT; 
    
    @Test 
    @DisplayName("Test creating constructor") 
    void constructorTest() { 
        CuT = new MyList<Object>(1, "2", 3.4); 
        assertNotNull(CuT, "List not created"); 
    }

    @Test 
    @DisplayName("Test if list is empty")
    void isEmptyTest() {
        CuT = new MyList<Object>(); 
        assertEquals(CuT.isEmpty(), true, "List is not empty"); 

        CuT = new MyList<Object>(1, "2", 3.4); 
        assertEquals(CuT.isEmpty(), false, "List is empty"); 
    }

    @Test 
    @DisplayName("Test how many elements are in the list")
    void sizeTest() {
        CuT = new MyList<Object>(1, "2", 3.4); 
        assertEquals(CuT.size(), 3, "List size is incorrect");

        CuT = new MyList<Object>(); 
        assertEquals(CuT.size(), 0, "List size is incorrect");
    }

    @Test 
    @DisplayName("Test getting an element in the list")
    void getTest() {
        CuT = new MyList<Object>(1, "2", 3.4); 
        assertEquals(CuT.get(1), "2", "List element is incorrect");

        assertThrows(java.util.NoSuchElementException.class, () -> {
            CuT.get(5);
        });
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

    @Test 
    @DisplayName("Test removing an element at index") 
    void removeTest() {
        CuT = new MyList<Object>(1, "2", 3.4); 
        CuT.remove(1);
        assertEquals(CuT.size(), 2, "Element not removed");

        assertThrows(java.util.NoSuchElementException.class, () -> {
            CuT.remove(5);
        });
    }

    @Test 
    @DisplayName("Test looping through list")
    void forEachTest() {
        CuT = new MyList<Object>(1, "2", 3.4); 
        List<Object> newLst = new ArrayList<>();
        Consumer consumer = element -> {
            newLst.add(element);
        };
        CuT.forEach(consumer);
        assertEquals(newLst.get(0), 1, "Element not added changed");
        assertEquals(newLst.get(1), "2", "Element not added changed");
        assertEquals(newLst.get(2), 3.4, "Element not added changed");
    }
}
