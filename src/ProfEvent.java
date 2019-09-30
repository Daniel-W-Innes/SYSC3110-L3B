import java.util.Date;
import java.util.EventObject;

public class ProfEvent extends EventObject {
    private final Date date;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ProfEvent(Object source, Date date) {
        super(source);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
