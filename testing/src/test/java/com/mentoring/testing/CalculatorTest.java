package com.mentoring.testing;

import javafx.scene.effect.Reflection;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.powermock.reflect.Whitebox;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.resetToDefault;
import static org.testng.Assert.assertEquals;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.expect;
import static com.mentoring.testing.NumberService.DATABASE_TO_DELETE;

public class CalculatorTest {
//рефлексия, аргументы, junit mokito, заменить параметры, аргументы, пропуск тестов
    @TestSubject
    private Calculator calculator;

    @Mock(type = MockType.DEFAULT)
    private NumberService numberService;

    @BeforeTest
    void setUp1() {
        numberService = mock(NumberService.class);
        calculator = new Calculator();
        ReflectionTestUtils.setField(calculator, "numberService", numberService);
    }

    @BeforeMethod
    void setUp2() {
        resetToDefault(numberService);
    }

    @Test
    public void getIncrementedNumberTest() {
        //Give
        expect(numberService.getNumber()).andReturn(4);
        //When
        replay(numberService);
        //Than
        assertEquals(calculator.getIncrementedNumber(), new Integer(5));
    }

    @Test// assert Argument // multiple parameters
    public void incrementedNumberTest() {
        //Give
        expect(numberService.increment(2)).andReturn(2);
        //When
        replay(numberService);
        //Than
        assertEquals(calculator.incrementNumber(2), new Integer(2));
    }

    //@DataProvider

    @Test
    public void deletingNumberTest() {
        //Give
        //When
        //Than
        assertEquals(calculator.deletingNumber(2), new Integer(42));
    }

    @Test// PowerMock
    public void getDeletedDatabaseTest() {
        //Give
        Whitebox.getInternalState();
        //When

        //Than
        assertEquals(calculator.getDeletedDatabase(1), DATABASE_TO_DELETE);
    }

    @Test
    public void tripleDeleteTest() {
        //Give
        numberService.deleteDatabase();
        expectLastCall().times(3);
        //When
        replay(numberService);
        calculator.TripleDelete();
        //Than
        verify(numberService);
    }

    @Test
    public void getPublicNumberTest() {
        //Give
        expect(numberService.getNumber()).andReturn(3);
        //When
        replay(numberService);
        //Than
        assertEquals(calculator.getPublicNumber(), new Integer(3));
    }

    @Test
    public void getProtectedNumberTest() {
        //Give
        expect(numberService.getNumber()).andReturn(4);
        //When
        replay(numberService);
        //Than
        assertEquals(calculator.getProtectedNumber(), new Integer(4));
    }

    @Test // SpringUtils
    public void getPrivateNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Give
        expect(numberService.getNumber()).andReturn(5);
        //When
        replay(numberService);
        //Than
        assertEquals(ReflectionTestUtils.invokeMethod(calculator, "getPrivateNumber"), 5);
    }
}
