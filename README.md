# 25945_Nsengiyumva_Christophe_Wednesday_evening
# Student Attendance Management System

## Description
This project is an implementation of a *Student Attendance Management System* using object-oriented programming principles. The system securely handles student details, tracks attendance, and generates reports using encapsulation, inheritance, and abstraction.

## Features
- Secure management of student and faculty information.
- Attendance tracking with validation and exception handling.
- Summary reports for attendance records.

## Requirements
### 1. *Encapsulation*
   - Private variables in the Student class for secure storage.
   - Getter and setter methods for controlled access.

### 2. *Inheritance*
   - A base class Person containing common attributes for Student and Faculty.
   - Student class extends Person with additional student-specific attributes.

### 3. *Abstraction/Interface*
   - Abstract class or interface IAttendanceManager with methods for attendance tracking.
   - Implementation in a concrete class AttendanceSystem.

## Class Details
### Person (Base Class)
- *Attributes:*
  - name: Full name (String)
  - id: Unique identifier (numeric, 6 digits)
  - email: Valid email address

- *Methods:*
  - Constructor to initialize attributes.
  - Getters and setters with validation:
    - id must be numeric and 6 digits.
    - email must follow a standard email format.

### Student (Derived Class)
- *Attributes:*
  - grade: Class grade (String)
  - section: Class section (String)
  - attendancePercentage: Attendance percentage (double)

- *Methods:*
  - Constructor to initialize student-specific and inherited attributes.
  - updateAttendance(daysPresent, totalDays):
    - Ensures daysPresent and totalDays are positive and daysPresent ≤ totalDays.
    - Throws InvalidAttendanceException for invalid inputs.
  - Getter for attendancePercentage.

### IAttendanceManager (Abstract Class/Interface)
- *Methods:*
  - markAttendance(studentId, isPresent: Boolean): Marks attendance for a given student.
  - getAttendance(studentId): Retrieves the attendance percentage of a student.
  - generateAttendanceReport(): Prints a summary of attendance for all students.

### AttendanceSystem (Concrete Class)
- *Attributes:*
  - Collection of students (e.g., Map<Integer, Student>).

- *Methods:*
  - Implements methods from IAttendanceManager:
    - markAttendance: Updates attendance for a student after validation.
    - getAttendance: Retrieves a student's attendance percentage.
    - generateAttendanceReport: Iterates through all students and prints a summary.

## Validation and Exception Handling
- *Email validation* using regex.
- Prevent negative or zero values for daysPresent or totalDays.
- Throw InvalidStudentIdException if studentId does not exist.
- Custom exception InvalidAttendanceException for invalid attendance inputs.

## Testing Scenario
1. Add at least three students to the system.
2. Mark attendance for each student over 30 days.
3. Test invalid inputs (e.g., invalid email, attendance over total days) and handle exceptions gracefully.

## Getting Started
### Prerequisites
- A Java development environment (JDK 8 or higher).
- IDE such as IntelliJ IDEA or Eclipse.

### Installation
1. Clone the repository:
    bash
    git clone https://github.com/your-username/student-attendance-management.git
    
2. Open the project in your IDE.
3. Build and run the application.

## Usage
1. Add students to the system.
2. Use markAttendance to update their attendance.
3. Generate attendance reports with generateAttendanceReport.

## Example Code
java
public class Main {
    public static void main(String[] args) {
        AttendanceSystem attendanceSystem = new AttendanceSystem();

        // Add students
        Student student1 = new Student("John Doe", 123456, "john.doe@example.com", "10th", "A");
        attendanceSystem.addStudent(student1);

        // Mark attendance
        attendanceSystem.markAttendance(123456, true);

        // Generate report
        attendanceSystem.generateAttendanceReport();
    }
}


## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

Author: NSENGIYUMVA Christophe
ID: 25945
