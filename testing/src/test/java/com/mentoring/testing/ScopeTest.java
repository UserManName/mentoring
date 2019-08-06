package com.mentoring.testing;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScopeTest {

    @BeforeClass
    public void setUp1() {
        System.out.println("Execute before class 1 time.");
    }

    @BeforeMethod
    public void setUp2() {
        System.out.println("Execute before each test.");
    }

    @Test
    public void test() {
        System.out.println("Testing...");
    }

    // Disable the test!
    @Test
    public void test1() {
        System.out.println("Looser! Skip the test!");
        throw new SkipException("Skipping");
    }

    // Disable the test with testng context!
    @Test(testName = "missed")
    public void test2() {
        System.out.println("Looser! Skip the test!");
    }

    // Disable the test with label!
    @Test(enabled=false)
    public void test3() {
        System.out.println("Looser! Skip the test!");
    }
}
