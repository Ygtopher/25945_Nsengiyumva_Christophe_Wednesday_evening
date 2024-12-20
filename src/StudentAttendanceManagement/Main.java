package StudentAttendanceManagement;

import java.util.*;
import java.util.regex.*;
import java.util.Scanner;

// Main class for testing with user input
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceSystem attendanceSystem = new AttendanceSystem();

        // Add students interactively with validation
        for (int i = 0; i < 3; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Enter details for Student " + (i + 1) + ":");

                System.out.print("Name: ");
                String name = scanner.nextLine();

                // Validate student ID (must be exactly 6 digits)
                int id = -1;
                while (id == -1) {
                    System.out.print("ID (6 digits): ");
                    String idInput = scanner.nextLine();
                    if (idInput.matches("\\d{6}")) {
                        id = Integer.parseInt(idInput);
                    } else {
                        System.out.println("Invalid ID. Please enter a 6-digit numeric ID.");
                    }
                }

                // Validate email format
                String email = "";
                while (true) {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        break; // valid email, exit the loop
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }

                System.out.print("Grade: ");
                String grade = scanner.nextLine();

                System.out.print("Section: ");
                String section = scanner.nextLine();

                try {
                    // Attempt to create the student object and add it to the system
                    Student student = new Student(name, id, email, grade, section);
                    attendanceSystem.addStudent(student);
                    System.out.println("Student added successfully!\n");
                    validInput = true;  // Exit the loop after successful input
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    // Allow the user to retry on exception
                }
            }
        }

        // Mark attendance for each student interactively
        for (int i = 0; i < 3; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Enter attendance for Student " + (i + 1) + ":");

                int studentId = -1;
                // Validate student ID to check if the student exists in the system
                while (studentId == -1) {
                    System.out.print("Enter student ID: ");
                    try {
                        studentId = Integer.parseInt(scanner.nextLine());
                        if (!attendanceSystem.studentExists(studentId)) {
                            throw new InvalidStudentIdException("Student ID does not exist.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a numeric ID.");
                    } catch (InvalidStudentIdException e) {
                        System.out.println(e.getMessage());
                    }
                }

                boolean isPresent = false;
                // Validate attendance (true/false)
                while (true) {
                    System.out.print("Is the student present? (true/false): ");
                    String attendanceInput = scanner.nextLine().toLowerCase();
                    if (attendanceInput.equals("true") || attendanceInput.equals("false")) {
                        isPresent = Boolean.parseBoolean(attendanceInput);
                        break; // valid input, exit the loop
                    } else {
                        System.out.println("Invalid input. Please enter true or false.");
                    }
                }

                try {
                    attendanceSystem.markAttendance(studentId, isPresent);
                    System.out.println("Attendance marked successfully!\n");
                    validInput = true;  // Exit the loop after valid input
                } catch (InvalidStudentIdException e) {
                    System.out.println("Error: " + e.getMessage());
                    // Retry if the student ID does not exist
                }
            }
        }

        // Generate attendance report
        System.out.println("\nAttendance Report:");
        attendanceSystem.generateAttendanceReport();

        // Simulate invalid data input (Invalid Email, Invalid Attendance)
        try {
            // Invalid email
            Student invalidStudent = new Student("Invalid", 456789, "invalid-email", "A", "B");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Invalid attendance data
            attendanceSystem.markAttendance(123456, false);  // Invalid attendance
        } catch (InvalidStudentIdException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
