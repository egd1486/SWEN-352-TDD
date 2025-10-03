package edu.rit.swen352.tdd.hard;

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
    private T[] lst;

    public MyList(T... lst) { //varargs = ... (0 or more)
        this.lst = lst;
    }

    public boolean isEmpty() {
        if (lst.length > 0) {
            return false;
        }
        return true;
    }

    public int size() {
       return lst.length;
    }

    public T get(int idx) {
        if(idx > lst.length-1) {
            throw new java.util.NoSuchElementException("Out of bounds");
        }
        else {
            return lst[idx];
        }
    }
}

