package com.mentoring.testing;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.mentoring.testing.NumberService.DATABASE_TO_DELETE;

@RunWith(DataProviderRunner.class)
public class CalculatorSecondTest {
    //рефлексия, аргументы, junit mokito, заменить параметры, аргументы, пропуск тестов

    private Calculator calculator = new Calculator();;

    @Mock
    private NumberService numberService;

    @Before
    public void setUp() {
        numberService = mock(NumberService.class);
        ReflectionTestUtils.setField(calculator, "numberService", numberService);
    }

    @DataProvider
    public static Object[][] localeData() {
        return new Object[][]{{1},{2},{3},{4}};
    }

    @Test
    public void getIncrementedNumberTest() {
        //Give
        when(numberService.getNumber()).thenReturn(4);
        //When
        //Than
        assertEquals(calculator.getIncrementedNumber(), new Integer(5));
    }

    @Test    // assert Argument // multiple parameters
    @UseDataProvider("localeData")
    public void incrementedNumberTest(int num) {
        //Give
        when(numberService.increment(num)).thenReturn(num);
        //When
        //Than
        assertEquals(calculator.incrementNumber(num), new Integer(num));
    }

    //@DataProvider

    @Test
    public void deletingNumberTest() {
        //Give
        //When
        //Than
        assertEquals(calculator.deletingNumber(anyInt()), new Integer(42));
        verify(numberService, times(1)).deleteDatabase();
    }

    @Test// PowerMock
    public void getDeletedDatabaseTest() {
        //Give
        Whitebox.getInternalState("/delete/noproduction/database", "DATABASE_TO_DELETE", numberService.getClass());

        //When
        //Than
        assertEquals(calculator.getDeletedDatabase(1), "/delete/noproduction/database");
    }

    @Test
    public void tripleDeleteTest() {
        //Give
        //When
        calculator.TripleDelete();
        //Than
        verify(numberService, times(3)).deleteDatabase();
    }

    @Test
    public void getPublicNumberTest() {
        //Give
        when(numberService.getNumber()).thenReturn(3);
        //When
        Integer i = calculator.getPublicNumber();
        //Than
        assertEquals(i, new Integer(3));
    }

    @Test
    public void getProtectedNumberTest() {
        //Give
        when(numberService.getNumber()).thenReturn(4);
        //When
        //Than
        assertEquals(calculator.getProtectedNumber(), new Integer(4));
    }

    @Test // SpringUtils
    public void getPrivateNumberTest() {
        //Give
        when(numberService.getNumber()).thenReturn(5);
        //When
        //Than
        assertEquals(ReflectionTestUtils.invokeMethod(calculator, "getPrivateNumber"), 5);
    }
}
