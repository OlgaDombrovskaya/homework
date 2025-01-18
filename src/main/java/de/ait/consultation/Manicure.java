package de.ait.consultation;

public class Manicure extends Service{

    private boolean includesGelPolish;

    public Manicure(String customerName, String serviceName, double basePrice, boolean includesGelPolish) {
        super(customerName, serviceName, basePrice);
        this.includesGelPolish = includesGelPolish;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice;
        if(includesGelPolish){
            totalCost = totalCost + 15;
        }
        return totalCost;
    }
}
