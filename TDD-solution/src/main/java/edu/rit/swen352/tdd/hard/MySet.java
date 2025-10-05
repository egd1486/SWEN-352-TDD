package edu.rit.swen352.tdd.hard;

import java.util.function.Function;

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
    private int arraySize;

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
        capacity = 16;
        buckets = (Node<T>[]) new Node<?>[capacity];
        size = 0;
        arraySize = 0;

        for (T t : varargs) {
            add(t);
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
        if (arraySize  == capacity) {
            this.resize();
        }

        return add_helper(value, buckets);
    }

    private boolean add_helper(T value, Node<T>[] array) {
        if (value == null) {
            return false;
        }

        if(array[value.hashCode() % capacity] == null) {
            array[value.hashCode() % capacity] = new Node<T>(value);
            size++;
            arraySize++;
            return true;
        }

        Node<T> currentNode = array[value.hashCode() % capacity];
        while(true) {
            if (currentNode.value.equals(value)) {
                return false;
            }

            if (currentNode.next == null) {
                currentNode.next = new Node<T>(value);
                size++;
                return true;
            }

            currentNode = currentNode.next;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<T>[] newBuckets = (Node<T>[]) new Node<?>[capacity * 2];
        capacity *= 2;
        size = 0;
        arraySize = 0;
        for (int i = 0; i < buckets.length; i++) {
            reAddNodesToNewBucket(buckets[i], newBuckets);
        }
        this.buckets = newBuckets;
    }

    private void reAddNodesToNewBucket(Node<T> node, Node<T>[] newBuckets) {
        if (node == null) {
            return;
        }
        reAddNodesToNewBucket(node.next, newBuckets);
        add_helper(node.value, newBuckets);
    }

    public <E> MySet<E> map(Function<T, E> function) {
        assert false;
        return null;
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
