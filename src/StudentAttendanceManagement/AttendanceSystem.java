package StudentAttendanceManagement;
import java.util.*;
import java.util.regex.*;
import java.util.Scanner;

// Concrete class for managing attendance
class AttendanceSystem implements IAttendanceManager {
    private Map<Integer, Student> studentMap;

    public AttendanceSystem() {
        studentMap = new HashMap<>();
    }

    @Override
    public void markAttendance(int studentId, boolean isPresent) throws InvalidStudentIdException {
        Student student = studentMap.get(studentId);
        if (student == null) {
            throw new InvalidStudentIdException("Student ID not found.");
        }

        // Simulate attendance for the day
        int totalDays = 30;
        int daysPresent = isPresent ? 1 : 0; // If present, mark 1, else 0
        try {
            student.updateAttendance(daysPresent, totalDays);
        } catch (InvalidAttendanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public double getAttendance(int studentId) throws InvalidStudentIdException {
        Student student = studentMap.get(studentId);
        if (student == null) {
            throw new InvalidStudentIdException("Student ID not found.");
        }
        return student.getAttendancePercentage();
    }

    @Override
    public void generateAttendanceReport() {
        for (Student student : studentMap.values()) {
            System.out.println("Student: " + student.getName() + ", ID: " + student.getId() + ", Attendance: " + student.getAttendancePercentage() + "%");
        }
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    // Method to check if a student exists in the system
    public boolean studentExists(int studentId) {
        return studentMap.containsKey(studentId); // Checks if the student ID is present in the map
    }
}
