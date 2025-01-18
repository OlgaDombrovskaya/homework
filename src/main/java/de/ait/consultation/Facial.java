package de.ait.consultation;

public class Facial  extends Service implements Discountable{

    private int duration;

    private double discountResultPrice;

    public Facial(String customerName, String serviceName, double basePrice, int duration, double discountResultPrice) {
        super(customerName, serviceName, basePrice);
        this.duration = duration;
        this.discountResultPrice = 0;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice + duration;//30 + 90 = 120 (120 - 10 %)
        if(duration > 60){
            totalCost = applyDiscount(totalCost);
            this.discountResultPrice = (basePrice + duration) - totalCost;
        }
        return totalCost;
    }

    @Override
    public double applyDiscount(double totalCost) {
        return totalCost * 0.9; // 10% discount
    }

    public double getDiscountResultPrice() {
        return discountResultPrice;
    }
}
