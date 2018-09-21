public class Employee {

    private final Title title;
    private final String fullName;

    public Employee(Title title, String fullName)
    {
        this.title = title;
        this.fullName = fullName;
    }

    public Title getTitle() {
        return title;
    }

    public String getFullName() {
        return fullName;
    }
}
