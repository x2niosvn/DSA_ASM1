import Student.Student;
import Student.StudentManagement;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Car {
    public String name;
    public Car(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("====================================");
            System.out.println("|     STUDENT MANAGEMENT SYSTEM    |");
            System.out.println("====================================");
            System.out.println("| 1. Add Student                   |");
            System.out.println("| 2. Edit Student                  |");
            System.out.println("| 3. Delete Student                |");
            System.out.println("| 4. Sort Students                 |");
            System.out.println("| 5. Search Student                |");
            System.out.println("| 6. Display All Students          |");
            System.out.println("| 7. Exit                          |");
            System.out.println("====================================");
            System.out.print("Choose an option: ");



            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                //Integer.parseInt(String.valueOf(choice));

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Marks: ");
                        String marksStr = scanner.nextLine();
                        try {
                            float marks = Float.parseFloat(marksStr);
                            management.addStudent(new Student(id, name, marks));
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid input for marks. Please enter a valid number.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter Student ID to Edit: ");
                        id = scanner.nextLine();
                        System.out.print("Enter New Student Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter New Student Marks: ");
                        marksStr = scanner.nextLine();
                        try {
                            float marks = Float.parseFloat(marksStr);
                            management.editStudent(id, name, marks);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid input for marks. Please enter a valid number.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Student ID to Delete: ");
                        id = scanner.nextLine();
                        management.deleteStudent(id);
                        break;
                    case 4:
                        System.out.println("====================================");
                        System.out.println("| 1. Bubble Sort                   |");
                        System.out.println("| 2. Selection Sort                |");
                        System.out.println("| 3. Quick Sort                    |");
                        System.out.println("====================================");
                        System.out.print("Choose an sort option: ");
                        int sortchoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sortchoice) {
                            case 1:
                                management.sortStudents(1);
                                System.out.println("Students sorted by marks.");
                                break;
                            case 2:

                            default:
                                System.err.println("Invalid sort. Please try again.");
                        }
//                        management.sortStudents();
//                        System.out.println("Students sorted by marks.");
//                        break;


                        break;
                    case 5:
                        System.out.print("Enter Student ID to Search: ");
                        id = scanner.nextLine();
                        Student student = management.searchStudent(id);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.err.println("Student not found!");
                        }
                        break;
                    case 6:
                        management.displayStudents();
                        break;
                    case 7:
                        System.err.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.err.println("Invalid option. Please try again.");
                }


            }catch(InputMismatchException e){
                System.err.println("Your option isn't int value. Please try again.");
                scanner.nextLine();
            }
        }


//        Car[] arr = {new Car("Mercedes"), new Car("Volvo")};
//        for (Car c: arr) {
//            if (c.name.equals("Mercedes")) {
//                c.name = "Ford";
//            }
//        }
////        System.out.println(Arrays.toString(arr));
//        for (Car c : arr) {
//            System.out.print(c.name + "|");
//        }

    }
}