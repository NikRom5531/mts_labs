package org.romanov.lab.service;

import org.romanov.lab.entity.Bank;

/**
 * Интерфейс, предоставляющий методы для управления банками.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для банка.</p>
 */
public interface BankService {
    /**
     * Создает новый банк с указанными параметрами.
     *
     * @param id              Уникальный идентификатор банка.
     * @param name            Название банка.
     * @return                Созданный объект класса {@link Bank}.
     */
    Bank create(int id, String name);

    /**
     * Возвращает информацию о текущем банке.
     *
     * @param id    Уникальный идентификатор банка.
     * @return      Объект класса {@link Bank}.
     */
    Bank read(int id);

    /**
     * Обновляет информацию о существующем банке.
     *
     * @param id                Уникальный идентификатор банка.
     * @param name              Название банка.
     * @param quantityOffices   Количество офисов банка.
     * @param quantityATM       Количество банкоматов банка.
     * @param quantityEmployees Количество сотрудников банка.
     * @param quantityClients   Количество клиентов банка.
     * @param rating            Рейтинг банка.
     * @param totalMoney        Общая сумма денег в банке.
     */
    void update(int id, String name, int quantityOffices, int quantityATM, int quantityEmployees, int quantityClients, int rating, double totalMoney);

    /**
     * Удаляет банк по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор банка.
     */
    void delete(int id);
}
