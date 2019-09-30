import java.util.Date;

public class Student implements ProfListener{
    private final String name;
    private Date midterm;

    Student(String name) {
        this.name = name;
    }

    private void study(Date date, String profName) {
        this.midterm = date;
        System.out.println(name + " : Doh! I have to study hard for my midterm for " + profName + " on " + this.midterm);
    }

    private void party(Date date, String profName) {
        this.midterm = date;
        System.out.println(name + " : Alright! I get to party since my midterm for " + profName + " isn't until " + this.midterm);
    }

    @Override
    public void update(ProfEvent profEvent) {
        switch (profEvent.getEventType()) {
            case NEW_MIDTERM:
                study(profEvent.getDate(), ((Prof) profEvent.getSource()).getName());
                break;
            case POSTPONED_MIDTERM:
                party(profEvent.getDate(), ((Prof) profEvent.getSource()).getName());
                break;
        }
    }
}