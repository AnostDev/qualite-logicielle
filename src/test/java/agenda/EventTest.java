package agenda;

import static org.junit.Assert.*;
import org.junit.Test;

public class EventTest {

    public EventTest() {
    }

    @Test
    public void testValidEvent() throws DateError, EventError {
        Date start = new Date(3,1,2020);
        Date end = new Date(2,1,2020);
        try {
            Event event = new Event("New year", start, end);
        }
        catch (EventError e) {
            System.err.println(e.toString());
            fail(e.toString());
        }
    }
}
