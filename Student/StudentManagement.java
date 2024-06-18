package Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {

    private List<Student> students = new ArrayList<>();


    public void addStudent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.getId().equals(student.getId())) {
                System.err.println("Student ID already exists!");
                return;
            }
        }
        if(student.getMarks() < 0 || student.getMarks() > 10){
            System.err.println("Error Mark!");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void editStudent(String id, String newName, float newMarks) {
        for (Student student : students) {
            if(student.getMarks() < 0 || student.getMarks() > 10){
                System.err.println("Error Mark!");
                return;
            }
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                return;
            }

        }

        System.err.println("Student not found!");
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));

    }

    public void sortStudents(int sc) {
        int n = students.size();

        switch (sc) {
            case 1:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - 1 - i; j++) {
                        if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                            // Swap students[j] and students[j+1]
                            Student temp = students.get(j);
                            students.set(j, students.get(j + 1));
                            students.set(j + 1, temp);
                        }
                    }
                }

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.err.println("Invalid sort option.");
        }


    }



    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        if(!students.isEmpty()){
            for (Student student : students) {
                System.out.println(student);
            }
        }else{
            System.err.println("No student found to display.");
        }
    }
}