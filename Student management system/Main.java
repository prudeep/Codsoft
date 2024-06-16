package cod;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add a new student");
        System.out.println("2. Edit an existing student");
        System.out.println("3. Search for a student");
        System.out.println("4. Display all students");
        System.out.println("5. Remove a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter roll number of student to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Student student = sms.searchStudent(rollNumber);

        if (student != null) {
            System.out.print("Enter new name (current: " + student.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new grade (current: " + student.getGrade() + "): ");
            String grade = scanner.nextLine();

            student.setName(name);
            student.setGrade(grade);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        Student student = sms.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void displayAllStudents() {
        sms.displayAllStudents();
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        sms.removeStudent(rollNumber);
    }
}
