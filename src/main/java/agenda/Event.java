package agenda;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Event {

    private String name = null;
    private Date start = null;
    private Date end = null;

    public Event(String name, Date start, Date end) throws EventError {

        if(start.isGreater(end))
            throw new EventError(String.format("Start date %s must be previous to end date %s", start.toString(), end.toString()));
        this.name = name;
        this.start = start;
        this.end = end;

        }
}
