import java.util.ArrayList;
import java.util.Scanner;

// Parent Class
class Person {
    String name;

    Person() {
        name = "";
    }

    Person(String name) {
        this.name = name;
    }
}

// Student Class Inheriting Person
class Student extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    // Default Constructor
    Student() {
        super();
        rollNo = 0;
        course = "";
        marks = 0.0;
        grade = ' ';
    }

    // Parameterized Constructor
    Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // Input Details from User
    void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();

        calculateGrade();
    }

    // Calculate Grade
    void calculateGrade() {
        if (marks >= 90)
            grade = 'A';
        else if (marks >= 75)
            grade = 'B';
        else if (marks >= 60)
            grade = 'C';
        else
            grade = 'D';
    }

    // Display Details
    void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------------");
    }
}

// Main Class - Menu System
public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.inputDetails();
                    list.add(s);
                    System.out.println("Student Added Successfully!\n");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Records Found!\n");
                    } else {
                        System.out.println("\n===== Student Records =====");
                        for (Student std : list) {
                            std.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Try Again.\n");
            }
        }
    }
}

       
