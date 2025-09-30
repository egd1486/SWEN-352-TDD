package edu.rit.swen352.tdd.easy;

/**
 * An temperature measurement.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor:
 *     <ul>
 *       <li>with both a value as {@code double} and a unit</li>
 *       <li>with just a value; unit is defaulted to {@link TemperatureUnit#CELSIUS}</li>
 *       <li>NOTE: no temperature may be below absolute zero</li>
 *     </ul>
 *   </li>
 *   <li>convertTo(unit): create a new Temperature in the new unit</li>
 * </ul>
 */
public class Temperature {
  public enum TemperatureUnit {
    CELSIUS, FAHRENHEIT, KELVIN;
  }
}
