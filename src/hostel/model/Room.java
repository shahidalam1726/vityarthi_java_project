package hostel.model;

public class Room {
    private String roomNumber;
    private String roomType; // Single, Double, Deluxe
    private double feePerSemester;
    private boolean isAllocated;
    private String assignedStudentId;

    public Room(String roomNumber, String roomType, double feePerSemester) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.feePerSemester = feePerSemester;
        this.isAllocated = false;
        this.assignedStudentId = null;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getFeePerSemester() { return feePerSemester; }
    public boolean isAllocated() { return isAllocated; }
    public String getAssignedStudentId() { return assignedStudentId; }

    public void allocateTo(String studentId) {
        this.isAllocated = true;
        this.assignedStudentId = studentId;
    }

    public void deallocate() {
        this.isAllocated = false;
        this.assignedStudentId = null;
    }
}