package org.romanov.lab.service;

import org.romanov.lab.entity.*;

import java.time.LocalDate;

/**
 * Интерфейс, предоставляющий методы для управления кредитными счетами.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для кредитного счета.</p>
 */
public interface CreditAccountService {
    /**
     * Создает новый кредитный счет с указанными параметрами.
     *
     * @param id              Уникальный идентификатор кредитного счета.
     * @param user            Пользователь, за которым закреплен кредитный счет.
     * @param bank            Банк, в котором открыт кредитный счет.
     * @param startDate       Дата начала кредита.
     * @param months          Количество месяцев, на которые взят кредит.
     * @param loanAmount      Сумма кредита.
     * @param interestRate    Процентная ставка кредита.
     * @param issuingEmployee Сотрудник, который выдал кредит.
     * @param paymentAccount  Платежный счет для погашения кредита.
     */
    void create(long id, User user, Bank bank, LocalDate startDate, int months, double loanAmount, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount);

    /**
     * Возвращает информацию о текущем кредитном счете.
     *
     * @param id    Уникальный идентификатор кредитного счета.
     * @return      Объект класса {@link CreditAccount}.
     */
    CreditAccount read(long id);

    /**
     * Обновляет информацию о существующем кредитном счете.
     *
     * @param id                Уникальный идентификатор кредитного счета.
     * @param creditAccount     Объект класса {@link CreditAccount}.
     */
    void update(long id, CreditAccount creditAccount);

    /**
     * Удаляет кредитный счет по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор кредитного счета.
     */
    void delete(long id);
}
