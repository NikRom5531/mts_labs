package org.romanov.lab.service;

import org.romanov.lab.entity.BankAtm;
import org.romanov.lab.entity.BankOffice;
import org.romanov.lab.entity.Employee;

/**
 * Интерфейс {@link AtmService} предоставляет методы для управления объектами {@link BankAtm}.
 */
public interface AtmService {
    /**
     * Создает новый объект {@link BankAtm} с предоставленными атрибутами.
     *
     * @param id                Уникальный идентификатор банкомата.
     * @param name              Название банкомата.
     * @param status            Статус банкомата (1 - работает, 2 - отсутствует деньги, 0 - не работает).
     * @param bankOffice        Офис банка, к которому привязан банкомат.
     * @param location          Местоположение банкомата.
     * @param servicingEmployee Сотрудник, ответственный за обслуживание банкомата.
     * @param cashWithdrawal    Указывает, поддерживает ли банкомат снятие наличных.
     * @param cashDeposit       Указывает, поддерживает ли банкомат внесение наличных.
     * @param maintenanceCost   Стоимость обслуживания банкомата.
     */
    void create(int id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    /**
     * Получает объект {@link BankAtm}.
     *
     * @return Объект {@link BankAtm}.
     */
    BankAtm read();

    /**
     * Обновляет существующий объект {@link BankAtm} с предоставленными атрибутами.
     *
     * @param id                Уникальный идентификатор банкомата.
     * @param name              Название банкомата.
     * @param status            Статус банкомата (1 - работает, 2 - отсутствует деньги, 0 - не работает).
     * @param bankOffice        Офис банка, к которому привязан банкомат.
     * @param location          Местоположение банкомата.
     * @param servicingEmployee Сотрудник, ответственный за обслуживание банкомата.
     * @param cashWithdrawal    Указывает, поддерживает ли банкомат снятие наличных.
     * @param cashDeposit       Указывает, поддерживает ли банкомат внесение наличных.
     * @param maintenanceCost   Стоимость обслуживания банкомата.
     */
    void update(int id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    /**
     * Удаляет объект {@link BankAtm} с указанным идентификатором.
     *
     * @param id Уникальный идентификатор банкомата для удаления.
     */
    void delete(int id);
}
