package agenda;

import lombok.Data;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

@Data
public class Agenda {

    private List<Event> events = Collections.synchronizedList( new ArrayList<>());

    boolean add(Event event) {
        for(Event e : events) {
            if(event.getEnd().compareTo(e.getStart()) >= 0 && event.getStart().compareTo(e.getEnd()) <= 0)
                return false;
        }
        events.add(event);
        return true;
    }

    boolean delete(String name) {
        boolean res = false;
        Event remove = null;
        for(Event e : events) {
            if(e.getName().equals(name)){
                remove = e;
            }
        }
        if(remove != null) {
            events.remove(remove);
            res = true;
        }
        return res;
    }

    String searchEvent(Date d) throws AgendaError {
        boolean found = false;
        String eventName = String.format("Not found event at date %s", d.toString());
        for(Event e : events) {
            if(e.getStart().compareTo(d) == 0) {
                eventName = e.getName();
                found = true;
            }
        }
        if(!found) throw new AgendaError(eventName);
        return eventName;
    }

    boolean isPlannedEvent(String name) throws AgendaError {
        boolean found = false;
        for(Event e: events) {
            if (e.getName().equals(name)) {
                found = true;
            }
        }
        if(!found) {
            throw new AgendaError(String.format("Not found event with name %s", name));
        }
        return true;
    }

    Date getStartDate(String name) throws AgendaError {
        Date found = null;
        for(Event e: events) {
            if(e.getName().equals(name)) {
                found = e.getStart();
            }
        }
        if(found != null)
            return found;
        else {
            throw new AgendaError(String.format("Couldn't find an Event with starting date %s", found));
        }
    }

    Date getEndDate(String name) throws AgendaError {
        Date found = null;
        for(Event e: events) {
            if(e.getName().equals(name)) {
                found = e.getEnd();
            }
        }
        if(found != null)
            return found;
        else {
            throw new AgendaError(String.format("Couldn't find an Event with ending date %s", found.toString()));
        }
    }

}
