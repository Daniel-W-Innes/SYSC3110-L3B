import java.util.Date;

public class Student implements ProfListener{
    private String name;
    private Date midterm;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void study(Date date) {
        this.midterm = date;
        System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
    }

    private void party(Date date) {
        this.midterm = date;
        System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
    }

    @Override
    public void update(ProfEvent profEvent) {
        switch (profEvent.getEventType()) {
            case NEW_MIDTERM:
                study(profEvent.getDate());
                break;
            case POSTPONED_MIDTERM:
                party(profEvent.getDate());
                break;
        }
    }
}