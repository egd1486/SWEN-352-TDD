package edu.rit.swen352.tdd.easy;

/**
 * An integral counter with an optional lower and upper bound.
 * The count must start at the lower limit and must not exceed the upper limit.
 * The count must never drop below the lower limit.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor:
 *     <ul>
 *       <li>with both lower and upper bounds</li>
 *       <li>one that supplies a lower bound and defaults the upper limit to MAX_INTEGER</li>
 *       <li>a third (no-args) that also defaults the lower limit to 0</li>
 *       <li>NOTE: once set in a ctor the bounds attributes must be fixed</li>
 *     </ul>
 *   </li>
 *   <li>getLower: access lower limit</li>
 *   <li>getUpper: access upper limit</li>
 *   <li>getCount: access the current state of the counter</li>
 *   <li>increment: increase the count by one; throw {@link IllegalStateException} if count is already at the upper limit</li>
 *   <li>decrement: decrease the count by one; throw {@link IllegalStateException} if count is already at the lower limit</li>
 * </ul>
 */
public class Counter {
}
