package com.mentoring.testing;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.easymock.Mock;
import org.easymock.MockType;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;

public class ListProviderTest {

    ListProvider listProvider = new ListProvider();

    Condition<Integer> mvpStats= new Condition<Integer>() {
        @Override
        public boolean matches(Integer num) {
            return num % 2 == 0;
        }
    };

    @Mock(type = MockType.DEFAULT)
    private Entity entityMock;

    @BeforeTest
    void setUp1() {
        entityMock = mock(Entity.class);
    }

    @DataProvider
    public Object[][] localeData() {
        return new Object[][]{{"one"},{"two"},{"three"},{"four"}};
    }

    @Test
    public void getListTest() {

        //Then
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        assertThat(listProvider.getList()).contains(1,2,3,4);
        assertThat(listProvider.getList()).contains(1,2,3,4);
        assertThat(listProvider.getList()).doesNotContain(5,6,7);

    }

    @Test
    public void getOrderedListTest() {

        //Then
        assertThat(listProvider.getOrderedList()).contains(1,2,3,4);
        assertThat(listProvider.getOrderedList()).filteredOn(mvpStats).contains(2,4);
    }

    @Test(dataProvider = "localeData")
    public void getEntityTest(String name) {

        //Give
        expect(entityMock.getName()).andReturn(name);
        expect(entityMock.getValue()).andReturn(2);

        //When
        replay(entityMock);
        //Then


    }

}
