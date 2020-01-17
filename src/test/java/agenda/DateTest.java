package agenda;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest {

    public DateTest() {
    }

    @Test
    public void testValidLeapYearDate() throws DateError {
        Date date = new Date(29,2,2020);
        assertNotNull(date);
        System.out.println(date.toString());
    }

    @Test
    public void testValidLeapYearDateM100() throws DateError {
        Date date = new Date(29,2,2000);
        assertNotNull(date);
        System.out.println(date.toString());
    }

    @Test
    public void testValidNonLeapYearDate() throws DateError {
        Date date = new Date(28,2,2019);
        assertNotNull(date);
        System.out.println(date.toString());
    }

    @Test
    public void testInvalidNonLeapYearDate() throws DateError {
        try {
            Date date = new Date(29,2,2019);
        }
        catch (DateError e) {
            System.err.println(e);
            fail(e.toString());
        }
    }

    @Test
    public void testInvalidDay() throws DateError {
        try {
            Date date = new Date(0,2,2020);
        }
        catch (DateError e) {
            System.err.println(e);
            fail(e.toString());
        }
    }

    @Test
    public void testInvalidMonth() throws DateError {
        try {
            Date date = new Date(1,0,2020);
        }
        catch (DateError e) {
            System.err.println(e);
            fail(e.toString());
        }
        //assertNotNull(date);
    }

    @Test
    public void testInvalidYear() throws DateError {
        try {
            Date date = new Date(1,1,1989);
        }
        catch (DateError e) {
            System.err.println(e);
            fail(e.toString());
        }
        //assertNotNull(date);
    }

}
