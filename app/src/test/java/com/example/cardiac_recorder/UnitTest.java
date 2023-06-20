package com.example.cardiac_recorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Date;

public class UnitTest {

    /**
     * Unit testing addUserData method
     */

    @Test
    public void testaddUserData()
    {
        UserClass dataList = new UserClass();
        User data1 = new User("120","80","120/80","12-05-2023","Normal","7 pm");
        dataList.addUserData(data1);
        assertEquals(1,dataList.getData().size());

        User data2 = new User("130","90","130/90","20-08-2023","High","10 am");
        dataList.addUserData(data2);
        assertEquals(2,dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));
    }

    /**
     * Unit testing deleteUserData method
     */

    @Test
    public void testdeleteUserData()
    {
        UserClass dataList = new UserClass();

        User data1 = new User("125","85","125/85","16-05-2022","Normal","4 pm");
        dataList.addUserData(data1);
        assertEquals(1,dataList.getData().size());

        User data2 = new User("135","95","135/95","20-05-2022","High","11 am");
        dataList.addUserData(data2);
        assertEquals(2,dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));

        dataList.deleteUserData(data1);
        assertEquals(1,dataList.getData().size());
        assertFalse(dataList.getData().contains(data1));

        dataList.deleteUserData(data2);
        assertEquals(0,dataList.getData().size());
        assertFalse(dataList.getData().contains(data2));

    }

    /**
     * Unit testing addUserData method for Exception
     */

    @Test
    public void testaddUserDataException()
    {
        UserClass dataList = new UserClass();

        User data1 = new User("100","70","100/70","25-08-2022","Low","9 pm");
        dataList.addUserData(data1);
        assertThrows(IllegalArgumentException.class,() -> dataList.addUserData(data1));
    }

    /**
     * Unit testing deleteUserData method for Exception
     */

    @Test
    public void testdeleteUserDataException()
    {
        UserClass dataList = new UserClass();

        User data1 = new User("95","60","95/60","30-10-2023","Very Low","9 am");
        dataList.addUserData(data1);

        dataList.deleteUserData(data1);
        assertThrows(IllegalArgumentException.class,() -> dataList.deleteUserData(data1));
    }

    @Test
    public void testCount()
    {
        UserClass dataList = new UserClass();

        User data1 = new User("140","95","140/95","09-10-2023","Very High","8 am");
        dataList.addUserData(data1);
        assertEquals(1,dataList.count());

        dataList.deleteUserData(data1);
        assertEquals(0,dataList.count());
    }
}
