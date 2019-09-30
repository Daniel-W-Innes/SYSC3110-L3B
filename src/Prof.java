import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Prof {
    private final String name;
    private Set<ProfListener> profListeners;

    private Prof() {
        this.name = "Babak";
        profListeners = new HashSet<>();
    }

    String getName() {
        return this.name;
    }

    private void setMidterm(Date date) {
        ProfEvent profEvent = new ProfEvent(this, date, EventType.NEW_MIDTERM);
        for (ProfListener profListener : profListeners) {
            profListener.update(profEvent);
        }
    }

    private void postponeMidterm(Date date) {
        ProfEvent profEvent = new ProfEvent(this, date, EventType.POSTPONED_MIDTERM);
        for (ProfListener profListener : profListeners) {
            profListener.update(profEvent);
        }
    }

    public static void main(String[] args) {

        Prof p = new Prof();
        Student s = new Student("Homer");
        Student s2 = new Student("Bart");
        TeachingAssistant ta = new TeachingAssistant();


        p.addProfListeners(s);
        p.addProfListeners(s2);
        p.addProfListeners(ta);

        Date midterm = new Date();
        p.setMidterm(midterm);

        p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
    }

// --Commented out by Inspection START (2019-09-30 10:35):
//    public void removeProfListener(ProfListener profListener) {
//        profListeners.remove(profListener);
//    }
// --Commented out by Inspection STOP (2019-09-30 10:35)

    private void addProfListeners(ProfListener profListener) {
        profListeners.add(profListener);
    }
}