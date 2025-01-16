package de.ait.homework28;

public class PremiumUser extends User {

    private int subscriptionEndDate; // (дата окончания подписки)

    public PremiumUser(String id, String name, String email, int subscriptionEndDate) {
        super(id, name, email);
        this.subscriptionEndDate = subscriptionEndDate;
    }

    @Override
    public void printInfo() {
        super.printInfo(); // обязательно, иначе будет крутить до бесконечности
        System.out.println("Id: " + id + ", Name: " + name + ", Email: " + email
                + ", Дата окончания подписки: " + subscriptionEndDate + ", Тип пользователя - Premium ");
    }

    public boolean isSubscriptionActive() {
        int currentDate = 2025;

        return subscriptionEndDate >= currentDate;
    }
}