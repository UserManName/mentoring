package com.mentoring.testing;

/**
 * @author mkavaliou
 */
public abstract class AbstractCalculator {

    abstract void abstractMethod();

    public void throwException() {
        new RuntimeException("Ha-ha-ha");
    }

}
