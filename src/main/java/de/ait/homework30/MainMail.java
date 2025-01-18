package de.ait.homework30;

public class MainMail {
    public static void main(String[] args) {

        PostOffice postOffice = new PostOffice();

        // Создаем объекты различных типов отправлений
        MailItem letter = new Letter("Leonardo DiCaprio", "Brad Pitt", 0.05, true);
        MailItem mailPackage = new Package("Scarlett Johansson", "Chris Hemsworth", 2.5, 30, 20, 15);
        MailItem advertisement = new Advertisement("Tom Cruise", "Все жители Голливуда", 0.1, 100);

        // Добавляем отправления в почтовый офис
        postOffice.addMailItem(letter);
        postOffice.addMailItem(mailPackage);
        postOffice.addMailItem(advertisement);

        // Выводим информацию обо всех отправлениях
        postOffice.printAllDetails();

        // Рассчитываем общую стоимость доставки
        postOffice.calculateTotalShippingCost();
    }
}
