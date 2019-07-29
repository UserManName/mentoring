package com.mentoring.testing;

import static com.mentoring.testing.NumberService.DATABASE_TO_DELETE;

/**
 * @author mkavaliou
 */
public class Calculator {

    private NumberService numberService = new NumberService();

    public Integer getPublicNumber() {
        return numberService.getNumber();
    }

    protected Integer getProtectedNumber() {
        return numberService.getNumber();
    }

    private Integer getPrivateNumber() {
        return numberService.getNumber();
    }

    public Integer getIncrementedNumber() {
        Integer number = numberService.getNumber();
        return number ++;
    }

    public Integer incrementNumber(Integer number) {
        return numberService.increment(number);
    }

    public Integer deletingNumber(Integer number) {
        numberService.deleteDatabase();
        return 42;
    }

    public String getDeletedDatabase(Integer number) {
        System.out.println("You are going to delete:" + DATABASE_TO_DELETE);
        return DATABASE_TO_DELETE;
    }

    public void TripleDelete() {
        numberService.deleteDatabase();
        numberService.deleteDatabase();
        numberService.deleteDatabase();
        System.out.println("The deleteDatabase must be invoked 3 times!");
        System.out.println("The text must be shown!");
    }

}
