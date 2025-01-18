package de.ait.consultation;

public class Haircut extends Service{

  protected boolean includesStyling;

    public Haircut(String customerName, String serviceName, double basePrice, boolean includesStyling) {
        super(customerName, serviceName, basePrice);
        this.includesStyling = includesStyling;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice;
        if(includesStyling){
            totalCost = totalCost + 10;
        }
        return totalCost;
    }
}
