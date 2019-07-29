package com.mentoring.testing;

import java.util.Random;

/**
 * @author mkavaliou
 */
public class NumberService {

    public static final String DATABASE_TO_DELETE = "/delete/production/database";

    public Integer getNumber() {
        deleteDatabase();
        return new Random().nextInt();
    }

    public void deleteDatabase() {
        System.out.println("Your database has been truncated! You have lost all data!");
        System.out.println("Looser! This must be mocked!");
    }

    public Integer increment(Integer number) {
        return number++;
    }

}
