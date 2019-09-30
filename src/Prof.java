import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Prof {
    private String name;
    private Date midtermDate;
    private Set<ProfListener> profListeners;

    private Prof(String name) {
        this.name = name;
        profListeners = new HashSet<>();
    }

    public Date getMidterm() {
        return this.midtermDate;
    }

    public String getName() {
        return this.name;
    }

    private void setMidterm(Date date) {
        this.midtermDate = date;
        ProfEvent profEvent = new ProfEvent(this, date, EventType.NEW_MIDTERM);
        for (ProfListener profListener : profListeners) {
            profListener.update(profEvent);
        }
    }

    private void postponeMidterm(Date date) {
        this.midtermDate = date;
        ProfEvent profEvent = new ProfEvent(this, date, EventType.POSTPONED_MIDTERM);
        for (ProfListener profListener : profListeners) {
            profListener.update(profEvent);
        }
    }

    public static void main(String[] args) {

        Prof p = new Prof("Babak");
        Student s = new Student("Homer");
        Student s2 = new Student("Bart");
        TeachingAssistant ta = new TeachingAssistant("Michael");


        p.addProfListeners(s);
        p.addProfListeners(s2);
        p.addProfListeners(ta);

        Date midterm = new Date();
        p.setMidterm(midterm);

        p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
    }

    public void removeProfListener(ProfListener profListener) {
        profListeners.remove(profListener);
    }

    private void addProfListeners(ProfListener profListener) {
        profListeners.add(profListener);
    }
}