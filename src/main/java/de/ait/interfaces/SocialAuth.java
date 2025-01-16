package de.ait.interfaces;

/**
 * Этот интерфейс определяет контракт для авторизации в социальных сетях.
 * Он предоставляет методы для авторизации, получения профилей пользователей и управления попытками входа.
 */
public interface SocialAuth {

    // Constant for the maximum number of login attempts
    // Константа для максимального количества попыток входа
    int MAX_LOGIN_ATTEMPTS = 3;

    /**
     * Авторизует пользователя, используя его учетные данные.
     *
     * @param userCredentials The credentials used for authentication. / Учетные данные для авторизации.
     */
    void authenticate(String userCredentials);

    /**
     * Возвращает профиль пользователя после успешной авторизации.
     *
     * @return A string representation of the user profile. / Строковое представление профиля пользователя.
     */
    String getUserProfile();

    /**
     * Проверяет, находится ли текущая попытка входа в пределах допустимого лимита.
     *
     * @param currentAttempts The number of login attempts made. / Количество совершенных попыток входа.
     * @return True if the attempt is allowed; false otherwise. / True, если попытка допустима, иначе false.
     */
    default boolean checkLoginAttempts(int currentAttempts) {
        return currentAttempts < MAX_LOGIN_ATTEMPTS;
    }

    /**
     * Выводит максимальное количество допустимых попыток входа.
     */
    static void printMaxLoginAttempts() {
        System.out.println("Максимально количество попыток входа: " + MAX_LOGIN_ATTEMPTS);
    }
}