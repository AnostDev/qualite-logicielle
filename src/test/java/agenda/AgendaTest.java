package agenda;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.xml.crypto.Data;

public class AgendaTest {

    public AgendaTest() {
    }

    @Test
    public void testCreateAgenda() {
        Agenda agenda = new Agenda();
        assertNotNull(agenda);
        assertNotNull(agenda.getEvents());
        assertTrue(agenda.getEvents().size() == 0);
    }



    @Test
    public void testSearchEvent() throws DateError, EventError, AgendaError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,1,2020);
        Event event = new Event(name, start, end);
        agenda.add(event);

        String nameFound = agenda.searchEvent(start);
        assertTrue(name.equals(nameFound));
    }

    @Test
    public void testPlannedEvent() throws DateError, EventError, AgendaError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,1,2020);
        Event event = new Event(name, start, end);
        agenda.add(event);
        assertTrue(agenda.isPlannedEvent(name));
    }


    @Test
    public void testGetStartDate() throws DateError, EventError, AgendaError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,1,2020);
        Event event = new Event(name, start, end);
        agenda.add(event);
        assertTrue(start.compareTo(agenda.getStartDate(name)) == 0);
    }


    @Test
    public void testFailGetStartDate() throws DateError, EventError, AgendaError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,1,2020);
        Event event = new Event(name, start, end);
        agenda.add(event);

        try {
            Date date = agenda.getStartDate("This should raise an exception");
        }
        catch (AgendaError e) {
            System.err.println(e);
            fail(e.toString());
        }
    }


    @Test
    public void testGetEndDate() throws DateError, EventError, AgendaError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,1,2020);
        Event event = new Event(name, start, end);
        agenda.add(event);
        assertTrue(end.compareTo(agenda.getEndDate(name)) == 0);
    }

    @Test
    public void testDelete() throws EventError, DateError {
        Agenda agenda = new Agenda();
        String name = "Examen_AMU";
        String name2 = "Annee_AMU";
        Date start = new Date(4,1,2020);
        Date end = new Date(10,10,2020);
        Date start2 = new Date(4,11,2020);
        Date end2 = new Date(25,11,2020);
        Event event = new Event(name, start, end);
        Event event2 = new Event(name2, start2, end2);
        agenda.add(event);
        agenda.add(event2);

        assertTrue(agenda.delete(name2));
    }


    @Test
    public void testCreateOverlapAgenda() throws EventError, DateError {
        Agenda agenda = new Agenda();
        String name = "Examen AMU";
        String name2 = "Annee AMU";
        Date start = new Date(4,1,2019);
        Date end = new Date(10,1,2020);

        Date start2 = new Date(4,9,2019);
        Date end2 = new Date(25,4,2020);

        Event event = new Event(name, start, end);
        Event event2 = new Event(name2, start2, end2);
        assertTrue(agenda.add(event));
        assertFalse(agenda.add(event2));
    }


}
