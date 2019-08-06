package com.mentoring.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AbstractCalculatorTest {

    public static final String MESSAGE = "message";

    AbstractCalculator abstractCalculator;

    @BeforeClass
    void sutUp() {
        abstractCalculator = new AbstractCalculator() {
            @Override
            void abstractMethod() {
                System.out.println(MESSAGE);
            }
        };
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Ha-ha-ha")
    public void throwExceptionTest() throws RuntimeException {

        //Then
        abstractCalculator.throwException();
    }

}
