import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB); // validates range
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getID() { return ID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() { return YOB; }
    public void setYOB(int YOB) {
        if (YOB < 1940 || YOB > 2010) throw new IllegalArgumentException("YOB out of range");
        this.YOB = YOB;
    }

    /** Returns "First Last" */
    public String fullName() { return firstName + " " + lastName; }

    /** Returns "Title First Last" */
    public String formalName() { return title + " " + fullName(); }

    /** Returns current age as String */
    public String getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(year - YOB);
    }

    /** Returns age in a specified year */
    public String getAge(int year) { return String.valueOf(year - YOB); }

    /** CSV representation */
    public String toCSV() {
        return String.join(",", ID, firstName, lastName, title, String.valueOf(YOB));
    }

    /** JSON representation */
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

    /** XML representation */
    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%d</YOB></Person>",
                ID, firstName, lastName, title, YOB);
    }
}
