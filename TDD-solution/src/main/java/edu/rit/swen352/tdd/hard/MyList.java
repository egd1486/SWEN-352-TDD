package edu.rit.swen352.tdd.hard;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


/**
 * MyList is a flexible-sized sequence of elements with no gaps.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor: with varargs of initial elements</li>
 *   <li>isEmpty: queries if the list is empty</li>
 *   <li>size: queries how many elements in the list</li>
 *   <li>get: returns the element at a specific index;
 *     throw {@link java.util.NoSuchElementException} if the index is outside the size of the list</li>
 *   <li>add: add an element to the end of the list; nulls not allowed</li>
 *   <li>remove: remove an element by index</li>
 *   <li>forEach: iterates over each element and executes the {@link java.util.function.Consumer} parameter</li>
 * </ul>
 *
 * @param <T> the type of elements in the list.
 */
public class MyList<T> {
    private List<T> lst;

    public MyList(T... lst) { //varargs = ... (0 or more)
        this.lst = new ArrayList<>(Arrays.asList(lst));
    }

    public boolean isEmpty() {
        if (lst.size() > 0) {
            return false;
        }
        return true;
    }

    public int size() {
       return lst.size();
    }

    public T get(int idx) {
        if(idx > lst.size()-1) {
            throw new java.util.NoSuchElementException("Out of bounds");
        }
        else {
            return lst.get(idx);
        }
    }

    public void add(T ele) {
        if (ele == null) {
            throw new NullPointerException("Cannot add null to list");
        }
        else {
            lst.add(ele);
        }
    }

    public void remove(int idx) {
        if(idx > lst.size()-1) {
            throw new java.util.NoSuchElementException("Out of bounds");
        }
        else {
            lst.remove(idx);
        }
    }
}

