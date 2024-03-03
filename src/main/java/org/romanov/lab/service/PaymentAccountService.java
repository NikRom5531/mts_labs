package org.romanov.lab.service;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.PaymentAccount;
import org.romanov.lab.entity.User;

/**
 * Интерфейс, предоставляющий методы для управления платежными счетами в банке.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для платежного счета.</p>
 */
public interface PaymentAccountService {
    /**
     * Создает новый платежный счет с указанными параметрами.
     *
     * @param id      Уникальный идентификатор платежного счета.
     * @param user    Пользователь, которому принадлежит платежный счет.
     * @param bank    Банк, в котором открыт платежный счет.
     * @param balance Баланс платежного счета.
     * @return        Созданный объект класса {@link PaymentAccount}.
     */
    PaymentAccount create(int id, User user, Bank bank, double balance);

    /**
     * Возвращает информацию о текущем платежном счете.
     *
     * @param id    Уникальный идентификатор платежного счета.
     * @return      Объект класса {@link PaymentAccount}.
     */
    PaymentAccount read(int id);

    /**
     * Обновляет информацию о существующем платежном счете.
     */
    void update();

    /**
     * Удаляет платежный счет по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор платежного счета.
     */
    void delete(int id);
}
