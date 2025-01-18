package de.ait.homework30;

public class Letter extends MailItem {

    private boolean isRegistered;

    public Letter(String sender, String recipient, double weight, boolean isRegistered) {
        super(sender, recipient, weight);
        this.isRegistered = isRegistered;
    }

    @Override
    public double calculateShippingCost() {
        double shippingCost;
        if (isRegistered) {
            shippingCost = 10;
        } else {
            shippingCost = 5;
        }
        return shippingCost;
    }


    @Override
    public void printDetails() {
        System.out.println("Письмо:");
        super.printDetails();
        if (isRegistered) {
            System.out.println("Зарегистрированное: Да");
        } else {
            System.out.println("Зарегистрированное: Нет");
        }
    }
}
