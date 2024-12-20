package StudentAttendanceManagement;

// Interface for Attendance Management
interface IAttendanceManager {
    void markAttendance(int studentId, boolean isPresent) throws InvalidStudentIdException;
    double getAttendance(int studentId) throws InvalidStudentIdException;
    void generateAttendanceReport();
}
