import java.util.Date;

public class Student implements ProfListener{
    private String name;
    private Date midterm;

    Student(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    void study(Date date) {
        this.midterm = date;
        System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
    }

    void party(Date date) {
        this.midterm = date;
        System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
    }

    @Override
    public void update() {

    }
}