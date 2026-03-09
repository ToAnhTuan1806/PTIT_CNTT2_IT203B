package methodreferences;

public class Student {
    private String name;

    public Student(String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
    public Student() {

    }

    @Override
    public String toString() {
        return name;
    }
}
