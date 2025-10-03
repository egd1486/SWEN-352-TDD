package edu.rit.swen352.tdd.hard;

import java.lang.reflect.Array;

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

    private Node<T>[] buckets;
    private int size;
    private int capacity;

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public MySet(T... varargs) {
        /*
         * new Node<T>[] (with any type T)
         * is not possible due to type erasure
         * 
         * Node<?>[] casting to the type is safe in this case
         * as we know that we are only going to store type T in it.
         * 
         * One could also do Node[] with a raw type
         * but this shows more intent that we are storing some
         * Node with a type, rather than just a raw typed Node
         */
        buckets = (Node<T>[]) new Node<?>[16];
        capacity = 16;

        for (int i = 0; i < varargs.length; i++) {
            buckets[i] = new Node<T>(varargs[i]);
            size++;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        for (Node<T> node : buckets) {
            if (node == null) {
                continue;
            }
            if (node.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T value) {
        if (this.contains(value)) {
            return false;
        }
        buckets[size] = new Node<T>(value);
        size++;
        return true;
    }

    /*
     * This class needs to be private static,
     * as it is intended only to be used by the outer class,
     * and without an instance of the outer class
     * 
     * It also makes it possible to do
     * (Node<T>[]) new Node<?>[16];
     * Or else you would be creating a generic array of MySet<T>.Node<T>
     * which is not allowed
     * 
     * static makes it a MySet.Node<T> array,
     *  which is allowed with casting
     */
    private static class Node<T> {
        private final T value;
        private Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }
}
