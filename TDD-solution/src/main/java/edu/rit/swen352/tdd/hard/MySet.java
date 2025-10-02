package edu.rit.swen352.tdd.hard;

import java.util.Set;

/**
 * MySet is a flexible-sized, unordered collection of elements.
 * The {@link Object#equals(Object)} method is used to determine if two values are equal.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor: with varargs of initial elements</li>
 *   <li>isEmpty: queries if the set is empty</li>
 *   <li>size: queries how many elements in the set</li>
 *   <li>contains: queries whether the supplied object exists (by equality) in the set</li>
 *   <li>add: add an element to the set; no-op if the element is already in the set (by equality)</li>
 *   <li>remove: remove an element by equality</li>
 *   <li>map: creates a new set where each element is transformed by a {@link java.util.function.Function}</li>
 *   <li>NFR: the {@code contains} method executes in O(1) (<em>constant</em>) time</li>
 * </ul>
 *
 * @param <T> the type of elements in the set.
 */
public class MySet<T> {

    private Object[][] buckets;
    private int size;

    @SafeVarargs
    public MySet(T... varags) {
        buckets = new Object[16][2];

        for (int i = 0; i < varags.length; i++) {
            buckets[i][0] = varags[i];
            size++;
        }
    }

    public int size(){
        return size;
    }
}
