package de.ait.abstractclass;

/**
 * Класс RegularUser расширяет класс User, представляя обычного пользователя. Обычные пользователи имеют ограниченные привилегии, такие как чтение новостей.
 */
public class RegularUser extends User {

    /**
     *  Конструктор Создаёт обычного пользователя с указанными именем и ID.
     */
    public RegularUser(String name, int id) {
        super(name, id);
    }

    /**
     * Выполняет действие, специфичное для обычных пользователей, такое как чтение новостей.
     */
    @Override
    public void performAction() {
        System.out.println(getName() + " read news");
    }
}