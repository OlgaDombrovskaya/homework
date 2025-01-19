package de.ait.homework30;

public abstract class MailItem  {

    protected String sender;
    protected String recipient;
    protected double weight;

    public MailItem(String sender, String recipient, double weight) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
    }

    public abstract double calculateShippingCost();//абстрактный метод для расчета стоимости доставки.

    public void printDetails() {
        System.out.println("Отправитель: " + sender);
        System.out.println("Получатель: " + recipient);
        System.out.println("Вес: " + weight + " кг");
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}
