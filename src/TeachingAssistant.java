import java.util.Date;

public class TeachingAssistant implements ProfListener {
    private String name;
    private Date midterm;

    TeachingAssistant(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    void proctor(Date date) {
        this.midterm = date;
        System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
    }

    void postpone(Date date) {
        this.midterm = date;
        System.out.println(name + " : Now the midterm is on " + this.midterm);
    }

    @Override
    public void update() {

    }
}