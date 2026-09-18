package hostel.model;

public class Student {
    private String studentId;
    private String name;
    private int academicYear;
    private double gpa;
    private String preferredRoomType;
    private MessPlan messPlan;

    public Student(String studentId, String name, int academicYear, double gpa, String preferredRoomType, MessPlan messPlan) {
        this.studentId = studentId;
        this.name = name;
        this.academicYear = academicYear;
        this.gpa = gpa;
        this.preferredRoomType = preferredRoomType;
        this.messPlan = messPlan;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAcademicYear() { return academicYear; }
    public double getGpa() { return gpa; }
    public String getPreferredRoomType() { return preferredRoomType; }
    public MessPlan getMessPlan() { return messPlan; }
    public void setMessPlan(MessPlan messPlan) { this.messPlan = messPlan; }

    public double calculatePriorityScore() {
        // Priority calculated using academic year weightage and GPA
        return (academicYear * 10) + (gpa * 5);
    }
}