import java.util.Date;

public class TeachingAssistant implements ProfListener {
    private final String name;
    private Date midterm;

    TeachingAssistant() {
        this.name = "Michael";
    }

    private void proctor(Date date) {
        this.midterm = date;
        System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
    }

    private void postpone(Date date) {
        this.midterm = date;
        System.out.println(name + " : Now the midterm is on " + this.midterm);
    }

    @Override
    public void update(ProfEvent profEvent) {
        switch (profEvent.getEventType()) {
            case NEW_MIDTERM:
                proctor(profEvent.getDate());
                break;
            case POSTPONED_MIDTERM:
                postpone(profEvent.getDate());
                break;
        }
    }
}