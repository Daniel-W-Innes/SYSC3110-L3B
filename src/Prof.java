import java.util.ArrayList;
import java.util.Date;

public class Prof {
    private String name;
    private Date midtermDate;
    private ArrayList<Student> students;
    private TeachingAssistant ta;

    private Prof(String aName) {
        this.name = aName;
        this.students = new ArrayList<>();
    }

    public Date getMidterm() {
        return this.midtermDate;
    }

    public String getName() {
        return this.name;
    }

    private void setMidterm(Date date) {
        this.midtermDate = date;
        for(Student s: this.students){
            s.study(date);
        }
        ta.proctor(date);
    }

    private void postponeMidterm(Date date) {
        this.midtermDate = date;
        for(Student s: this.students){
            s.party(date);
        }
        ta.postpone(date);
    }

    private void setTA(TeachingAssistant theTA) {
        this.ta = theTA;
    }

    private void addStudent(Student s) {
        this.students.add(s);
    }


    public static void main(String[] args) {

        Prof p = new Prof("Babak");
        Student s = new Student("Homer");
        Student s2 = new Student("Bart");
        TeachingAssistant ta = new TeachingAssistant("Michael");


        p.addStudent(s);
        p.addStudent(s2);
        p.setTA(ta);

        Date midterm = new Date();
        p.setMidterm(midterm);

        p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
    }

}