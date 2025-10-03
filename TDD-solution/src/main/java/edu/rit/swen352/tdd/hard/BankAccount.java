package edu.rit.swen352.tdd.hard;

/**
 * A Value Object for American monetary values with fixed integer
 * values for dollars and cents.
 */
record Money() {}

/**
 * An American bank account that permits deposits and withdrawals.
 * The balance must never be negative.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor:
 *     <ul>
 *       <li>with both an initial balance as {@link Money} value</li>
 *       <li>a no-arg ctor that sets the value to zero</li>
 *     </ul>
 *   </li>
 *   <li>getBalance: returns the current balance</li>
 *   <li>isAccountEmpty(): queries whether the balance is zero</li>
 *   <li>deposit(amount): add a {@link Money} amount to the balance</li>
 *   <li>withdraw(amount): subtract a {@link Money} amount from the balance</li>
 * </ul>
 */
public class BankAccount {

}
