package de.ait.homework32;

public class RoomBooking {

    private static int[] rooms = {101, 102, 103, 201, 202};
    private static String[] guests = new String[5];

    private static void addGuest(int roomIndex, String guestName) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (roomIndex < 0 || roomIndex >= rooms.length) { // Проверка корректности индекса комнаты
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс комнаты: " + roomIndex);
        }
        if (guestName == null || guestName.trim().isEmpty()) { // Проверка корректности имени гостя
            throw new IllegalArgumentException("Некорректное имя гостя" + guestName);
        }

        guests[roomIndex] = guestName;  // Добавление имени гостя в массив
        System.out.println("Гость " + guestName + " добавлен в комнату " + rooms[roomIndex]);
    }

    public static String getGuest(int roomIndex) throws ArrayIndexOutOfBoundsException, NoGuestException {
        if (roomIndex < 0 || roomIndex >= rooms.length) { // Проверка корректности индекса комнаты
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс комнаты: " + roomIndex);
        }
        // Проверка, есть ли гость в указанной комнате
        if (guests[roomIndex] == null) {
            throw new NoGuestException("В комнате " + rooms[roomIndex] + " нет гостя.");
        }
        // Возвращаем имя гостя
        return guests[roomIndex];
    }

    public static void main(String[] args) {
        try {

            addGuest(0, "Кирилл Иванов");   // Тестирование корректных данных
            addGuest(1, "Светлана Петрова");

            addGuest(9, "Денис Сидоров"); // Некорректный индекс
            addGuest(4, ""); // пустое имя

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Ошибка");
        }

        try {
            // Тестирование получения гостя из комнаты
            System.out.println("Гость в комнате 1: " + getGuest(0));
            System.out.println("Гость в комнате 2: " + getGuest(1));

            // Тестирование получения гостя из пустой комнаты
            System.out.println("Гость в комнате 3: " + getGuest(4));  // Здесь гость отсутствует
        } catch (ArrayIndexOutOfBoundsException | NoGuestException e) {
            System.out.println("Ошибка");
        }
    }
}