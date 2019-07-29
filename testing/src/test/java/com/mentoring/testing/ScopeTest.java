package com.mentoring.testing;

import org.testng.annotations.Test;

public class ScopeTest {

    public void setUp1() {
        System.out.println("Execute before class 1 time.");
    }

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
    }

    // Disable the test with testng context!
    @Test
    public void test2() {
        System.out.println("Looser! Skip the test!");
    }

    // Disable the test with label!
    @Test
    public void test3() {
        System.out.println("Looser! Skip the test!");
    }
}
