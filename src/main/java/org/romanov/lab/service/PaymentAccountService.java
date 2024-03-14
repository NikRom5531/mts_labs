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
     */
    void create(long id, User user, Bank bank, double balance);

    /**
     * Возвращает информацию о текущем платежном счете.
     *
     * @param id    Уникальный идентификатор платежного счета.
     * @return      Объект класса {@link PaymentAccount}.
     */
    PaymentAccount read(long id);

    /**
     * Обновляет информацию о существующем платежном счете.
     *
     * @param id                Уникальный идентификатор платежного счета.
     * @param paymentAccount    Объект класса {@link PaymentAccount}.
     */
    void update(long id, PaymentAccount paymentAccount);

    /**
     * Удаляет платежный счет по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор платежного счета.
     */
    void delete(long id);
}
