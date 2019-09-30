import java.util.*;

public class Prof {
    private String name;
    private Date midtermDate;
    private Set<ProfListener> profListeners;
    private List<Student> students;
    private TeachingAssistant ta;

    private Prof(String name) {
        this.name = name;
        students = new ArrayList<>();
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

    public boolean removeProfListener(ProfListener profListener) {
        return profListeners.remove(profListener);
    }

    public boolean addProfListeners(ProfListener profListener) {
        return profListeners.add(profListener);
    }
}