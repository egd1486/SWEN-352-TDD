package edu.rit.swen352.tdd.easy;

/**
 * MyOptional contains a single value or nothing at all.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>factories:
 *     <ul>
 *       <li>{@code empty()} -- return an empty optional</li>
 *       <li>{@code of(value:T)} -- return a non-empty optional
 *           throws {@link java.lang.NullPointerException} if {@code value} is {@code null}
 *       </li>
 *       <li>{@code ofNullable(value:T)} -- return an optional that might be empty</li>
 *       <li>NFR: hide any constructors; forces clients to use a factory function</li>
 *     </ul>
 *   </li>
 *   <li>isPresent: queries if the optional is not empty</li>
 *   <li>get: returns the value; throws {@link java.util.NoSuchElementException} if empty</li>
 *   <li>ifPresent: executes a {@link java.util.function.Consumer} if a value is present</li>
 * </ul>
 *
 * @param <T> the type of value.
 */
public class MyOptional<T> {
    T value;
    private MyOptional(T value) {
        this.value = value;
    }

    static public <E> MyOptional<E> empty() {
        return new MyOptional<E>(null);
    }

    static public <E> MyOptional<E> of(E value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return new MyOptional<>(value);
    }

    static public <E> MyOptional<E> ofNullable(E value) {
        return new MyOptional<E>(value);
    }

    public T get() {
        return value;
    }
}
