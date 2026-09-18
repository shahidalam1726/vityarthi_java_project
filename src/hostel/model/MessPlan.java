package hostel.model;

public class MessPlan {
    private String planName; // Non-Veg, Veg, Special
    private double monthlyFee;

    public MessPlan(String planName, double monthlyFee) {
        this.planName = planName;
        this.monthlyFee = monthlyFee;
    }

    public String getPlanName() { return planName; }
    public double getMonthlyFee() { return monthlyFee; }
}