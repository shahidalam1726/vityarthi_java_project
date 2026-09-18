package hostel.service;

import hostel.model.Room;
import hostel.model.Student;

public class BillingService {

    public static double calculateTotalInvoice(Student student, Room room, int durationMonths) {
        double roomCost = room != null ? room.getFeePerSemester() : 0.0;
        double messCost = student.getMessPlan() != null ? (student.getMessPlan().getMonthlyFee() * durationMonths) : 0.0;
        return roomCost + messCost;
    }

    public static String generateReceipt(Student student, Room room, int durationMonths) {
        double roomFee = room != null ? room.getFeePerSemester() : 0.0;
        double messFee = student.getMessPlan() != null ? (student.getMessPlan().getMonthlyFee() * durationMonths) : 0.0;
        double total = roomFee + messFee;

        return "=== INVOICE RECEIPT ===\n" +
               "Student ID: " + student.getStudentId() + "\n" +
               "Name: " + student.getName() + "\n" +
               "Room Assigned: " + (room != null ? room.getRoomNumber() : "None") + " ($" + roomFee + ")\n" +
               "Mess Plan: " + (student.getMessPlan() != null ? student.getMessPlan().getPlanName() : "None") + " ($" + messFee + ")\n" +
               "-----------------------\n" +
               "Total Payable: $" + total + "\n";
    }
}