import java.util.Date;
import java.util.EventObject;

class ProfEvent extends EventObject {
    private final Date date;
    private final EventType eventType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @param date the new date
     * @throws IllegalArgumentException if source is null
     */
    ProfEvent(Object source, Date date, EventType eventType) {
        super(source);
        this.date = date;
        this.eventType = eventType;
    }

    Date getDate() {
        return date;
    }

    EventType getEventType() {
        return eventType;
    }
}
