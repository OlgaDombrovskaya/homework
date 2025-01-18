package de.ait.homework30;

public class Package extends MailItem {

    private double length;//длина
    private double width;//ширина
    private double height;//высота

    public Package(String sender, String recipient, double weight, double length, double width, double height) {
        super(sender, recipient, weight);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateShippingCost() {
        if (weight <= 0) {
            return 0;
        } else {
            return weight * 2;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Посылка:");
        super.printDetails();
        System.out.println("Размеры: " + length + " x " + width + " x " + height + " см");
    }
}
