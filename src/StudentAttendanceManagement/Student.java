package StudentAttendanceManagement;

// Class Student (Inherits from Person)
class Student extends Person {
    private String grade;
    private String section;
    private double attendancePercentage;

    public Student(String name, int id, String email, String grade, String section) {
        super(name, id, email);  // Inherited constructor
        this.grade = grade;
        this.section = section;
        this.attendancePercentage = 0.0;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    // Method to update attendance
    public void updateAttendance(int daysPresent, int totalDays) throws InvalidAttendanceException {
        if (daysPresent < 0 || totalDays <= 0 || daysPresent > totalDays) {
            throw new InvalidAttendanceException("Invalid attendance data. Ensure days present is <= total days and both are positive.");
        }
        this.attendancePercentage = (double) daysPresent / totalDays * 100;
    }
}


