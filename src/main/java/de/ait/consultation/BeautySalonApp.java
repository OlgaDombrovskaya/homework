package de.ait.consultation;

public class BeautySalonApp {

    public static void main(String[] args) {
        BeautySalon beautySalon = new BeautySalon();

        // Добавляем услуги в салон красоты / Add services to the beauty salon
        Service serviceEmilyClark = new Haircut("Эмили Кларк", "Стрижка", 40, true);
        beautySalon.addService(serviceEmilyClark);

        Service serviceJohnDoe = new Manicure("Джон Доу", "Маникюр", 40, false);
        beautySalon.addService(serviceJohnDoe);

        Service serviceAnnaSmith = new Facial("Анна Смит", "Уход за лицом", 50, 70, 0);
        beautySalon.addService(serviceAnnaSmith);

        // Печатаем квитанции для всех услуг / Print receipts for all services
        beautySalon.printAllReceipts();
    }
}
