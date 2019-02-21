package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

/**
* @param someone is a final string
* @return Greet string
*/

  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
