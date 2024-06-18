package Student;

public class Student {
    private String id;
    private String name;
    private float marks;

    public Student(String id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + id + " | Name: " + name + " | Marks: " + marks + " | Rank: " + getRank();
    }
}